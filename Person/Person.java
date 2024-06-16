package homeWork.Person;

import homeWork.FamilyTree.FamilyMember;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Person implements Serializable, PersonInterface {
    private static final long serialVersionUID = 1L;

    private static final AtomicLong idGenerator = new AtomicLong(0);
    private final Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Gender gender;
    private Date birthDate;
    private Date deathDate;
    private List<Person> parents;
    private List<Person> children;
    private Person spouse;

    public Person(long id, String lastName, String firstName, String middleName, Date birthDate, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Date getDeathDate() {
        return deathDate;
    }

    @Override
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public List<Person> getParents() {
        return parents;
    }

    @Override
    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Person> children) {
        this.children = children;
    }

    @Override
    public Person getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public boolean addChild(Person child) {
        if (children.contains(child)) {
            return false;
        } else {
            children.add(child);
            return true;
        }
    }

    @Override
    public boolean addParent(Person parent) {
        if (parents.contains(parent)) {
            return false;
        } else {
            parents.add(parent);
            return true;
        }
    }

    @Override
    public boolean addSpouse(Person spouse) {
        if (this.spouse != null) {
            return false;
        } else {
            this.spouse = spouse;
            return true;
        }
    }
}
