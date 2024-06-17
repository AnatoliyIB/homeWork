package homeWork.View;

import homeWork.Model.Person;
import homeWork.Presenter.MainPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainView {
    private MainPresenter presenter;
    private JFrame frame;
    private JComboBox<String> personComboBox;
    private JTextArea displayArea;

    public MainView(MainPresenter presenter) {
        this.presenter = presenter;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Генеалогическое дерево");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        personComboBox = new JComboBox<>();
        updateComboBox(presenter.getAllPersons());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton showInfoButton = new JButton("Показать информацию");
        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPerson = (String) personComboBox.getSelectedItem();
                if (selectedPerson != null) {
                    Long personId = Long.parseLong(selectedPerson.split(":")[0]);
                    String info = presenter.displayFamilyInfo(personId);
                    displayArea.setText(info);
                }
            }
        });

        JButton saveButton = new JButton("Сохранить в файл");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Введите имя файла (с расширением):");
                if (fileName != null && !fileName.trim().isEmpty()) {
                    File file = new File(fileName);
                    try {
                        presenter.saveFamilyTreeToFile(file);
                        JOptionPane.showMessageDialog(frame, "Генеалогическое дерево успешно сохранено.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Ошибка сохранения генеалогического дерева: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton loadButton = new JButton("Загрузить из файла");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        presenter.loadFamilyTreeFromFile(selectedFile);
                        updateComboBox(presenter.getAllPersons());
                        JOptionPane.showMessageDialog(frame, "Генеалогическое дерево успешно загружено.");
                    } catch (IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "Ошибка загрузки генеалогического дерева: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton sortByNameButton = new JButton("Сортировать по имени");
        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.sortByName();
                updateComboBox(presenter.getAllPersons());
            }
        });

        JButton sortByBirthDateButton = new JButton("Сортировать по дате рождения");
        sortByBirthDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.sortByBirthDate();
                updateComboBox(presenter.getAllPersons());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(showInfoButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(sortByNameButton);
        buttonPanel.add(sortByBirthDateButton);

        panel.add(personComboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateComboBox(List<Person> allPersons) {
        personComboBox.removeAllItems();
        for (Person person : allPersons) {
            personComboBox.addItem(person.getId() + ": " + person.getFirstName() + " " + person.getLastName());
        }
    }
}
