package homeWork.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Класс для представления человека
public class Person implements Comparable<Person> {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private Gender gender;
    private List<Person> parents;
    private List<Person> children;

    // Конструктор класса
    public Person(Long id, String lastName, String firstName, String middleName, Date birthDate, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Методы получения полей
    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    // Методы добавления родителей и детей
    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    // Метод сравнения по имени
    @Override
    public int compareTo(Person other) {
        return this.firstName.compareTo(other.firstName);
    }

    // Метод преобразования объекта в строку
    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName;
    }
}
