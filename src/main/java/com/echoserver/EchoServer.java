package com.echoserver;

import java.io.*;

public class EchoServer {
    private final BufferedReader input;
    private final PrintWriter output;

    public EchoServer(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public void write(String input) {
        output.println(input);
    }

    public String read() throws IOException {
        return input.readLine();
    }

    public void run() {
        try {
            String value = read();

            while (!value.equals("exit")) {
                write(value);
                value = read();
            }
        } catch (Exception e) {
        }
    }
}
