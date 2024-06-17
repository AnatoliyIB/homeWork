package homeWork.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class FamilyMember<T> implements Serializable {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private Gender gender;

    public FamilyMember(Long id, String lastName, String firstName, String middleName, Date birthDate, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

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

    public abstract List<T> getParents();

    public abstract List<T> getChildren();
}
