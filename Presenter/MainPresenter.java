package homeWork.Presenter;

import homeWork.Model.FamilyTree;
import homeWork.Model.Person;
import homeWork.Service.FamilyTreeFileManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainPresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeFileManager fileManager;

    public MainPresenter() {
        familyTree = new FamilyTree<>();
        fileManager = new FamilyTreeFileManager();
    }

    public List<Person> getAllPersons() {
        return familyTree.getAllMembers();
    }

    public String displayFamilyInfo(Long memberId) {
        return familyTree.displayFamilyInfo(memberId);
    }

    public void saveFamilyTreeToFile(File file) throws IOException {
        fileManager.saveFamilyTreeToFile(familyTree, file);
    }

    public void loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        familyTree = fileManager.loadFamilyTreeFromFile(file);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void addMembers(List<Person> persons) {
        for (Person person : persons) {
            familyTree.addMember(person);
        }
    }
}
