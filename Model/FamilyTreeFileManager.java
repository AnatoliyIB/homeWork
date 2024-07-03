package homeWork.Model;

import java.io.*;

public class FamilyTreeFileManager<T extends FamilyMember> implements FileManager<T> {
    @Override
    public void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
