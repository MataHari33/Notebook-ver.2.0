package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.logic.NotebookLogicException;

public class UpdateNoteCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) throws CommandException {
		String response = null;
		String[] params;
		Note newNote;

		// validate request
		params = request.split("\n");
		String title = params[2].split("=")[1];
		String content =  params[3].split("=")[1];

		newNote = new Note(title, content);

		newNote.setId(Integer.parseInt(params[1].split("=")[1]));
		newNote.setTitle(title);
		newNote.setContent(content);

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-mm-dd");
		Date date;
		try {
			date = format.parse(params[4].split("=")[1]);
			newNote.setD(date);

			logic.add(newNote);
			response = "Запись обновлена успешно.";
		} catch (ParseException e) {
			//e.printStackTrace();
			response = "Запись не обновлена.";
		} catch (DaoException | NotebookLogicException e) {
            throw new CommandException(e);
        }

        return response;
	}

}
