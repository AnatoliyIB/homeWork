package homeWork;

import homeWork.Model.Person;
import homeWork.Model.Gender;
import homeWork.Presenter.MainPresenter;
import homeWork.View.MainView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание презентера
        MainPresenter presenter = new MainPresenter();

        // Создание списка людей и добавление их в презентер
        List<Person> allPersons = createPersonList();
        presenter.addMembers(allPersons);

        // Создание и отображение главного представления
        new MainView(presenter);
    }

    private static List<Person> createPersonList() {
        List<Person> persons = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Person person1 = new Person(1L, "Иванов", "Иван", "Иванович", sdf.parse("1980-01-01"), Gender.MALE);
            Person person2 = new Person(2L, "Иванова", "Мария", "Петровна", sdf.parse("1982-04-15"), Gender.FEMALE);
            Person person3 = new Person(3L, "Петров", "Петр", "Сергеевич", sdf.parse("1955-06-20"), Gender.MALE);
            Person person4 = new Person(4L, "Сидоров", "Андрей", "Иванович", sdf.parse("1945-10-10"), Gender.MALE);

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
