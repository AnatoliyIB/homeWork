package homeWork.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Класс генеалогического дерева
public class FamilyTree<T extends Comparable<T>> implements FamilyTreeInterface<T>, Iterable<T> {
    private List<T> familyMembers;

    // Конструктор класса
    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    // Метод добавления члена семьи
    @Override
    public void addPerson(T person) {
        familyMembers.add(person);
    }

    // Метод отображения информации о семье
    @Override
    public String displayFamilyInfo(Long personId) {
        // Логика отображения информации о семье (необходимо реализовать конкретную логику для вашего проекта)
        return "Информация о члене семьи с ID " + personId;
    }

    // Метод сортировки по имени
    @Override
    public void sortByName() {
        Collections.sort(familyMembers);
    }

    // Метод сортировки по дате рождения
    @Override
    public void sortByBirthDate() {
        // Для обобщённого типа сортировка по дате рождения должна быть переопределена в конкретных типах
    }

    // Метод для итерации по элементам
    @Override
    public Iterator<T> iterator() {
        return familyMembers.iterator();
    }

    // Метод для получения всех членов семьи
    public List<T> getAllPersons() {
        return familyMembers;
    }
}
