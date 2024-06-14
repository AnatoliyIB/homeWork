package homeWork.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Person implements Serializable {
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

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public boolean addChild(Person child) {
        if (children.contains(child)) {
            return false;
        } else {
            children.add(child);
            return true;
        }
    }

    public boolean addParent(Person parent) {
        if (parents.contains(parent)) {
            return false;
        } else {
            parents.add(parent);
            return true;
        }
    }

    public boolean addSpouse(Person spouse) {
        if (this.spouse != null) {
            return false;
        } else {
            this.spouse = spouse;
            return true;
        }
    }
}
