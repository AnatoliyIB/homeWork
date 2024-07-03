package homeWork.Model;

import java.io.File;
import java.io.IOException;

public interface FileManager<T extends FamilyMember> {
    void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException;
    FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException;
}
