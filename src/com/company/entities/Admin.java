package com.company.entities;

public class Admin {

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "Qwerty123!";

    private static Admin instance;

    private Admin() {
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        return username.equals(ADMIN_LOGIN) && password.equals(ADMIN_PASSWORD);
    }
}
