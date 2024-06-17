package homeWork.Model;

import java.util.List;

public interface FamilyTreeInterface<T> {
    void addPerson(T person);
    List<T> getAllPersons();
    String displayFamilyInfo(Long personId);
    void sortByName();
    void sortByBirthDate();
}
