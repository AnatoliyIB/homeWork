package homeWork.Person;

import java.util.Date;
import java.util.List;

public interface PersonInterface {
    Long getId();
    String getLastName();
    void setLastName(String lastName);
    String getFirstName();
    void setFirstName(String firstName);
    String getMiddleName();
    void setMiddleName(String middleName);
    Gender getGender();
    void setGender(Gender gender);
    Date getBirthDate();
    void setBirthDate(Date birthDate);
    List<Person> getParents();
    void setParents(List<Person> parents);
    List<Person> getChildren();
    void setChildren(List<Person> children);
    Person getSpouse();
    void setSpouse(Person spouse);
    boolean addChild(Person child);
    boolean addParent(Person parent);
    boolean addSpouse(Person spouse);
}
