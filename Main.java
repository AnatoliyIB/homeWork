package homeWork;

import homeWork.Presenter.MainPresenter;
import homeWork.View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        MainPresenter presenter = new MainPresenter(view);

        boolean running = true;
        while (running) {
            System.out.println("1. Add Person");
            System.out.println("2. Show Family Tree");
            System.out.println("3. Save Family Tree");
            System.out.println("4. Load Family Tree");
            System.out.println("5. Exit");

            String choice = view.getInput("Choose an option: ");
            switch (choice) {
                case "1":
                    int id = Integer.parseInt(view.getInput("Enter ID: "));
                    String name = view.getInput("Enter Name: ");
                    String birthDate = view.getInput("Enter Birth Date (YYYY-MM-DD): ");
                    presenter.addPerson(id, name, birthDate);
                    break;
                case "2":
                    presenter.showFamilyTree();
                    break;
                case "3":
                    presenter.saveFamilyTree();
                    break;
                case "4":
                    presenter.loadFamilyTree();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid option. Try again.");
            }
        }
    }
}
