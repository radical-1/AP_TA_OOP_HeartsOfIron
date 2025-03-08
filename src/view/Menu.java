package view;

import java.util.Scanner;

public interface Menu {
    static void showCurrentMenu() {}

    static void run(Scanner scanner) {}

    static void exit() {

    }

    static void invalidCommand() {
        System.out.println("invalid command");
    }
}