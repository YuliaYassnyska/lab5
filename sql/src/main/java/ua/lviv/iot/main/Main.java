package ua.lviv.iot.main;

import ua.lviv.iot.view.View;

public class Main {
    public static void main(String[] args) {
        try {
            new View().show();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

} 
