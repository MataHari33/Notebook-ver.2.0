package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

    public void save(Note n) throws DaoException {
        FileWriter pen = null;
        try {
            pen = new FileWriter("notebook.txt", true);
            pen.write("Title: " + n.getTitle() + "\n");
            pen.write("Content: " + n.getContent() + "\n");
            pen.write("Date: " + n.getD() + "\n");
            pen.write("******************************\n");
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            if (pen != null) {
                try {
                    pen.close();
                } catch (IOException e) {
                    throw new DaoException(e);
                }
            }
        }
    }

    @Override
    public List<Note> allNotes() throws DaoException {
        List<Note> notes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("notebook.txt"));
            Note note = null;
            String ln;
            while ((ln = reader.readLine()) != null) {
                if (ln.startsWith("Title: ")) {
                    note = new Note();
                    note.setTitle(ln.substring(7));
                } else if (ln.startsWith("Content: ")) {
                    note.setContent(ln.substring(9));
                } else if (ln.startsWith("Date: ")) {
                    SimpleDateFormat format = new SimpleDateFormat();
                    format.applyPattern("yyyy-mm-dd");
                    note.setD(format.parse(ln.substring(6)));
                } else if (ln.equals("******************************")) {
                    notes.add(note);
                }
            }
            return notes;
        } catch (ParseException e) {
            System.out.println("Error parse line" + e.getMessage());
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notes;
    }

    @Override
    public void add(Note note) throws DaoException {
        save(note);
    }
}
