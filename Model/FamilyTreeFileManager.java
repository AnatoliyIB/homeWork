package homeWork.Model;

import java.io.*;

/**
 * Класс для управления файлами генеалогического дерева.
 */
public class FamilyTreeFileManager implements FileManager {
    @Override
    public <T extends Comparable<T>> void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public <T extends Comparable<T>> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
