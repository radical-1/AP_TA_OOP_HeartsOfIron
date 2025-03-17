import view.SignupMenuView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/input.txt"));
//        Scanner scanner = new Scanner(System.in);
        SignupMenuView.run(scanner);
    }
}