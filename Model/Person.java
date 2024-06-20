package homeWork.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private String name;
    private LocalDate birthDate;
    private List<Person> children;

    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", children=" + children +
                '}';
    }
}
