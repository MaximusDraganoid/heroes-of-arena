package unit.warrior;

import unit.Unit;

public abstract class Warrior extends Unit {

    private int strength;
    private int agility;
    private int stamina;

    private String warriorType;

    public Warrior(int strength, int agility, String name) {
        super(name);
        this.strength = strength;
        this.agility = agility;
        calculateAttack();
        calculateHealth();
        calculateStamina();
    }

    private void calculateHealth() {
        int health = BASE_HEALTH + (int)(strength * 1.5);
        setHealth(health);
    }

    private void calculateAttack() {
        int attack = BASE_ATTACK + strength;
        setStandardAttack(attack);
    }

    private void calculateStamina() {
        stamina = agility * 15;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
