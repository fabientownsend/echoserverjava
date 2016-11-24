package com.echoserver;

import java.io.*;

public class EchoServer {
    private final BufferedReader input;
    private final PrintWriter output;
    private final String EXIT = "exit";
    private final String ERROR = "Error";
    private final String CTRLCMESSAGE = "\nOk bye";

    public EchoServer(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        ctrlCHandler();

        try {
            displayInput();
        } catch (IOException e) {
            write(ERROR);
        }
    }

    private void ctrlCHandler() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                write(CTRLCMESSAGE);
            }
        }));
    }

    private void displayInput() throws IOException {
        String value = read();

        while (!value.equals(EXIT)) {
            write(value);
            value = read();
        }
    }

    private void write(String input) {
        output.println(input);
    }

    private String read() throws IOException {
        return input.readLine();
    }
}
