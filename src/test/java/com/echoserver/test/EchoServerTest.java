
package com.echoserver.test;

import com.echoserver.EchoServer;
import org.junit.Test;

public class EchoServerTest {
    @Test
    public void test() {
        EchoServer server = new EchoServer("my server");
        assert server.getName().equals("my server");
    }
}