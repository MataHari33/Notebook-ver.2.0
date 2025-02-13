package edu.examples.java_classes.dao;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	void save(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;

	void add(Note note) throws DaoException;

}
