package homeWork.Model;

import java.time.LocalDate;

public class Person extends FamilyMember {
    public Person(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", children=" + getChildren() +
                ", parent=" + (getParent() != null ? getParent().getName() : "null") +
                '}';
    }
}
