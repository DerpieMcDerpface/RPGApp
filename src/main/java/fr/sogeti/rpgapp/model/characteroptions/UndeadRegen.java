package fr.sogeti.rpgapp.model.characteroptions;

public enum UndeadRegen {
    NONE(0),
    LOW(5),
    MEDIUM(10),
    HIGH(25);

    private int value;

    UndeadRegen(int i) {
        this.value = i;
    }

    public int getValue(){
        return this.value;
    }

}
