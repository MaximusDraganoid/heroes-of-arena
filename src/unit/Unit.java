package unit;

public abstract class Unit implements Cloneable{

    protected final int BASE_ATTACK = 5;
    protected final int BASE_HEALTH= 90;

    private int health;
    private int standardAttack;
    private double luck;
    private String name;

    public abstract int attack(Unit enemy);
    public abstract int specialAttack();
    public abstract void waitAndRecovery();
    public abstract void defend();
    public abstract void printCurrentInfo();


    public Unit(String name, int health, int standardAttack, double luck) {
        this.name = name;
        this.health = health;
        this.standardAttack = standardAttack;
        this.luck = luck;
    }

    public Unit(String name) {
        this.name = name;
        health = 100;
        standardAttack = 10;
        luck = 0.05;

    }

    public Unit() {
        this("Unnamed Hero", 100, 10, 0.05);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public void setStandardAttack(int standardAttack) {
        this.standardAttack = standardAttack;
    }

    public double getLuck() {
        return luck;
    }

    public int getHealth() {
        return health;
    }

    public int getStandardAttack() {
        return standardAttack;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
