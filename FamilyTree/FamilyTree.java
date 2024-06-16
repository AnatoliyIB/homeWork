package homeWork.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember<T>> implements FamilyTreeInterface<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    @Override
    public void addPerson(T member) {
        members.add(member);
    }

    @Override
    public List<T> getAllPersons() {
        return new ArrayList<>(members);
    }

    @Override
    public String displayFamilyInfo(Long memberId) {
        T member = findPersonById(memberId);

        if (member == null) {
            return "Member with ID " + memberId + " not found.";
        }

        StringBuilder info = new StringBuilder();
        info.append("Member Information:\n");
        info.append(displayMemberInfo(member));
        info.append("\n");

        info.append(displayRelativesInfo("Parents:", member.getParents()));
        info.append(displayRelativesInfo("Children:", member.getChildren()));

        return info.toString();
    }

    private T findPersonById(Long memberId) {
        return members.stream()
                .filter(member -> member.getId().equals(memberId))
                .findFirst()
                .orElse(null);
    }

    private String displayMemberInfo(FamilyMember<?> member) {
        return "ID: " + member.getId() + "\n" +
                "Last Name: " + member.getLastName() + "\n" +
                "First Name: " + member.getFirstName() + "\n";
               
    }

    private String displayRelativesInfo(String relationship, List<? extends FamilyMember<?>> relatives) {
        StringBuilder info = new StringBuilder();
        info.append(relationship).append("\n");

        if (relatives.isEmpty()) {
            info.append("No information about relatives.\n");
        } else {
            for (FamilyMember<?> relative : relatives) {
                info.append(displayMemberInfo(relative)).append("\n");
            }
        }

        return info.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    @Override
    public void sortByName() {
        Collections.sort(members, Comparator.comparing(FamilyMember::getFirstName).thenComparing(FamilyMember::getLastName));
    }

    @Override
    public void sortByBirthDate() {
        
        Collections.sort(members, Comparator.comparing(FamilyMember::getBirthDate));
    }
}
