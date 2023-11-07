package Battle;
import Droids.Droid;
import Droids.HealerDroid;

import java.io.*;
import java.util.ArrayList;

public class Battle {
    public Battle(Droid attacker, Droid defender) {

    }
    public Battle(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2){

    }

    public void fight1v1(Droid attacker, Droid defender, ArrayList<String> records) {
        int damageAttacker = attacker.getDamage();
        int damageDefender = defender.getDamage();
        System.out.println("Name: " + attacker.getName()+ " Health: " + attacker.getHealth() +" HP" + " Damage: " + damageAttacker + " VS "
                + "Name: " + defender.getName() + " Health: " + defender.getHealth()+ " HP" + " Damage: " + damageDefender);
        records.add("Name: " + attacker.getName()+ " Health: " + attacker.getHealth() +" HP" + " Damage: " + damageAttacker + " VS "
                + "Name: " + defender.getName() + " Health: " + defender.getHealth()+ " HP" + " Damage: " + damageDefender);
        while (attacker.isAlive() && defender.isAlive()) {
            defender.takeDamage(damageAttacker);
            attacker.takeDamage(damageDefender);
            zeroCheckAndSet(attacker, defender);
            System.out.println(attacker.getName() + " have " + attacker.getHealth() + "HP"
                    + " and " + defender.getName() + " have " + defender.getHealth() + "HP");
            records.add(attacker.getName() + " have " + attacker.getHealth() + "HP"
                    + " and " + defender.getName() + " have " + defender.getHealth() + "HP");

        }
        winnerCheck(attacker, defender);
    }
    public void teamBattle(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2, ArrayList<String> records){
        int damageTeam1Droid1 = team1Droid1.getDamage();
        int damageTeam1Droid2 = team1Droid2.getDamage();
        int damageTeam2Droid1 = team2Droid1.getDamage();
        int damageTeam2Droid2 = team2Droid2.getDamage();
        int maxHealthTeam1Droid1 = team1Droid1.getHealth();
        int maxHealthTeam1Droid2 = team1Droid2.getHealth();
        int maxHealthTeam2Droid1 = team2Droid1.getHealth();
        int maxHealthTeam2Droid2 = team2Droid2.getHealth();
        System.out.println("Team 1:\n" +
                "Name: " + team1Droid1.getName()+ " " + team1Droid1.getHealth() + " HP " + "Damage: " + damageTeam1Droid1 +
                "\nName: " + team1Droid2.getName() + " Health: " + team1Droid2.getHealth() + " HP " + "Damage: " + damageTeam1Droid2
                + "VS\n" + "Team 2:\n" +
                "Name: " + team2Droid1.getName() + " Health: " + team2Droid1.getHealth() + " HP" + "Damage: " + damageTeam2Droid1 +
                "\nName: " + team2Droid2.getName() + " Health: " + team2Droid2.getHealth() + " HP" + "Damage: " + damageTeam2Droid2);
        records.add("Team 1:\n" +
                "Name: " + team1Droid1.getName()+ " " + team1Droid1.getHealth() + " HP " + "Damage: " + damageTeam1Droid1 +
                "\nName: " + team1Droid2.getName() + " Health: " + team1Droid2.getHealth() + " HP " + "Damage: " + damageTeam1Droid2
                + "VS\n" + "Team 2:\n" +
                "Name: " + team2Droid1.getName() + " Health: " + team2Droid1.getHealth() + " HP" + "Damage: " + damageTeam2Droid1 +
                "\nName: " + team2Droid2.getName() + " Health: " + team2Droid2.getHealth() + " HP" + "Damage: " + damageTeam2Droid2);
        while((team1Droid1.isAlive() || team1Droid2.isAlive()) &&
                (team2Droid1.isAlive() || team2Droid2.isAlive())){
            if(team2Droid1.isAlive()){
                team2Droid1.takeDamage(damageTeam1Droid1);
            } else if (team2Droid2.isAlive()){
                team2Droid2.takeDamage(damageTeam1Droid1);
            }
            if (team2Droid2.isAlive()){
                team2Droid2.takeDamage(damageTeam1Droid2);
            } else if (team2Droid1.isAlive()){
                team2Droid1.takeDamage(damageTeam1Droid2);
            }
            if(team1Droid1.isAlive()){
                team1Droid1.takeDamage(damageTeam2Droid1);
            } else if (team1Droid2.isAlive()){
                team1Droid2.takeDamage(damageTeam1Droid1);
            }
            if (team1Droid2.isAlive()){
                team1Droid2.takeDamage(damageTeam2Droid2);
            } else if (team1Droid1.isAlive()){
                team1Droid1.takeDamage(damageTeam2Droid2);
            }
            healerTeam(team1Droid1, team1Droid2, maxHealthTeam1Droid1, maxHealthTeam1Droid2);
            healerTeam(team2Droid1, team2Droid2, maxHealthTeam2Droid1, maxHealthTeam2Droid2);
            zeroCheckAndSet(team1Droid1, team2Droid1);
            zeroCheckAndSet(team1Droid2, team2Droid2);
            System.out.println("\tTeam 1:\n"
                    + team1Droid1.getName() + " have " + team1Droid1.getHealth() + " HP and "
                    + team1Droid2.getName() + " have " + team1Droid2.getHealth() + " HP\n" +
                                "\tTeam 2:\n"
                    + team2Droid1.getName() + " have " + team2Droid1.getHealth() + " HP and "
                    + team2Droid2.getName() + " have " + team2Droid2.getHealth() + " HP");
            records.add("\tTeam 1:\n"
                    + team1Droid1.getName() + " have " + team1Droid1.getHealth() + " HP and "
                    + team1Droid2.getName() + " have " + team1Droid2.getHealth() + " HP\n" +
                        "\tTeam 2:\n"
                    + team2Droid1.getName() + " have " + team2Droid1.getHealth() + " HP and "
                    + team2Droid2.getName() + " have " + team2Droid2.getHealth() + " HP");
        }
        winnerTeam(team1Droid1, team1Droid2, team2Droid1, team2Droid2);

    }

