package homeWork.Model;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Интерфейс для представления генеалогического дерева.
 * @param <T> тип элементов в генеалогическом дереве.
 */
public interface FamilyTreeInterface<T extends Comparable<T>> {
    
    /**
     * Добавление новой персоны в генеалогическое дерево.
     * @param person персона для добавления.
     */
    void addPerson(T person);
    
    /**
     * Получение всех персон в генеалогическом дереве.
     * @return список всех персон.
     */
    List<T> getAllPersons();
    
    /**
     * Отображение информации о генеалогическом дереве для заданного идентификатора.
     * @param id идентификатор персоны.
     * @return строка с информацией о персоне.
     */
    String displayFamilyInfo(Long id);
    
    /**
     * Сортировка персон в генеалогическом дереве по имени.
     */
    void sortByName();
    
    /**
     * Сортировка персон в генеалогическом дереве по дате рождения.
     */
    void sortByBirthDate();
    
    /**
     * Сохранение генеалогического дерева в файл.
     * @param file файл для сохранения данных.
     * @throws IOException если произошла ошибка ввода-вывода.
     */
    void saveToFile(File file) throws IOException;
    
    /**
     * Загрузка генеалогического дерева из файла.
     * @param file файл для загрузки данных.
     * @throws IOException если произошла ошибка ввода-вывода.
     * @throws ClassNotFoundException если класс не найден при загрузке объекта.
     */
    void loadFromFile(File file) throws IOException, ClassNotFoundException;
}
