package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.logic.NotebookLogicException;

public class NotebookLogicImpl implements NotebookLogic {
	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();

	public void add(Note n) throws NotebookLogicException {
        try {
            dao.save(n);
        } catch ( DaoException e) {
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

	public void update(String title, String content) throws NotebookLogicException {
		Note n = new Note(title, content);
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }


	public List<Note> find(String text) throws NotebookLogicException{
		List<Note> result = new ArrayList<Note>();

		//NoteBookDao dao = new NoteBookDao();
        List<Note> myNotes = null;
        try {
            myNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }

        for(Note n : myNotes) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		return result;
	}

	private boolean isTextInNote(Note n, String text) {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}


	public List<Note> find(Date date) throws NotebookLogicException {
		List<Note> result = new ArrayList<Note>();
        List<Note> allNotes = null;
        try {
            allNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
        for (Note note:allNotes) {
			if (note.getD() != null || note.getD().equals(date)) {
				result.add(note);
			}
		}
		return result;
	}
	public List<Note> find(int id) throws NotebookLogicException {
		List<Note> result = new ArrayList<Note>();
        List<Note> allNotes = null;
        try {
            allNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
        for (Note note:allNotes) {
			if (note.getId()==id) {
				result.add(note);
			}
		}
		return result;
	}

	public List<Note> allNotes() throws NotebookLogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new NotebookLogicException(e);
        }
    }
}
