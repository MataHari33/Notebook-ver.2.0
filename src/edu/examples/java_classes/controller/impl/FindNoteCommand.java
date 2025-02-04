package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class FindNoteCommand implements Command {
    public String execute(String request) throws CommandException{
        final LogicProvider logicProvider = LogicProvider.getInstance();
        final NotebookLogic logic = logicProvider.getNotebookLogic();

        String response = null;
        String[] params;
        List<Note> result;

        // validate request
        params = request.split("\n");
        result = new ArrayList<Note>();
        //newNote.setId(Integer.parseInt(params[1].split("=")[1]));
        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-mm-dd");

            result = logic.find(format.parse(params[1].split("=")[1]));
            response = "Найдена запись c ID "+Integer.parseInt(params[1].split("=")[1])+" успешно.";
        } catch (Exception e) {
            //e.printStackTrace();
            return "Error occured when finding a note "; //+ e.getMessage();
        }
        return response;
    }
}