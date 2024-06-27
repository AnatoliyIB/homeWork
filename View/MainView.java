package homeWork.View;

import homeWork.Model.Person;
import homeWork.Presenter.MainPresenter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainView {
    private MainPresenter presenter;
    private Scanner scanner;

    public MainView() {
        presenter = new MainPresenter();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            handleUserChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить Персону");
        System.out.println("2. Показать Дерево");
        System.out.println("3. Загрузить");
        System.out.println("4. Сохранить");
        System.out.println("5. Сортировать по Имени");
        System.out.println("6. Сортировать по Дате Рождения");
        System.out.println("7. Выход");
        System.out.print("Выберите опцию: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();  // Потребление новой строки
        return choice;
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addPerson();
                break;
            case 2:
                showTree();
                break;
            case 3:
                loadTree();
                break;
            case 4:
                saveTree();
                break;
            case 5:
                sortByName();
                break;
            case 6:
                sortByBirthDate();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
        }
    }

    private void addPerson() {
        System.out.print("Введите ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Потребление новой строки
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDateString = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateString);

        Person person = new Person(id, name, birthDate);
        presenter.addPerson(person);

        System.out.print("Есть ли у этой персоны дети? (да/нет): ");
        String hasChildren = scanner.nextLine();
        if (hasChildren.equalsIgnoreCase("да")) {
            System.out.print("Введите ID ребенка: ");
            int childId = scanner.nextInt();
            presenter.addChild(id, childId);
        }

        System.out.println("Персона добавлена!");
    }

    private void showTree() {
        String familyTreeInfo = presenter.getFamilyTreeInfo();
        System.out.println(familyTreeInfo);
    }

    private void loadTree() {
        System.out.print("Введите имя файла для загрузки: ");
        String filename = scanner.nextLine();
        File file = new File(filename);
        try {
            presenter.loadFamilyTreeFromFile(file);
            System.out.println("Дерево загружено!");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ошибка загрузки дерева!");
        }
    }

    private void saveTree() {
        System.out.print("Введите имя файла для сохранения: ");
        String filename = scanner.nextLine();
        File file = new File(filename);
        try {
            presenter.saveFamilyTreeToFile(file);
            System.out.println("Дерево сохранено!");
        } catch (IOException ex) {
            System.out.println("Ошибка сохранения дерева!");
        }
    }

    private void sortByName() {
        presenter.sortByName();
        System.out.println("Дерево отсортировано по имени!");
    }

    private void sortByBirthDate() {
        presenter.sortByBirthDate();
        System.out.println("Дерево отсортировано по дате рождения!");
    }
}
