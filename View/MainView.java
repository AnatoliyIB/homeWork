package homeWork.View;

import javax.swing.*;
import java.awt.*;

// Класс представления для отображения графического интерфейса пользователя
public class MainView extends JFrame {
    private JComboBox<String> personComboBox;
    private JTextArea displayArea;
    private JButton showInfoButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton sortByNameButton;
    private JButton sortByBirthDateButton;

    // Конструктор класса
    public MainView() {
        setTitle("Генеалогическое дерево");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        personComboBox = new JComboBox<>();
        displayArea = new JTextArea();
        showInfoButton = new JButton("Показать информацию");
        saveButton = new JButton("Сохранить");
        loadButton = new JButton("Загрузить");
        sortByNameButton = new JButton("Сортировать по имени");
        sortByBirthDateButton = new JButton("Сортировать по дате рождения");

        JPanel topPanel = new JPanel();
        topPanel.add(personComboBox);
        topPanel.add(showInfoButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        bottomPanel.add(loadButton);
        bottomPanel.add(sortByNameButton);
        bottomPanel.add(sortByBirthDateButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Геттеры для доступа к элементам представления
    public JComboBox<String> getPersonComboBox() {
        return personComboBox;
    }

    public JTextArea getDisplayArea() {
        return displayArea;
    }

    public JButton getShowInfoButton() {
        return showInfoButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSortByNameButton() {
        return sortByNameButton;
    }

    public JButton getSortByBirthDateButton() {
        return sortByBirthDateButton;
    }
}
