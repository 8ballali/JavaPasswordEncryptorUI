package org.example;

import pages.MainPage;
import pages.DataPassword;

public class Main {
    public static void main(String[] args) {
        DataPassword.loadCSVData();
        new MainPage("Aplikasi Password Vault", 80).draw();
        DataPassword.saveCSVData();
    }
}