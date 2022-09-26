package com.mvc.was;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
        System.out.println("Aa");
    }
}
