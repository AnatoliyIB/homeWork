package homeWork.View;

import homeWork.Model.FamilyTree;
import homeWork.Model.Person;
import homeWork.Presenter.MainPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainView<T extends Person> {
    private MainPresenter<T> presenter;
    private JFrame frame;

    public MainView() {
        presenter = new MainPresenter<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JButton addButton = new JButton("Добавить Персону");
        frame.getContentPane().add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                presenter.addPerson((T) new Person(1, "Иван Иванов", LocalDate.of(1985, 5, 20)));
                presenter.addPerson((T) new Person(2, "Мария Иванова", LocalDate.of(2010, 6, 15)));
                presenter.addChild(1, 2);
                JOptionPane.showMessageDialog(frame, "Персона добавлена!");
            }
        });

        JButton showButton = new JButton("Показать Дерево");
        frame.getContentPane().add(showButton);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder familyTreeInfo = new StringBuilder();
                for (T person : presenter.getFamilyTreeMembers()) {
                    familyTreeInfo.append(person.getName()).append(" (").append(person.getBirthDate()).append(")\n");
                    for (Person child : person.getChildren()) {
                        familyTreeInfo.append("  -> ").append(child.getName()).append(" (").append(child.getBirthDate()).append(")\n");
                    }
                }
                JOptionPane.showMessageDialog(frame, familyTreeInfo.toString());
            }
        });

        JButton loadButton = new JButton("Загрузить");
        frame.getContentPane().add(loadButton);

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Реализация загрузки дерева
                JOptionPane.showMessageDialog(frame, "Дерево загружено!");
            }
        });

        JButton saveButton = new JButton("Сохранить");
        frame.getContentPane().add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Реализация сохранения дерева
                JOptionPane.showMessageDialog(frame, "Дерево сохранено!");
            }
        });

        JButton sortByNameButton = new JButton("Сортировать по Имени");
        frame.getContentPane().add(sortByNameButton);

        sortByNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Реализация сортировки по имени
                JOptionPane.showMessageDialog(frame, "Дерево отсортировано по имени!");
            }
        });

        JButton sortByDateButton = new JButton("Сортировать по Дате Рождения");
        frame.getContentPane().add(sortByDateButton);

        sortByDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Реализация сортировки по дате рождения
                JOptionPane.showMessageDialog(frame, "Дерево отсортировано по дате рождения!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView<Person> window = new MainView<>();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showFamilyTreeInfo(FamilyTree<Person> familyTree) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showFamilyTreeInfo'");
    }
}
