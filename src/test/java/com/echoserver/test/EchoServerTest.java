package com.echoserver.test;

import com.echoserver.EchoServer;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {
    private EchoServer server = null;
    private StringWriter out = null;

    @Before
    public void initialize() {
        final String text = "Hello\nWorld\nexit\n";
        BufferedReader input = new BufferedReader(new StringReader(text));

        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);
        server = new EchoServer(input, output);
    }

    @Test
    public void getTheInputFromTheEchoServer() throws IOException {
        assert server.read().equals("Hello");
        assert server.read().equals("World");
    }

    @Test
    public void getThePrintedValueInThenEchoServer() throws IOException {
        server.write("Hello");
        assert out.toString().equals("Hello\n");
    }

    @Test
    public void existTheEchoServerWhenInputIsExit() throws IOException {
        server.run();
        assert out.toString().equals("Hello\nWorld\n");
    }
}