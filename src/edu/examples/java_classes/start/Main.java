package edu.examples.java_classes.start;

import edu.examples.java_classes.controller.CommandException;
import edu.examples.java_classes.controller.Controller;

import java.util.List;


public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();

		String request;
		String response;
		request = "ADD\ntitle=Книга\nсоntent=Туманностьdf Андромеды";
        try {
            response = controller.doAction(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);

		request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08";
        try {
            response = controller.doAction(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
	}
}
