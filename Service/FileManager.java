package homeWork.Service;

import homeWork.Model.FamilyTree;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileManager {
    <T> void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException;
    <T> FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
    <T> void savePersonsToFile(List<T> persons, File file) throws IOException;
    <T> List<T> loadPersonsFromFile(File file) throws IOException, ClassNotFoundException;
}
