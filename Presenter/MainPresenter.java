package homeWork.Presenter;

import homeWork.Model.Person;
import homeWork.Service.TreeService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainPresenter {
    private TreeService treeService;

    public MainPresenter() {
        this.treeService = new TreeService();
    }

    public void addPerson(Person person) {
        treeService.addPerson(person);
    }

    public void addChild(int parentId, int childId) {
        treeService.addChild(parentId, childId);
    }

    public List<Person> getFamilyTreeMembers() {
        return treeService.getFamilyTree().getMembers();
    }

    public String getFamilyTreeInfo() {
        return treeService.getFamilyTreeInfo();
    }

    public void saveFamilyTreeToFile(File file) throws IOException {
        treeService.saveFamilyTreeToFile(file);
    }

    public void loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        treeService.loadFamilyTreeFromFile(file);
    }

    public void sortByName() {
        treeService.sortByName();
    }

    public void sortByBirthDate() {
        treeService.sortByBirthDate();
    }
}
