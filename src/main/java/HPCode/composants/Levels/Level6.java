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
        System.out.println("-------------------- Tour d'astronomie ---------------------");
        System.out.println("");
        System.out.println("* Dumbledore sent cet été que des choses terribles vont se passer alors il a décidé de vous apprendre Sectumsempra, un sortilège mortel...  *");
        Thread.sleep(1000);
        Spell.learnSectumsempra(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* Des Mangemort attaquent Poudlard !! Tu dois défendre ton école !");
        Enemy mangemort = Enemy.Mangemort();
        Enemy ombrage = Enemy.DoloresOmbrage();
        if (wizard.getHouse() == House.SERPENTARD){
            System.out.println("* Veux-tu rejoindre les Mangemorts pour être contre Poudlard ? *");
            Scanner sc = new Scanner(System.in);
            int choice; //Force the user to enter 1 or 2, unless it doesn't work.
            do {
                System.out.println("* Tu veux les rejoindre ? *\n" +
                        "1. Yes\n" +
                        "2. No");
                while (!sc.hasNextInt()) {
                    System.out.println("Entre 1 ou 2.");
                    sc.next();
                }
                choice = sc.nextInt();
            } while (choice != 1 && choice != 2);
            sc.nextLine();
            switch (choice) { //Action depending on the choice of the user.
                case 1 -> {//If yes.
                    wizard.setHavePastDarkSide(true);
                    System.out.println("* Dolores Ombrage tas vu changé de camps, tu vas devoir l'affronter ! Que la bataille commence.");
                    Thread.sleep(2000);
                    wizard.attack(ombrage);
                    if (ombrage.getHealth() <= 0){
                        Thread.sleep(1500);
                        System.out.println("* Tu l'as vaincue, mais les mangemorts perdent le combat, tu dois quitter le champ de bataille. *");
                        PassivLevelUp(wizard);
                    } else {
                        System.out.println("* Tu as perdu la bataille... GAME OVER *");
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
        System.out.println("* Le permier Mangemort arrive. La bataille commence. *");
        Thread.sleep(1500);
        wizard.attack(mangemort);
        if (mangemort.getHealth() <= 0){
            Thread.sleep(2000);
            System.out.println("* Félicitation ! Cependant ce n'est pas fini, d'autres arrivent ! *");
            wizard.attack(mangemort);
            if (mangemort.getHealth() <= 0){
                Thread.sleep(2000);
                System.out.println("* Bravo tu as réussi à tous les combattres. *");
                System.out.println("* A présent, tu passes en 7ème année. *");
                Thread.sleep(1500);
                PassivLevelUp(wizard);
                Potion bigHealPotion = new Potion("Potion de vie grande", 60);
                wizard.addPotion(bigHealPotion,2);
                System.out.println("* Tu possèdes 2 grandes potions de vie. *");
            } else {
                System.out.println("* Tu as perdu la bataille... GAME OVER *");
                System.exit(0);
            }
        }else {
            System.out.println("* Tu as perdu la bataille... GAME OVER *");
            System.exit(0);
        }
    }
}