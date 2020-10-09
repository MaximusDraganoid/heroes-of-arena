package TestArena;

import unit.humans.HumanWarrior;
import battle.Battle;

import java.util.Scanner;

/*
Персонажи для игры Арена
Создать консольное приложение, удовлетворяющее следующим требованиям:
Использовать возможности ООП: классы, наследование, полиморфизм, ин-
капсуляция.
Каждый класс должен иметь отражающее смысл название и информатив-
ный состав.
Наследование должно применяться только тогда, когда это имеет смысл.
При кодировании должны быть использованы соглашения об оформлении
кода java code convention.
Классы должны быть грамотно разложены по пакетам.
Консольное меню должно быть минимальным.
Для хранения параметров инициализации можно использовать файлы.
По возможности использовать так же перечисления

Определить иерархию персонажей. Создать несколько объектов персонажей.

 */

public class TestRunner {

    public static void main(String[] args) {
        HumanWarrior testWarrior= new HumanWarrior("Artur");
        HumanWarrior secondWarrior = new HumanWarrior("Duke");

        Battle testBattle = new Battle(testWarrior, secondWarrior);
        testBattle.fight();

    }

}
