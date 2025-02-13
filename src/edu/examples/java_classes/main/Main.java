package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.CommandException;
import edu.examples.java_classes.controller.Controller;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();

        String request = "ADD\ntitle=Энциклопедия\nсоntent=Мир вод";
        String response = controller.doAction(request);
        System.out.println(response);

        request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды 2.0\ndate=2023-08-08";
        response = controller.doAction(request);
        System.out.println(response);

        request = "FINDBYDATE\ndate=2023-08-08";
        response = controller.doAction(request);
        System.out.println(response);

        request = "FINDBYID\nid=2";
        response = controller.doAction(request);
        System.out.println(response);
    }
}

