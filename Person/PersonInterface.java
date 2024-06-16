package homeWork.Person;

import homeWork.FamilyTree.FamilyMember;
import java.util.Date;
import java.util.List;

public interface PersonInterface extends FamilyMember<Person> {
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
    Date getDeathDate();
    void setDeathDate(Date deathDate);
    void setParents(List<Person> parents);
    void setChildren(List<Person> children);
    Person getSpouse();
    void setSpouse(Person spouse);
    boolean addChild(Person child);
    boolean addParent(Person parent);
    boolean addSpouse(Person spouse);
}
