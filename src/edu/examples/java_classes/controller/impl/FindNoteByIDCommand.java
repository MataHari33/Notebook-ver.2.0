package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.logic.NotebookLogicException;

public class FindNoteByIDCommand implements Command {
    public String execute(String request) {
        final LogicProvider logicProvider = LogicProvider.getInstance();
        final NotebookLogic logic = logicProvider.getNotebookLogic();

        String response = null;
        String[] params;

        // validate request
        params = request.split("\n");
        try {
            System.out.println(params[1].split("=")[1] + " параметр");

            Note result = logic.find(params[1].split("=")[1]);
            if (result != null) {
                response = "Found note with ID " + Integer.parseInt(params[1].split("=")[1]) + " successfully.";
            } else {
                response = "Note with ID " + Integer.parseInt(params[1].split("=")[1]) + " not found.";
            }
        } catch (NotebookLogicException e) {
            response = "Error occured when finding a note by ID.";
        }
        return response;
    }
}
