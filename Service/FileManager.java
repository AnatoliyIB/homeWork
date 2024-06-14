package homeWork.Service;

import homeWork.FamilyTree.FamilyTree;
import homeWork.Person.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileManager {
    void saveFamilyTreeToFile(FamilyTree familyTree, File file) throws IOException;
    FamilyTree loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
    void savePersonsToFile(List<Person> persons, File file) throws IOException;
    List<Person> loadPersonsFromFile(File file) throws IOException, ClassNotFoundException;
}
