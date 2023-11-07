package main;

import Battle.Battle;
import Droids.BattleDroid;
import Droids.Droid;
import Droids.HealerDroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    List <Droid> DroidList = new ArrayList<>();
    List <Battle> BattleList = new ArrayList<>();
    ArrayList<String> records = new ArrayList();
        Scanner s = new Scanner(System.in);
        int menu_choice;
        System.out.println("Зміна");
        System.out.println("Welcome to Droid Battle!");
    while(true) {
        System.out.println("Make your choice:" +
                "\n 1 - Create new droid\n 2 - List of droids\n 3 - Start 1v1 battle" +
                "\n 4 - Start team battle\n 5 - Save record of battle\n 6 - Replay battle\n 7 - Exit");
        menu_choice = s.nextInt();
        int count = 0;
        switch (menu_choice) {
            case (1):
                try {
                    System.out.println("Choose type of droid:\n1 - Battle droid\n2 - Healer");
                    int type = s.nextInt();
                    System.out.print("Enter name: ");
                    String name = s.next();
                    System.out.print("Enter health: ");
                    int health = s.nextInt();
                    System.out.print("Enter damage: ");
                    int damage = s.nextInt();
                    if (type == 1) {
                        System.out.print("Enter armor: ");
                        int armor = s.nextInt();
                        DroidList.add(new BattleDroid(name, health, damage, armor));
                    } else {
                        System.out.print("Enter heal: ");
                        int heal = s.nextInt();
                        DroidList.add(new HealerDroid(name, health, damage, heal));
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Wrong input, try again");
                    break;
                }
                break;
            case (2):
                System.out.println("List of Droids:");
                for (Object droid : DroidList) {
                    System.out.println(droid);
                }
                break;
            case (3):
                if (DroidList.size() < 2){
                    System.out.println("You do not created 2 droids for battle");
                    break;
                }
                System.out.println("Choose droids for battle 1v1:");
                for (int i = 0; i < DroidList.size(); i++) {
                    System.out.println("Droid " + (i + 1) + ": " + DroidList.get(i));
                }
                System.out.println("First droid: ");
                int first_choice = s.nextInt();
                System.out.println("Second droid: ");
                int second_choice = s.nextInt();
                if (first_choice == second_choice){
                    System.out.println("It`s the same droid. Try again and choose another one.");
                    break;
                }
                BattleList.add(new Battle(DroidList.get(first_choice-1), DroidList.get(second_choice-1)));
                BattleList.get(count).fight1v1(DroidList.get(first_choice-1), DroidList.get(second_choice-1), records);


                break;
            case (4):
                System.out.println("Choose droids for battle 2v2:");
                for (int i = 0; i < DroidList.size(); i++) {
                    System.out.println("Droid " + (i + 1) + ": " + DroidList.get(i));
                }
                System.out.print("Team 1: First Droid:");
                int team1Droid1 = s.nextInt();
                System.out.println("Team 1: Second Droid:");
                int team1Droid2 = s.nextInt();
                System.out.println("Team 2: First Droid:");
                int team2Droid1 = s.nextInt();
                System.out.println("Team 2: Second Droid:");
                int team2Droid2 = s.nextInt();
                if(isChoiceUnique(team1Droid1, team1Droid2, team2Droid1, team2Droid2)){
                    break;
                }
                BattleList.add(new Battle(DroidList.get(team1Droid1-1), DroidList.get(team1Droid2-1),
                        DroidList.get(team2Droid1-1), DroidList.get(team2Droid2-1)));
                for(int i =0; i<BattleList.size(); i++) {
                    BattleList.get(count).teamBattle(DroidList.get(team1Droid1 - 1), DroidList.get(team1Droid2 - 1),
                            DroidList.get(team2Droid1 - 1), DroidList.get(team2Droid2 - 1), records);
                    count++;
                }
                break;
            case(5):
                Battle.recordBattle(records);
                break;
            case(6):
                Battle.replayRecordedBattle(records);
                break;
            case(7):
                s.close();
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input, try again.");
                break;
        }
    }
    }
    public static boolean isChoiceUnique(int team1droid1, int team1droid2, int team2droid1, int team2droid2){
        if(team1droid1 == team1droid2 || team1droid1 == team2droid1 || team1droid1 == team2droid2 ||
                team1droid2 == team2droid1 || team1droid2 == team2droid2 ||
                team2droid1 == team2droid2){
            return true;
        }
        return false;
    }

}
