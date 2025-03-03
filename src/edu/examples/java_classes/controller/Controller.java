package edu.examples.java_classes.controller;

import edu.examples.java_classes.controller.CommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

   // final Pattern PATTERN = Pattern.compile("^\\w\\n + $");

    public String doAction(String request)  {
/*
        Matcher m = PATTERN.matcher(request);
        boolean b = m.matches();
        if (!b) {
            throw new CommandException("Command " + request + " is out of format");
        }
*/
        char paramDelimeter = '\n';
        String commandName = request.substring(0, request.indexOf(paramDelimeter));
        Command executionCommand = provider.getCommand(commandName.toUpperCase());//ADD
        //System.out.println(provider.getCommand(commandName.toUpperCase()));
        String response;
        try {
            response = executionCommand.execute(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}


