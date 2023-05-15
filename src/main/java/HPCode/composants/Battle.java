package HPCode.composants;

import java.util.Scanner;

import static HPCode.composants.Characters.Wizard.levelUp;

import HPCode.composants.Characters.AbstractEnemy;
import HPCode.composants.Characters.Enemy;
import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Battle {
    Scanner sc = new Scanner(System.in);
    private Wizard wizard;
    private Enemy enemy;
    private boolean isFinished = false; //True when the battle is finished.

    // --------------- Battle main code --------------- //
    public Battle(Wizard wizard, Enemy enemy) { //Used in attack in Wizard.java
        this.wizard = wizard;
        this.enemy = enemy;
    }

    public void start() throws InterruptedException {
        wizard.setHealth(wizard.getMaxHealth()); //We use health as a temporary variable of the health during the battle.
        enemy.setHealth(enemy.getMaxHealth());// So this health is accurate only inside battles
        System.out.println(" ----- Vos Statistiques ----- ");
        System.out.println("Ta vie : " + wizard.getHealth() + " | Dégâts : " + wizard.getDamage() + " | Défense : " + wizard.getDefence());
        System.out.println(enemy.getName() + " Vie : " + enemy.getHealth() + " | Dégâts : " + enemy.getDamage() + " | Défense : " + enemy.getDefence());
        System.out.println("* ------------------------- *");
        while (!isFinished) { //To define if the battle is finished or not. It is finish when the wizard or enemy is dead.
            // --------------- Player turn --------------- //
            PlayerTurn();
            // --------------- Enemy turn --------------- //
            EnemyTurn();
        }
    }

    // --------------- Functions used in Battle main code --------------- //
    private void PlayerTurn() throws InterruptedException {
        System.out.println("");
        Thread.sleep(2000);
        System.out.println(" ----- A ton tour ----- ");
        int choice; //Force the user to enter 1 or 2, unless it doesn't work.
        do {
            System.out.println("Choisi une actiion : (Entre le chiffre)\n" +
                    "1. Jeter un sort \n" +
                    "2. Utiliser une potion");
            while (!sc.hasNextInt()) {
                System.out.println("Entre 1 ou 2.");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);
        sc.nextLine();
        switch (choice) { //Action depending on the choice of the user
            case 1 -> {
                CastSpell(); //Cast a spell
            }
            case 2 -> {
                if (wizard.getPotions().isEmpty()) {
                    System.out.println("* Tu n'as pas de potion. *");
                    System.out.println("* Utilise un sort à la place. *");
                    CastSpell();
                } else {
                    UsePotion(); //Use a potion
                }
            }
        }
        isDead(wizard, enemy);//Check if battle is finished.
    }

    private void EnemyTurn() throws InterruptedException {
        if (!isFinished) {
            System.out.println("");
            System.out.println("* ----- Au tour de l'enemy ------ *");
            System.out.println("* " + enemy.getName() + " Tu as été attaqué ! *");
            enemy.damageCalc(wizard);
            System.out.println(wizard.getFirstName() + " " + wizard.getLastName() + " - " + enemy.damageCalc(wizard) + " dommages");
            wizard.setHealth(wizard.getHealth() - enemy.damageCalc(wizard)); // There is a + because enemy.damageCalc(wizard) is already negativ.
            Thread.sleep(1000);
            System.out.println("     ***\n" + "Ta vie : " + wizard.getHealth() + " | Dégâts : " + wizard.getDamage() + " | Défense : " + wizard.getDefence());
            System.out.println(enemy.getName() + " vie : " + enemy.getHealth() + " | Dégâts : " + enemy.getDamage() + " | Défense : " + enemy.getDefence() + "\n" + "     ***");
            isDead(wizard, enemy);//Check if battle is finished.
        }
    }

    private void CastSpell() throws InterruptedException {
        //ChooseSpell in Wizard.java, others spells function in Spell.java
        Spell spell = wizard.chooseSpell(wizard.getKnownSpells());// Wizard need to choose a spell in his list of spells.
        boolean castSucces = Spell.castSpell(spell, wizard);// We defined if the wizard succed to cast his spell.
        if (castSucces) {// If he succes to cast the spell he attack.

            switch (spell.getName()) {
                case "Wingardium Leviosa" -> {
                    System.out.println("* Tu fais léviter un objet loud au-dessus de la tête de " + enemy.getName() + " et... *");
                    Thread.sleep(500);
                    System.out.println("*  ! BOUM ! *");
                    DamageToEnemy();
                }
                case "Accio" -> {
                    System.out.println("* Tu as arraché une des crocs de " + enemy.getName() + " ! *");
                    Thread.sleep(500);
                    System.out.println("-" + enemy.getName() + "- Arrgh !");
                    wizard.setDamage(wizard.getDamage() + spell.getSpellDamage());
                    SpecialCaseBasilic(); //The DamageToEnemy function is in there.
                }
                case "Expecto Patronum" -> {
                    System.out.println("* Tu as attaqué " + enemy.getName() + ", il ne peut rien faire. *");
                    SpecialCaseDementors(); //The DamageToEnemy function is in there.
                }
                case "Sectumsempra" -> {
                    System.out.println("* Une puissante lumière brise l'air et frappe violemment " + enemy.getName() + " ! *");
                    enemy.setHealth(0);
                }
            }
        } else {
            System.out.println("* Tu as raté ... *");
        }
    }

    private void UsePotion() throws InterruptedException {
        Potion potion = wizard.choosePotion(wizard.getPotions());// Wizard need to choose a potion in his list of potions.
        switch (potion.getName()) {
            case "Small Health Potion", "Medium Health Potion", "Big Health Potion" -> {
                wizard.setHealth(wizard.getHealth() + potion.getValues() + wizard.getPotionBonus());
                int healgain = potion.getValues() + wizard.getPotionBonus();
                System.out.println("* You have heal yourself by " + healgain + " points. *");
                Thread.sleep(1000);
                wizard.getPotions().remove(potion);
                System.out.println("* You have used " + potion.getName() + ". *");
            }
        }
    }

    private void DamageToEnemy() throws InterruptedException {
        wizard.damageCalc(enemy); //Calculate damages
        System.out.println(enemy.getName() + " - " + wizard.damageCalc(enemy) + " dégâts ");
        enemy.setHealth(enemy.getHealth() - wizard.damageCalc(enemy));//Modification of the Health of the enemy.
        Thread.sleep(1000);
        System.out.println("     ***\n" + "Ta vie : " + wizard.getHealth() + " | Dégâts : " + wizard.getDamage() + " | Défense : " + wizard.getDefence());
        System.out.println(enemy.getName() + " vie : " + enemy.getHealth() + " | Dégâts : " + enemy.getDamage() + " | Défense : " + enemy.getDefence() + "\n" + "     ***");
    }

    private void isDead(Wizard wizard, AbstractEnemy enemy) {
        if (wizard.getHealth() <= 0) {
            System.out.println("* Tu as été vaincu par " + enemy.getName() + " ! *");
            isFinished = true; // End of the battle
        } else if (enemy.getHealth() <= 0) {
            System.out.println("* Tu as vaincu " + enemy.getName() + " ! *");
            levelUp(wizard);
            isFinished = true; // End of the battle
        }
    }

    private void SpecialCaseBasilic() throws InterruptedException {
        if (enemy.getName() == "Basilic") {
            wizard.setDamage(wizard.getDamage() + 20);
            DamageToEnemy();
            wizard.setDamage(wizard.getDamage() - 20);
        } else {
            DamageToEnemy();
        }
    }

    private void SpecialCaseDementors() throws InterruptedException {
        if (enemy.getName() == "Détraqueur") {
            System.out.println("* Les détraqueurs ont peur de toi et abandonnent le combat... *");
            enemy.setHealth(0);
        } else {
            enemy.setDamage(1);
            DamageToEnemy();
        }
    }
}
