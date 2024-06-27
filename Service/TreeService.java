package homeWork.Service;

import homeWork.Model.FamilyTree;
import homeWork.Model.FamilyTreeFileManager;
import homeWork.Model.FamilyMember;
import homeWork.Model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TreeService {
    private FamilyTree<Person> familyTree;
    private FamilyTreeFileManager fileManager;

    public TreeService() {
        this.familyTree = new FamilyTree<>();
        this.fileManager = new FamilyTreeFileManager();
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
    }

    public void addChild(int parentId, int childId) {
        Person parent = familyTree.findMemberById(parentId);
        Person child = familyTree.findMemberById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }

    public String getFamilyTreeInfo() {
        StringBuilder familyTreeInfo = new StringBuilder();
        for (Person member : familyTree.getMembers()) {
            familyTreeInfo.append(member.getName()).append(" (").append(member.getBirthDate()).append(")\n");
            for (FamilyMember child : member.getChildren()) {
                familyTreeInfo.append("  -> ").append(child.getName()).append(" (").append(child.getBirthDate()).append(")\n");
            }
        }
        return familyTreeInfo.toString();
    }

    public void saveFamilyTreeToFile(File file) throws IOException {
        fileManager.saveFamilyTreeToFile(familyTree, file);
    }

    public void loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        this.familyTree = fileManager.loadFamilyTreeFromFile(file);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }
}
