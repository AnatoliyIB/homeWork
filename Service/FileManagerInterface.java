package homeWork.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import homeWork.FamilyTree.FamilyTreeInterface;

public interface FileManagerInterface {
    <T> void saveFamilyTreeToFile(FamilyTreeInterface<T> familyTree, File file) throws IOException;
    <T> FamilyTreeInterface<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
    <T> void savePersonsToFile(List<T> persons, File file) throws IOException;
    <T> List<T> loadPersonsFromFile(File file) throws IOException, ClassNotFoundException;
}
