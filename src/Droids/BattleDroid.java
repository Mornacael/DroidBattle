package Droids;


public class BattleDroid extends Droid {
    public int getArmor() {
        return armor;
    }

    private int armor;

    @Override
    public String toString() {
        return "BattleDroid{" + super.toString() +
                ", Armor: " + armor +
                '}';
    }
    public BattleDroid(String name, int health, int damage, int armor){
            super(name, health, damage);
            this.armor = armor;
        }

    public void takeDamage(int attackerDamage){
        int newDamage = Math.max(0, attackerDamage - getArmor());
        int newHealth = getHealth() - newDamage;
        setHealth(newHealth);
    }
}
