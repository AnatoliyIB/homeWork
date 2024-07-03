package homeWork.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Serializable {
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

    public void sortByName() {
        members.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
    }

    public void sortByBirthDate() {
        members.sort((m1, m2) -> m1.getBirthDate().compareTo(m2.getBirthDate()));
    }

    public String displayFamilyInfo(Long id) {
        T member = findMemberById(id.intValue());
        return member != null ? member.toString() : "Member not found";
    }
}
