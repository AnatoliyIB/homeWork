package homeWork.FamilyTree;

import java.util.List;

public interface FamilyTreeInterface<T> extends Iterable<T> {
    void addPerson(T person);
    List<T> getAllPersons();
    String displayFamilyInfo(Long personId);
    void sortByName();
    void sortByBirthDate();
}
