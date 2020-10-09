package unit.humans;

import unit.warrior.Warrior;
import unit.Unit;

public class HumanWarrior extends Warrior{

    public HumanWarrior(String name) {
        super(2, 3, name);
    }

    @Override
    public void printCurrentInfo() {
        StringBuilder unitInfo = new StringBuilder();
        unitInfo.append("Current stats of " + getName() + "\nhealth: " + getHealth() + " stamina: " + getStamina());
        unitInfo.append("\nStandard attack: " + getStandardAttack());
        System.out.println(unitInfo);
    }

    @Override
    public int attack(Unit enemy) {
        int currentDamage = getStandardAttack();
        int newEnemyHealth = enemy.getHealth() - currentDamage;
        if (newEnemyHealth < 0) {
            newEnemyHealth = 0;
        }
        enemy.setHealth(newEnemyHealth);
        System.out.println("Human warrior " + getName() + ": attack with damage " + getStandardAttack());
        return getStandardAttack();
    }

    @Override
    public int specialAttack() {
        System.out.println("Human warrior " + getName() + ": special attack with damage " + getStandardAttack() * 2);
        return getStandardAttack() * 2;
    }

    @Override
    public void waitAndRecovery() {
        System.out.println("Human warrior " + getName() + ": waiting and recovery his health and stamina");
    }

    @Override
    public void defend() {
        System.out.println("Human warrior " + getName() + ": defend ");
    }
}
