package com.salesapp.backend;

import java.io.PrintStream;

public class HelloArquillian {

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
