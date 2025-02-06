package edu.examples.java_classes.dao;

import java.io.IOException;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	List<Object> save(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;

	void add(Note note) throws DaoException;

	void delete(int index);

	void save();
}
