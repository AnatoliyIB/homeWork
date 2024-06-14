package homeWork.Service;

import java.io.*;
import java.util.List;

import homeWork.Service.FileManagerInterface;
import homeWork.FamilyTree.FamilyTreeInterface;


public class FamilyTreeFileManager implements FileManagerInterface {

    @Override
    public <T> void saveFamilyTreeToFile(FamilyTreeInterface<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public <T> FamilyTreeInterface<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTreeInterface<T>) ois.readObject();
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
