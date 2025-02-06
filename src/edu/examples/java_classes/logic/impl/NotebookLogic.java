package edu.examples.java_classes.logic.impl;

import edu.examples.java_classes.logic.NotebookLogicException;

import java.time.LocalDateTime;

public interface NotebookLogic {
    void add(String header, String text, LocalDateTime creationDate) throws NotebookLogicException;
}
