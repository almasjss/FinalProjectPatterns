package com.company;

public class Main {

    public static void main(String[] args) {
        App application = new App();
        System.out.println("************************");
        application.addDefaultValues();
        application.addDefault();
        application.start();
        System.out.println("************************");
    }
}
