package homeWork.Model;

import java.io.*;

import FamilyTree.test.homeWork.Model.FamilyMember;

public class FamilyTreeFileManager {

    public <T extends FamilyMember> void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    public <T extends FamilyMember> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
