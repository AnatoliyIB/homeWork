package homeWork.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person extends FamilyMember<Person> {
    private List<Person> parents;
    private List<Person> children;

    public Person(Long id, String lastName, String firstName, String middleName, Date birthDate, Gender gender) {
        super(id, lastName, firstName, middleName, birthDate, gender);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public List<Person> getParents() {
        return parents;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }
}