    public void zeroCheckAndSet(Droid attacker, Droid defender){
        if (!attacker.isAlive() && !defender.isAlive()) {
            attacker.setHealth(0);
            defender.setHealth(0);
        } else if (!attacker.isAlive()) {
            attacker.setHealth(0);
        } else if (!defender.isAlive()) {
            defender.setHealth(0);
        }

    }

    public void winnerCheck(Droid attacker, Droid defender){
        if (attacker.isAlive()) {
            System.out.println(defender.getName() + " won");
        }else if (defender.isAlive()) {
            System.out.println(attacker.getName() + " won");
        } else {
            System.out.println("Draw");
        }
    }
    public void healerTeam(Droid teamDroid1, Droid teamDroid2, int maxHealthDroid1, int maxHealthDroid2){
        if(teamDroid1 instanceof HealerDroid && teamDroid1.isAlive()
                && teamDroid2 instanceof HealerDroid && teamDroid2.isAlive()){
            HealerDroid healerDroid1 = (HealerDroid) teamDroid1;
            HealerDroid healerDroid2 = (HealerDroid) teamDroid2;
            healerDroid1.giveHeal(healerDroid1, healerDroid2, maxHealthDroid2);
            healerDroid2.giveHeal(healerDroid2, healerDroid1, maxHealthDroid1);
        } else if (teamDroid1 instanceof HealerDroid && teamDroid1.isAlive()){
            HealerDroid healerDroid1 =(HealerDroid) teamDroid1;
            healerDroid1.healMySelf();
        } else if(teamDroid2 instanceof HealerDroid && teamDroid2.isAlive()){
            HealerDroid healerDroid2 = (HealerDroid) teamDroid2;
            healerDroid2.healMySelf();
        }
    }
    public void winnerTeam(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2){
        if(team1Droid1.isAlive() || team1Droid2.isAlive()){
            System.out.println("Team 1 won!");
        } else if (team2Droid1.isAlive() || team2Droid2.isAlive()){
            System.out.println("Team 2 won!");
        } else {
            System.out.println("Draw");
        }
    }
    public static void recordBattle(ArrayList<String> records){
        try{
            BufferedWriter newWriter = new BufferedWriter(new FileWriter("records_of_battles.txt"));
            for (String record: records){
                newWriter.write(record);
                newWriter.newLine();
            }
            newWriter.write("_______________________________________");
            newWriter.close();
            System.out.println("Battle was recorded successfully");
        } catch (IOException e) {
            System.out.println("Error. Saving records of battle was not successful " + e.getMessage());
        }
    }
    public static void replayRecordedBattle(ArrayList<String> records){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("records_of_battles.txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
                records.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error. Reading file was not successful " + e.getMessage());
        }

    }
}
