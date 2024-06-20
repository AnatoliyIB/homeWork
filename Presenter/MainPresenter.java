package homeWork.Presenter;

import homeWork.Model.FamilyTree;
import homeWork.Model.Person;

import java.time.LocalDate;
import java.util.List;

public class MainPresenter<T extends Person> {
    private FamilyTree<T> familyTree;

    public MainPresenter() {
        this.familyTree = new FamilyTree<>();
    }

    public void addPerson(T person) {
        familyTree.addMember(person);
    }

    public void addChild(int parentId, int childId) {
        T parent = familyTree.findMemberById(parentId);
        T child = familyTree.findMemberById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    public List<T> getFamilyTreeMembers() {
        return familyTree.getMembers();
    }
}
