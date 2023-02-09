package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private LinkedList<String> taskList = new LinkedList<>();
    private static final int listSize = 7;

    public void addTask(String task) {
        if (taskList.size() < listSize){
            taskList.add(task);
        }
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String getAllTasks() {
        return taskList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }

}
