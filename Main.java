package homeWork;

import homeWork.Model.*;
import homeWork.View.MainView;
import homeWork.Presenter.MainPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем генеалогическое дерево для объектов типа Person
        FamilyTree<Person> familyTree = new FamilyTree<>();
        // Создаем список примеров объектов Person
        List<Person> allPersons = createSamplePersons();

        // Создаем объект представления
        MainView view = new MainView();
        // Создаем объект презентера, передавая в него представление, генеалогическое дерево и список всех персон
        MainPresenter<Person> personPresenter = new MainPresenter<>(view, familyTree, allPersons);
    }

    private static List<Person> createSamplePersons() {
        List<Person> persons = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Создаем примеры объектов Person
            Person person1 = new Person(1L, "Иванов", "Иван", "Иванович", sdf.parse("1980-01-01"), Gender.MALE);
            Person person2 = new Person(2L, "Петрова", "Мария", "Сергеевна", sdf.parse("1990-06-15"), Gender.FEMALE);
            Person person3 = new Person(3L, "Сидоров", "Петр", "Алексеевич", sdf.parse("1970-03-20"), Gender.MALE);
            Person person4 = new Person(4L, "Кузнецова", "Елена", "Дмитриевна", sdf.parse("1990-12-30"), Gender.FEMALE);

            // Добавляем родителей для некоторых объектов Person
            person1.addParent(person3);
            person2.addParent(person3);

            // Добавляем объекты Person в список
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
