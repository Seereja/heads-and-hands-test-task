

public class Hero extends Character implements AbleToRecovery {
    private int healsCount = 4;

    public Hero(String name, int attack, int defend, int maxHp, int damageMin, int damageMax) {
        super(name, attack, defend, maxHp, damageMin, damageMax);
    }

    public void minusHeal() {
        this.healsCount--;
    }

    public void healthRecovery() {
        if (healsCount > 0) {
            minusHeal();
            int healthRecovered = (int) (hpMax * 0.3);
            hp = Math.min(hp + healthRecovered, hpMax);
            System.out.println("Ваше здоровье: " + hp + "/" + hpMax + " HP");
            System.out.println("У вас осталось возможности отхилиться " + healsCount);
        } else {
            System.out.println("Закончились баночки с эликсиром здоровья");
        }
    }
}
