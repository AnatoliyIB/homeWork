package homeWork.Service;

import homeWork.Model.FamilyTree;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManager implements FileManager {

    @Override
    public <T> void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public <T> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }

    @Override
    public <T> void savePersonsToFile(List<T> persons, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(persons);
        }
    }

    @Override
    public <T> List<T> loadPersonsFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        }
    }
}
