package com.echoserver.test;

import com.echoserver.EchoServer;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {
    private EchoServer server;
    private StringWriter out;

    @Test
    public void exitTheEchoServerWithoutOutput() throws IOException {
        initialiseEchoServerWithInput("exit\n");
        server.run();

        assertEquals(out.toString(), "");
    }

    @Test
    public void displayInputUntilExit() throws IOException {
        initialiseEchoServerWithInput("Hello\nWorld\nexit\n");
        server.run();

        assertEquals(out.toString(), "Hello\nWorld\n");
    }

    private void initialiseEchoServerWithInput(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        server = new EchoServer(input, output);
    }
}