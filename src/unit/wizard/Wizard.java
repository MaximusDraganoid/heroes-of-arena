package unit.wizard;

import unit.Unit;

public abstract class Wizard extends Unit{

    private int intelligence;
    private int cunning;
    private int mana;

    private String magicType;

    public Wizard(int intelligence, int cunning, String name) {
        super(name);
        this.cunning = cunning;
        this.intelligence = intelligence;
        calculateAttack();
        calculateHealth();
        calculateMana();
    }

    private void calculateHealth() {
        int health = BASE_HEALTH + (int)(cunning * 2.56) - 3;
        setHealth(health);
    }

    private void calculateAttack() {
        int attack = BASE_ATTACK + intelligence + (int)(cunning * 0.75);
    }

    private void calculateMana() {
        mana = (int)(intelligence * 12.5) - 3;
    }
}
