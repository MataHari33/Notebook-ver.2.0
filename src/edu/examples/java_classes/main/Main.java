package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.CommandException;
import edu.examples.java_classes.controller.Controller;
public class Main {

	public static void main(String[] args) throws CommandException{
		Controller controller = new Controller();

		String request;
		String response;
        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);


        request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08";
        response = controller.doAction(request);
        System.out.println(response);

		request = "FIND\nid=2";
        try {
            response = controller.doAction(request);
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
	}
    }

