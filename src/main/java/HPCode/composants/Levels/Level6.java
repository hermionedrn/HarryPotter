package HPCode.composants.Levels;

import HPCode.composants.Characters.Enemy;
import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.House;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;

import java.util.Scanner;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@AllArgsConstructor
public class Level6 {
    private Wizard wizard;
    public void run6(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Astronomy tower ---------------------");
        System.out.println("");
        System.out.println("* Dumbledor feels this summer that terrible things are going to happened so he decided to learn you Sectumsempra, a deadly spell...  *");
        Thread.sleep(1000);
        Spell.learnSectumsempra(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* Mangemort are attacking Hogwards !! You need to defend your school !");
        Enemy mangemort = Enemy.Mangemort();
        Enemy ombrage = Enemy.DoloresOmbrage();
        if (wizard.getHouse() == House.SLYTHERIN){
            System.out.println("* Do you want to join Mangemorts aginst Hogwards ? *");
            //oui | non
            //oui -> fight ombrage.
            //non -> Comme le else.
            Scanner sc = new Scanner(System.in);
            int choice; //Force the user to enter 1 or 2, unless it doesn't work.
            do {
                System.out.println("* Do you want to join them ? *\n" +
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
                case 1 -> {//If yes.
                    wizard.setHavePastDarkSide(true);
                    System.out.println("* Ombrage have seen you changing camps. She decided to fight you ! The battle start...");
                    Thread.sleep(2000);
                    wizard.attack(ombrage);
                    if (ombrage.getHealth() <= 0){
                        Thread.sleep(1500);
                        System.out.println("* You have defeted her... You feel a bit weird... However the mangemorts are loosing the fight so you left the battlefied with them. *");
                        PassivLevelUp(wizard);
                    } else {
                        System.out.println("* You loose the fight... GAME OVER *");
                        System.exit(0);
                    }
                }
                case 2 -> {//If no.
                    EndLevel6(mangemort);
                }
            }
        } else {// If not slytherin.
            EndLevel6(mangemort);
        }
    }
    private void EndLevel6(Enemy mangemort) throws InterruptedException {
        System.out.println("* Watch out here is the first Mangemort ! The battle start... *");
        Thread.sleep(1500);
        wizard.attack(mangemort);
        if (mangemort.getHealth() <= 0){
            Thread.sleep(2000);
            System.out.println("* Congrats ! However it is not finished... Here is another one ! *");
            wizard.attack(mangemort);
            if (mangemort.getHealth() <= 0){
                Thread.sleep(2000);
                System.out.println("* Well done ! The teatchers have finished battling the invaders. The battle ends. *");
                System.out.println("* You have passed the sixth years. *");
                Thread.sleep(1500);
                PassivLevelUp(wizard);
                Potion bigHealPotion = new Potion("Big Health Potion", 60);
                wizard.addPotion(bigHealPotion,2);
                System.out.println("* You got 2 big health potions. *");
            } else {
                System.out.println("* You loose the fight... GAME OVER *");
                System.exit(0);
            }
        }else {
            System.out.println("* You loose the fight... GAME OVER *");
            System.exit(0);
        }
    }
}