package Droids;

public class HealerDroid extends Droid {
    private int heal;
    private final int maxHealerHealth = getHealth();

    @Override
    public String toString() {
        return "HealerDroid{" + super.toString() +
                ", Heal: " + heal +
                '}';
    }
    @Override
    public void takeDamage(int attackerDamage){
        super.takeDamage(attackerDamage);
        healMySelf();
    }
    public void healMySelf(){
        int currentHP = getHealth();
        if (currentHP > 0) {
            setHealth(Math.min(currentHP + heal, maxHealerHealth));
        }
    }

    public HealerDroid(String name, int health, int damage, int heal){
        super(name, health, damage);
        this.heal = heal;
    }
    public void giveHeal(HealerDroid healer, Droid other_droid, int maxHealth){
        int other_droid_health = other_droid.getHealth();
        if (other_droid_health > 0){
            other_droid_health += healer.heal;
            setHealth(Math.min(other_droid_health, maxHealth));
        }
    }
}
