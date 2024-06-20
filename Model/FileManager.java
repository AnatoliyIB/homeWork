package homeWork.Model;

import java.io.File;
import java.io.IOException;

// Интерфейс для управления файлами
public interface FileManager {
    void saveFamilyTreeToFile(FamilyTree<?> familyTree, File file) throws IOException;
    <T> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
}
