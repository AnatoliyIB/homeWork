package homeWork.FamilyTree;

import java.util.List;

public interface FamilyMember<T> {
    Long getId();
    String getFirstName();
    String getLastName();
    List<T> getParents();
    List<T> getChildren();
 
}

