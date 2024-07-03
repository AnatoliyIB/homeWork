package homeWork.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class FamilyMember implements Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private List<FamilyMember> children;
    private FamilyMember parent;  // Добавлено для хранения родителя

    public FamilyMember(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public FamilyMember getParent() {
        return parent;
    }

    public void setParent(FamilyMember parent) {
        this.parent = parent;
    }

    public void addChild(FamilyMember child) {
        children.add(child);
        child.setParent(this);  // Устанавливаем родителя для ребенка
    }

    @Override
    public String toString() {
        return name + " (" + birthDate + ")";
    }
}
