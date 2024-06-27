package homeWork.Model;

import java.time.LocalDate;

import FamilyTree.test.homeWork.Model.FamilyMember;

public class Person extends FamilyMember {
    public Person(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
}
