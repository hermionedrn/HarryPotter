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
        System.out.println("-------------------- Chambre des secrets ---------------------");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("* Bien joué, tu es en deuxième année. *\n" +
                "- Professeur - Bonjour à tous, apprenons votre deuxième sort : Accio. Dites 'Accio'");
        Spell.learnAccio(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* En sortant du cours vous vous baladez et vous vous retrouvez face au Basilic !! AAAH ");
        Thread.sleep(1500);
        System.out.println("* Tu vas devoir te battre contre lui ! Que la bataille... *");
        Thread.sleep(1500);
        Enemy basilic = Enemy.Basilic();
        if (wizard.getHouse() == House.GRYFFONDOR) { //If the wizard is Gryffindor.
            System.out.println("* Comme tu appartiens à la maison Gryffondor, tu as en ta posséssion l'épée de Godric Gryffondor ! *");
            int choice; //Force the user to enter 1 or 2, unless it doesn't work.
            do {
                System.out.println("* Veux-tu l'utiliser pour vaincre le Basilic ? *\n" +
                        "1. Oui\n" +
                        "2. Non");
                while (!sc.hasNextInt()) {
                    System.out.println("Entre 1 ou 2.");
                    sc.next();
                }
                choice = sc.nextInt();
            } while (choice != 1 && choice != 2);
            sc.nextLine();
            switch (choice) { //Action depending on the choice of the user.
                case 1 -> {
                    Thread.sleep(1000);
                    System.out.println("* Vous foncez sur la Basilique, évitez sa queue, et lui infligez un coup critique avec l'épée ! *");
                    Thread.sleep(1500);
                    System.out.println("Basilic - 999 dégâts !");
                    basilic.setHealth(basilic.getHealth() - 999);
                    Thread.sleep(1500);
                    System.out.println("* Bien joué ! Tu viens de lui trancher une dent *");
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
        System.out.println("* Après les derniers évèments : la mort du Basilic, ta duexième année à l'école des sorciers s'est plutôt bien passé. *");
        Thread.sleep(3000);
        System.out.println("* Tu as fini la deuxième année... On se revoit vite après les vacances ! *");
    }
    public void EndLevel2(Enemy basilic) throws InterruptedException{
        if (basilic.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* Bien joué. Tu lui a tranché une dent !! *");
            PassivLevelUp(wizard);
            Potion smallHealPotion = new Potion("Potion de vie Petite", 20);
            Potion mediumHealPotion = new Potion("Potion de vie Moyenne", 40);
            wizard.addPotion(smallHealPotion,1);
            wizard.addPotion(mediumHealPotion,2);
            System.out.println("* Tu as 1 petite potion de vie et 2 potion de vie moyenne. *");
        } else {
            System.out.println("* Tu as perdu la bataille... GAME OVER *");
            System.exit(0);
        }
    }
}