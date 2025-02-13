package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.logic.NotebookLogicException;

import static java.awt.SystemColor.text;

public class NotebookLogicImpl implements NotebookLogic {
    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    public void add(Note n) throws NotebookLogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }

    public void add(String title, String content) throws NotebookLogicException {
        Note n = new Note(title, content);
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }

    public void update(int id, String title, String content) throws NotebookLogicException {
        Note n = find(id);
        // Note n = new Note(title, content);
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }

    public Note find(String id) throws NotebookLogicException {
        //List<Note> result = new ArrayList<Note>();
        Note result = new Note();
        //NoteBookDao dao = new NoteBookDao();
        try {
            List<Note> myNotes = dao.allNotes();
            for (Note n : myNotes) {
                if (text.equals(String.valueOf(n.getId()))) {
                    result = n;
                }
                //	if(isTextInNote(n, text)) {
                //		result.add(n);
                //	}
            }
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
        return result;
    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }


    public Note find(Date date) throws NotebookLogicException {
        Note result = new Note();
        try {
            List<Note> allNotes = dao.allNotes();
            for (Note note : allNotes) {
                if (note.getD() != null || note.getD().equals(date)) {
                    result = note;
                }
            }
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
        return result;
    }

    public Note find(int id) throws NotebookLogicException {
        Note result = new Note();
        try {
            List<Note> allNotes = dao.allNotes();
            for (Note note : allNotes) {
                if (note.getId() == id) {
                    result = note;
                }
            }
            return result;
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }

    public List<Note> allNotes() throws NotebookLogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }
}
