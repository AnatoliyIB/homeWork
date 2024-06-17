package homeWork.Model;

import java.io.Serializable;
import java.util.List;

public class FamilyTree<T> implements Serializable {
    private List<T> members;

    public FamilyTree(List<T> members) {
        this.members = members;
    }

    public List<T> getMembers() {
        return members;
    }

    public void setMembers(List<T> members) {
        this.members = members;
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    // Другие методы для работы с семейным деревом
}
