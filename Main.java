package homeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> allPersons = createPersonList();
        FamilyTree familyTree = new FamilyTree();
        for (Person person : allPersons) {
            familyTree.addPerson(person);
        }

        // Создание экземпляра FamilyTreeFileManager
        FileManager fileManager = new FamilyTreeFileManager();

        JFrame frame = new JFrame("Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JComboBox<String> personComboBox = new JComboBox<>();
        for (Person person : allPersons) {
            personComboBox.addItem(person.getId() + ": " + person.getFirstName() + " " + person.getLastName());
        }

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton showInfoButton = new JButton("Show Info");
        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPerson = (String) personComboBox.getSelectedItem();
                if (selectedPerson != null) {
                    Long personId = Long.parseLong(selectedPerson.split(":")[0]);
                    String info = familyTree.displayFamilyInfo(personId);
                    displayArea.setText(info);
                }
            }
        });

        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter file name (with extension):");
                if (fileName != null && !fileName.trim().isEmpty()) {
                    File file = new File(fileName);
                    try {
                        fileManager.saveFamilyTreeToFile(familyTree, file);
                        JOptionPane.showMessageDialog(frame, "Family tree saved successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving family tree: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton loadButton = new JButton("Load from File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        FamilyTree loadedFamilyTree = fileManager.loadFamilyTreeFromFile(selectedFile);
                        List<Person> loadedPersons = loadedFamilyTree.getAllPersons();
                        allPersons.clear();
                        allPersons.addAll(loadedPersons);
                        personComboBox.removeAllItems();
                        for (Person person : allPersons) {
                            personComboBox.addItem(person.getId() + ": " + person.getFirstName() + " " + person.getLastName());
                        }
                        JOptionPane.showMessageDialog(frame, "Family tree loaded successfully.");
                    } catch (IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "Error loading family tree: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(showInfoButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        panel.add(personComboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static List<Person> createPersonList() {
        List<Person> persons = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Person person1 = new Person("Иванов", "Иван", "Иванович", sdf.parse("1980-01-01"));
            Person person2 = new Person("Иванова", "Мария", "Петровна", sdf.parse("1982-04-15"));
            Person person3 = new Person("Петров", "Петр", "Сергеевич", sdf.parse("1955-06-20"));
            Person person4 = new Person("Сидоров", "Андрей", "Иванович", sdf.parse("1945-10-10"));

            person1.addChild(person3);
            person1.addChild(person4);
            person2.addChild(person3);
            person2.addChild(person4);
            person3.addParent(person1);
            person3.addParent(person2);
            person4.addParent(person1);
            person4.addParent(person2);

            persons.add(person1);
            persons.add(person2);
            persons.add(person3);
            persons.add(person4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
