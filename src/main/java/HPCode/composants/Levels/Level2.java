package HPCode.composants.Levels;

import HPCode.composants.Characters.Enemy;
import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.House;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Scanner;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@Data
@AllArgsConstructor
public class Level2 {
    private Wizard wizard;
    public void run2(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Chamber of Secrets ---------------------");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("* You are now in the second grade at Hogwards. Here is your first class of the year. *\n" +
                "- Teacher - Welcome to class every one, let's learn your second easy spell : Accio. Say 'Accio' and bring your book into your hand.");
        Spell.learnAccio(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* You return in your room, and you find Tom Jedusor's book on your bed... Intrigued by this book, you put it into your pocket. *");
        Thread.sleep(4000);
        System.out.println("* Looking for answers you directly go to the secret chamber and... face the terrible Basilic !!! *");
        Thread.sleep(1500);
        System.out.println("* You need to fight him ! The battle start... *");
        Thread.sleep(1500);
        Enemy basilic = Enemy.Basilic();
        if (wizard.getHouse() == House.GRYFFINDOR) { //If the wizard is Gryffindor.
            System.out.println("* Fortunately you have in your possession Godric Gryffindor's sword because you are in Griffindor's House ! *");
            int choice; //Force the user to enter 1 or 2, unless it doesn't work.
            do {
                System.out.println("* Do you want to use it and slay the Basilic ? *\n" +
                        "1. Yes\n" +
                        "2. No");
                while (!sc.hasNextInt()) {
                    System.out.println("Enter 1 or 2.");
                    sc.next();
                }
                choice = sc.nextInt();
            } while (choice != 1 && choice != 2);
            sc.nextLine();
            switch (choice) { //Action depending on the choice of the user.
                case 1 -> {
                    Thread.sleep(1000);
                    System.out.println("* You run onto the Basilic, avoid his tail, and inflict him a critical hit with the sword ! *");
                    Thread.sleep(1500);
                    System.out.println("Basilic - 999 damages !");
                    basilic.setHealth(basilic.getHealth() - 999);
                    Thread.sleep(1500);
                    System.out.println("* Well done ! Know you slice one of his teeth, and stab Tom Jedusor's book !! *");
                    Thread.sleep(1000);
                    PassivLevelUp(wizard);
                }
                case 2 -> {
                    wizard.attack(basilic);
                    EndLevel2(basilic);
                }
            }
        }else{
            wizard.attack(basilic);
            EndLevel2(basilic);
        }
        System.out.println("* After the recent events : the death of the basilic and the destruction of Tom Jedusor's book, the rest of the year in Hogwards has been quite peacefully. *");
        Thread.sleep(3000);
        System.out.println("* You know have finished your second years... After vacation you'll return for others adventures ! *");
    }
    public void EndLevel2(Enemy basilic) throws InterruptedException{
        if (basilic.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* Well done. Know you slice one of his teeth, and stab Tom Jedusor's book !! *");
            PassivLevelUp(wizard);
            Potion smallHealPotion = new Potion("Small Health Potion", 20);
            Potion mediumHealPotion = new Potion("Medium Health Potion", 40);
            wizard.addPotion(smallHealPotion,1);
            wizard.addPotion(mediumHealPotion,2);
            System.out.println("* You got 1 small health potion and 2 medium health potions. *");
        } else {
            System.out.println("* You loose the fight... GAME OVER *");
            System.exit(0);
        }
    }
}