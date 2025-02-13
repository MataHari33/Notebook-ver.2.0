package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.logic.NotebookLogicException;

public class AddNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request)  {
		String response = null;
		String[] params;
		Note newNote;
		try {

			// validate request
			params = request.split("\n");
			newNote = new Note();
			newNote.setTitle(params[1].split("=")[1]);
			newNote.setContent(params[2].split("=")[1]);
			logic.add(newNote);
			response = "Note " + newNote.getContent() + " saved successfully.";
		} catch (NotebookLogicException e) {
			response = "Note not saved.";
		}
			return response;
	}
}