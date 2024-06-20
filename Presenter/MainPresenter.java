package homeWork.Presenter;

import homeWork.Model.FamilyTree;
import homeWork.Model.FileManager;
import homeWork.Model.FamilyTreeFileManager;
import homeWork.View.MainView;
import homeWork.Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Класс презентера для управления взаимодействием между моделью и представлением
public class MainPresenter<T extends Comparable<T>> {
    private MainView view;
    private FamilyTree<T> familyTree;
    private FileManager fileManager;
    private List<T> allPersons;

    // Конструктор класса
    public MainPresenter(MainView view, FamilyTree<T> familyTree, List<T> allPersons) {
        this.view = view;
        this.familyTree = familyTree;
        this.allPersons = allPersons;
        this.fileManager = new FamilyTreeFileManager();

        // Заполняем представление данными из списка персон
        for (T person : allPersons) {
            this.familyTree.addPerson(person);
            view.getPersonComboBox().addItem(person.toString());
        }

        // Устанавливаем обработчики событий для кнопок
        view.getShowInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPerson = (String) view.getPersonComboBox().getSelectedItem();
                for (T person : familyTree.getAllPersons()) {
                    if (person.toString().equals(selectedPerson)) {
                        view.getDisplayArea().setText(familyTree.displayFamilyInfo(((Person) person).getId()));
                    }
                }
            }
        });

        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        fileManager.saveFamilyTreeToFile(familyTree, file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        view.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        familyTree = fileManager.loadFamilyTreeFromFile(file);
                        view.getDisplayArea().setText("Генеалогическое дерево загружено.");
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        view.getSortByNameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                familyTree.sortByName();
                view.getDisplayArea().setText("Отсортировано по имени.");
            }
        });

        view.getSortByBirthDateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                familyTree.sortByBirthDate();
                view.getDisplayArea().setText("Отсортировано по дате рождения.");
            }
        });
    }
}
