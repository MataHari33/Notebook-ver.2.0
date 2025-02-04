package edu.examples.java_classes.logic;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

	public void add(Note n) throws NotebookLogicException, DaoException;

	public void add(String title, String content) throws NotebookLogicException, DaoException;

	public List<Note> find(String text) throws NotebookLogicException, DaoException;

	public List<Note> find(Date date) throws NotebookLogicException, DaoException;

	public List<Note> allNotes() throws NotebookLogicException, DaoException;
}
