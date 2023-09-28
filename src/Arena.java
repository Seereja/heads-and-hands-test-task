

import java.util.Scanner;

public class Arena {
    private static final Scanner INPUT = new Scanner(System.in);
    private final static Hero HERO = new Hero(
            "Sergey",
            10,
            4,
            50,
            1,
            10
    );
    private final static Monster MONSTER = new Monster(
            "Monster",
            10,
            5,
            50,
            1,
            10
    );

    public static void main(String[] args) {
        try {
            while (true) {
                String roll = INPUT.nextLine();
                switch (roll) {
                    case "1" -> doBattle(HERO, MONSTER);
                    case "2" -> HERO.healthRecovery();
                    default -> System.out.println("Неправильный ввод. Повторите попытку.");
                }
            }
        } catch (CharacterIsDeadException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doBattle(Character character1, Character character2) {
        character1.doAttack(character2);
        character2.doAttack(character1);
    }
}





