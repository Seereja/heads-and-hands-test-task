

import java.util.Random;

public class Character {
    private final String name;
    private final int attack;
    private final int defend;
    protected final int hpMax;
    protected int hp;
    private final int damageMin;
    private final int damageMax;

    public Character(String name, int attack, int defence, int hpMax, int damageMin, int damageMax) {
        validateAttack(attack);
        validateDefence(defence);
        validatePositive(hp);
        validateDamageInterval(damageMin, damageMax);

        this.name = name;
        this.attack = attack;
        this.defend = defence;
        this.hpMax = hpMax;
        this.hp = this.hpMax;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    public int getHpMax() {
        return hpMax;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDefend() {
        return defend;
    }

    public void doAttack(Character target) {
        System.out.println("Ход " + getName());
        int modifierAttack = attack - target.getDefend() + 1;
        int diceRolls = Math.max(modifierAttack, 1);
        boolean successfulHit = checkAttack(diceRolls);
        if (successfulHit) {
            int damage = new Random().nextInt(damageMax - damageMin + 1) + damageMin;
            System.out.println("нанес урон " + damage);
            target.receiveDamage(damage);
        } else {
            System.out.println("Промах");
        }

        System.out.println("Персонаж " + name + " атаковал персонажа " + target.getName() + ". " +
                "\nЗдоровье атакуемого после битвы: " + target.getHp() + "/" + target.getHpMax() + " HP");
    }

    private boolean checkAttack(int diceRolls) {
        for (int i = 0; i < diceRolls; i++) {
            if (new Random().nextInt((6 - 1) + 1) + 1 >= 5) {
                return true;
            }
        }
        return false;
    }

    private void receiveDamage(int damage) {
        if (hp - damage <= 0) {
            throw new CharacterIsDeadException(name);
        } else {
            hp -= damage;
        }
    }

    private void validateDefence(int defence) {
        if (defence <= 0 || defence > 30) {
            throw new RuntimeException("Защита должна быть от 1 до 30 включительно!");
        }
    }

    private void validateAttack(int attack) {
        if (attack <= 0 || attack > 30) {
            throw new RuntimeException("Атака должна быть от 1 до 30 включительно!");
        }
    }

    private void validatePositive(int hp) {
        if (hp < 0) {
            throw new RuntimeException("Очки здоровья должны быть положительными!");
        }
    }

    private void validateDamageInterval(int damageMin, int damageMax) {
        if (damageMax < damageMin) {
            throw new RuntimeException("Максимальный урон должен быть не меньше минимального!");
        }
    }
}



