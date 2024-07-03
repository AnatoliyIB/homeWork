package homeWork.Presenter;

import homeWork.Model.FamilyTree;
import homeWork.Model.FamilyTreeFileManager;
import homeWork.Model.FamilyTreeService;
import homeWork.Model.Person;
import homeWork.View.MainView;
import homeWork.Model.FileManager;
import homeWork.Model.FamilyMember;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MainPresenter implements Presenter {
    private final FamilyTreeService treeService;
    private final MainView view;

    public MainPresenter(MainView view) {
        this.treeService = new FamilyTreeService();
        this.view = view;
    }

    @Override
    public void addPerson(int id, String name, String birthDate) {
        Person person = new Person(id, name, LocalDate.parse(birthDate));
        treeService.addPerson(person);
        view.displayMessage("Person added.");
    }

    @Override
    public void showFamilyTree() {
        view.displayMessage(treeService.getFamilyTreeInfo());
    }

    @Override
    public void saveFamilyTree() {
        try {
            treeService.saveFamilyTreeToFile(new File("family_tree.dat"));
            view.displayMessage("Family tree saved.");
        } catch (IOException e) {
            view.displayMessage("Failed to save family tree.");
        }
    }

    @Override
    public void loadFamilyTree() {
        try {
            treeService.loadFamilyTreeFromFile(new File("family_tree.dat"));
            view.displayMessage("Family tree loaded.");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Failed to load family tree.");
        }
    }
}
