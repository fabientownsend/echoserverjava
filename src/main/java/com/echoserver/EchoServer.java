package com.echoserver;

public class EchoServer {
  private final String name;

  public EchoServer(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
