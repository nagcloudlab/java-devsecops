package com.example;

import com.example.container.WebContainer;

public class Application {
    public static void main(String[] args) {


        WebContainer webContainer = new WebContainer();
        webContainer.handleRequest("/transfer");

    }
}
