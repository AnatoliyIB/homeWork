package homeWork.View;

import java.util.Scanner;

public class ConsoleView implements MainView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
