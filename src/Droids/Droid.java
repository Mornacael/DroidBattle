package Droids;

public class Droid {
    private String name;
    private int health;
    private int damage;

    public void setHealth(int health) {
        this.health = health;
    }

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }


    @Override
    public String toString(){
        return "Name: " + name + ", Health: " + health + ", Damage: " + damage;
    }

    public void takeDamage(int attackerDamage) {
        health -= attackerDamage;
        setHealth(health);
    }
    public boolean isAlive(){
        return health > 0;
    }
}

