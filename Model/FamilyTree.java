package homeWork.Model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Person> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    public T findMemberById(int id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=" + members +
                '}';
    }
}
