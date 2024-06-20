package homeWork.Model;

import java.io.File;
import java.io.IOException;

/**
 * Интерфейс для управления файлами генеалогического дерева.
 */
public interface FileManager {
    <T extends Comparable<T>> void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException;
    <T extends Comparable<T>> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
}
