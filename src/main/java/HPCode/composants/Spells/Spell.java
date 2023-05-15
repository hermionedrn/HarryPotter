package HPCode.composants.Spells;

import HPCode.composants.Characters.Wizard;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Data
@EqualsAndHashCode(callSuper = true)
public class Spell extends AbstractSpell {
    public Spell(String name, int succesChance, int spellDamage) {
        super(name, succesChance, spellDamage);
    }


    // --------------- LearnSpells --------------- //
    public void learnWingardium(List<Spell> knownSpells) {
        // No static here but I'm not convinced of the efficacity due to the changes that it has implied. So I only let
        // this one in non-static method.


        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("Entre Wingardium Leviosa si tu veux l'apprendre :");
            String choice = sc.nextLine();
            if ("Wingardium Leviosa".equals(choice)) {
                //SuccesChance = 90. Wizard accuracy = 5. So 95% chance of succed to cast a spell.
                Spell WingardiumLeviosa = new Spell("Wingardium Leviosa", 85, 2);
                knownSpells.add(WingardiumLeviosa);
                spell = choice;
            } else {
                System.out.println("* Tu n'as pas réussi à apprendre le sort. *");
            }
        }
        System.out.println("* Tu as appris avec succès le sort Wingardium Leviosa. *");
    }

    public static void learnAccio(List<Spell> knownSpells) {
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("Entre Accio si tu veux apprendre le sort :");
            String choice = sc.nextLine();
            if ("Accio".equals(choice)) {
                Spell Accio = new Spell("Accio", 75, 3);
                knownSpells.add(Accio);
                spell = choice;
            } else {
                System.out.println("* Ton livre n'a pas bougé *");
                System.out.println("* Tu n'as pas réussi à apprendre le sort. *");
            }
        }
        System.out.println("* Ton livre vient à vous lentement... *");
        System.out.println("* Tu as réussi à apprendre le sort Accio. *");
    }

    public static void learnExpectoPatronum(List<Spell> knownSpells){
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("Entre le sort si tu veux apprendre :");
            String choice = sc.nextLine();
            if ("Expecto Patronum".equals(choice)) {
                Spell ExpectoPatronum = new Spell("Expecto Patronum", 70, 0);
                knownSpells.add(ExpectoPatronum);
                spell = choice;
            } else {
                System.out.println("- Professeur - Tu n'as pas fait attention à ce que je viens de dire...");
                System.out.println("* Tu n'as pas réussi à apprendre le sort. *");
            }
        }
        System.out.println("* Tu as réussi avec succès à apprendre le sort Expecto Patronum. *");
    }

    public static void learnSectumsempra(List<Spell> knownSpells){
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("- Dumbledor - Eh bien, je vais t'apprendre un sortilège mortel... Regarde la cible et dit clairement : Sectumsempra. ");
            String choice = sc.nextLine();
            if ("Sectumsempra".equals(choice)) {
                Spell Sectumsempra = new Spell("Sectumsempra", 30, 9999);
                knownSpells.add(Sectumsempra);
                spell = choice;
            } else {
                System.out.println("- Dumbledor - Oui oui c'est un sort difficile... Essaye encore !");
                System.out.println("* Tu n'as pas réussi à apprendre le sort. *");
            }
        }
        System.out.println("* Tu as appris avec succès à apprendre le sort Sectumsempra. *");
    }

    // --------------- Spell Mechanic(s) --------------- //
    public static boolean castSpell(Spell spell, Wizard wizard){
        int spellCastChance = spell.getSuccesChance() + wizard.getAccuracy(); // Calculating the accuracy + chance cast of the spell.
        int random = new Random().nextInt(100); // Calculate the chance to succed the casting of the spell.
        boolean castSucces = false;
        if (random <= spellCastChance){
            castSucces = true;
            System.out.println("* VRAI (Ton score : " + random + "/" + spellCastChance + "."); //For me to see if it works during battle tests
        }else{
            System.out.println("* FAUX (Ton score : " + random + "/" + spellCastChance + "."); //For me to see if it works during battle tests
        }
        return castSucces;
    }
}