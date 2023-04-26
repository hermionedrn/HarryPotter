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
            System.out.println("Enter Wingardium Leviosaaa if you want to learn it :");
            String choice = sc.nextLine();
            if ("Wingardium Leviosaaa".equals(choice)) {
                //SuccesChance = 90. Wizard accuracy = 5. So 95% chance of succed to cast a spell.
                Spell WingardiumLeviosa = new Spell("Wingardium Leviosa", 85, 2);
                knownSpells.add(WingardiumLeviosa);
                spell = choice;
            } else {
                System.out.println("* You failed to learn the spell. *");
            }
        }
        System.out.println("* You have succeed to learned the spell Wingardium Leviosa. *");
    }

    public static void learnAccio(List<Spell> knownSpells) {
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("Enter Accio if you want to learn it :");
            String choice = sc.nextLine();
            if ("Accio".equals(choice)) {
                Spell Accio = new Spell("Accio", 75, 3);
                knownSpells.add(Accio);
                spell = choice;
            } else {
                System.out.println("* Your book hasn't move *");
                System.out.println("* You failed to learn the spell. *");
            }
        }
        System.out.println("* Your book comes to you slowly... *");
        System.out.println("* You have succeed to learned the spell Accio. *");
    }

    public static void learnExpectoPatronum(List<Spell> knownSpells){
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("Enter the spell if you want to learn it :");
            String choice = sc.nextLine();
            if ("Expecto Patronumm".equals(choice)) {
                Spell ExpectoPatronum = new Spell("Expecto Patronum", 70, 0);
                knownSpells.add(ExpectoPatronum);
                spell = choice;
            } else {
                System.out.println("- Teatcher - You hasn't pay attention to what I have juste said...");
                System.out.println("* You failed to learn the spell. *");
            }
        }
        System.out.println("* You have succeed to learned the spell Expecto Patronum. *");
    }

    public static void learnSectumsempra(List<Spell> knownSpells){
        Scanner sc = new Scanner(System.in);
        String spell = null;
        while (spell == null) {
            System.out.println("- Dumbledor - Well well, i'm going to teatch you a deadly spell... Target this bird and say clearly : Sectuumsemmpraaa. ");
            String choice = sc.nextLine();
            if ("Sectuumsemmpraaa".equals(choice)) {
                Spell Sectumsempra = new Spell("Sectumsempra", 30, 9999);
                knownSpells.add(Sectumsempra);
                spell = choice;
            } else {
                System.out.println("- Dumbledor - Yes yes it is a difficult spell... Try again !");
                System.out.println("* You failed to learn the spell. *");
            }
        }
        System.out.println("* You have succeed to learned the spell Sectumsempra. *");
    }

    // --------------- Spell Mechanic(s) --------------- //
    public static boolean castSpell(Spell spell, Wizard wizard){
        int spellCastChance = spell.getSuccesChance() + wizard.getAccuracy(); // Calculating the accuracy + chance cast of the spell.
        int random = new Random().nextInt(100); // Calculate the chance to succed the casting of the spell.
        boolean castSucces = false;
        if (random <= spellCastChance){
            castSucces = true;
            System.out.println("* TRUE (Your score (if above -> fail) : " + random + "/" + spellCastChance + "."); //For me to see if it works during battle tests
        }else{
            System.out.println("* FALSE (Your score (if above -> fail) : " + random + "/" + spellCastChance + "."); //For me to see if it works during battle tests
        }
        return castSucces;
    }
}