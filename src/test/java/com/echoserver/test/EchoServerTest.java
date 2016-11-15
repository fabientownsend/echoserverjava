package com.echoserver.test;

import com.echoserver.EchoServer;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {
    private EchoServer server = null;
    private StringWriter out = null;

    @Test
    public void exitTheEchoServerWithoutOutput() throws IOException {
        initialiseEcheServerWithInput("exit\n");
        server.run();

        assert out.toString().equals("");
    }

    @Test
    public void displayInputUntilExit() throws IOException {
        initialiseEcheServerWithInput("Hello\nWorld\nexit\n");
        server.run();

        assert out.toString().equals("Hello\nWorld\n");
    }

    private void initialiseEcheServerWithInput(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        server = new EchoServer(input, output);
    }
}