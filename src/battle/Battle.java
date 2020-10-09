package battle;

import unit.Unit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Battle {

    private Unit firstFighter, secondFighter;
    private int moves;

    private class BattleLogic {
        //переделать на список строк
        public final static String baseActions = "\n1 -  attack" +
                "\n2 - Special Attack" +
                "\n3 - Wait and Recovery" +
                "\n4 - Defend";

        void printPlayersPossibleActions(Unit fighter) {
            StringBuilder actionList = new StringBuilder();
            actionList.append(fighter.getName());
            actionList.append("! Now, you can do next actions: ");
            actionList.append(baseActions);
            System.out.println(actionList);
            fighter.printCurrentInfo();
        }

        int scanPlayersChoice() {
            Scanner scan = new Scanner(System.in);
            int playerChoice = -1;
            try {
                playerChoice = scan.nextInt();
                if (playerChoice > 3 || playerChoice < 0) {
                    System.out.println("Pls, input integer from 0 to " + 3);
                }
            } catch (InputMismatchException e) {
                System.out.println("Pls, input INTEGER from 0 to " + 3);
            }

            return playerChoice;
        }

        void doSelectedAction (int playerChoice, Unit firstFighter, Unit secondFighter) {
            switch (playerChoice) {
                case 1:
                    firstFighter.attack(secondFighter);
                    break;
                case 2:
                    firstFighter.specialAttack();//!!!
                    break;
                case 3:
                    firstFighter.waitAndRecovery();
                    break;
                case 4:
                    firstFighter.defend();
                    break;
            }
        }

        void printResultOfFight() {
            if (firstFighter.getHealth() > 0) {
                System.out.println(firstFighter.getName() + " Win!");
                System.out.println(secondFighter.getName() + " Lose!");
            }
            else {
                System.out.println(secondFighter.getName() + " Win!");
                System.out.println(firstFighter.getName() + " Lose!");
            }
        }

        void firstStep() {
            int sequence = (int)(Math.random() * 100) % 2;
            if (sequence == 0) {
                System.out.println(firstFighter.getName() + " hits first!");
                firstFighter.attack(secondFighter);
            } else {
                System.out.println(secondFighter.getName() + " hits first!");
            }
        }
    }

    public Battle(Unit firstFighter, Unit secondFighter) {
        try {
            this.firstFighter = (Unit)firstFighter.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone first fighter error");
            return;
        }
        try {
            this.secondFighter = (Unit)secondFighter.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone first fighter error");
            return;
        }
        moves = 1;
    }

    public void fight() {
        System.out.println("fight is starting right now!");
        BattleLogic logic = new BattleLogic();
        logic.firstStep();
        while (firstFighter.getHealth() > 0 && secondFighter.getHealth() > 0) {
            System.out.println("==============================================");
            System.out.println("Moves number " + moves);
            if (moves % 2 == 0) {
                logic.printPlayersPossibleActions(firstFighter);
                int playerChoice = -1;
                while (playerChoice < 0 || playerChoice > 3){
                    playerChoice = logic.scanPlayersChoice();
                }
                logic.doSelectedAction(playerChoice, firstFighter, secondFighter);
            } else {
                logic.printPlayersPossibleActions(secondFighter);
                int playerChoice = -1;
                while (playerChoice < 0 || playerChoice > 3){
                    playerChoice = logic.scanPlayersChoice();
                }
                logic.doSelectedAction(playerChoice, secondFighter, firstFighter);
            }
            moves++;
        }
        logic.printResultOfFight();
    }
}
