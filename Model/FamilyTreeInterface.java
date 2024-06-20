package homeWork.Model;

// Интерфейс для генеалогического дерева
public interface FamilyTreeInterface<T> {
    void addPerson(T person);
    String displayFamilyInfo(Long personId);
    void sortByName();
    void sortByBirthDate();
}
