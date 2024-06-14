package homeWork.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import homeWork.Person.Person;

public class FamilyTree<T extends Person> implements FamilyTreeInterface<T>, Serializable {
    private List<T> persons;

    public FamilyTree() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void addPerson(T person) {
        persons.add(person);
    }

    @Override
    public List<T> getAllPersons() {
        return new ArrayList<>(persons);
    }

    @Override
    public String displayFamilyInfo(Long personId) {
        T person = findPersonById(personId);

        if (person == null) {
            return "Person with ID " + personId + " not found.";
        }

        StringBuilder info = new StringBuilder();
        info.append("Person Information:\n");
        info.append(displayPersonInfo(person));
        info.append("\n");

        info.append(displayRelativesInfo("Parents:", person.getParents()));
        info.append(displayRelativesInfo("Children:", person.getChildren()));

        return info.toString();
    }

    private T findPersonById(Long personId) {
        return persons.stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst()
                .orElse(null);
    }

    private String displayPersonInfo(Person person) {
        return "ID: " + person.getId() + "\n" +
                "Last Name: " + person.getLastName() + "\n" +
                "First Name: " + person.getFirstName() + "\n" +
                "Middle Name: " + person.getMiddleName() + "\n" +
                "Birth Date: " + person.getBirthDate() + "\n" +
                "Gender: " + person.getGender() + "\n";
    }

    private String displayRelativesInfo(String relationship, List<? extends Person> relatives) {
        StringBuilder info = new StringBuilder();
        info.append(relationship).append("\n");

        if (relatives.isEmpty()) {
            info.append("No information about relatives.\n");
        } else {
            for (Person relative : relatives) {
                info.append(displayPersonInfo(relative)).append("\n");
            }
        }

        return info.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return persons.iterator();
    }

    @Override
    public void sortByName() {
        Collections.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
    }

    @Override
    public void sortByBirthDate() {
        Collections.sort(persons, Comparator.comparing(Person::getBirthDate));
    }
}
