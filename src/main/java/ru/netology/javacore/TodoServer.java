package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    protected int port;
    protected Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {

                    Gson gson = new Gson();
                    Scanner scanner = new Scanner(System.in);
                    Request request = gson.fromJson(in.readLine(), Request.class);
                    if (request.getType().equals("ADD")){
                        todos.addTask(request.getTask());
                    } else if (request.getType().equals("REMOVE")) {
                        todos.removeTask(request.getTask());
                    }
                }
                System.out.println(todos.getAllTasks());
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

}
