package ch.noseryoung.blj;

public class Item {
    private String name;
    private String description;
    private boolean isAttackable;

    private String attackDescription;

    public Item(String name, String description, boolean isAttackable, String attackDescription) {
        this.name = name;
        this.description = description;
        this.isAttackable = isAttackable;
        this.attackDescription = attackDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAttackDescription() {
        return attackDescription;
    }

    public boolean isAttackable() {
        return isAttackable;
    }

}
