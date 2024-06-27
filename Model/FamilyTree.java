package homeWork.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FamilyTree.test.homeWork.Model.FamilyMember;

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
        Collections.sort(members, new Comparator<T>() {
            @Override
            public int compare(T m1, T m2) {
                return m1.getName().compareTo(m2.getName());
            }
        });
    }

    public void sortByBirthDate() {
        Collections.sort(members, new Comparator<T>() {
            @Override
            public int compare(T m1, T m2) {
                return m1.getBirthDate().compareTo(m2.getBirthDate());
            }
        });
    }
}
