package HPCode.composants.Characters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import HPCode.composants.Battle;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import HPCode.composants.WandStuff.Wand;
import HPCode.composants.Other.House;
import HPCode.composants.Other.Pet;

import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@AllArgsConstructor
public class Wizard extends Character {
    private int potionBonus;
    private final String firstName;
    private final String lastName;
    private Pet pet;
    private Wand wand;
    private House house;
    private final List<Spell> knownSpells;
    private final List<Potion> potions;
    private boolean HavePastDarkSide = false;

    //I make a constructor because i have a problem with lomebok
    public Wizard(int health, int defence, int damage, int accuracy, int potionBonus, String firstName, String lastName, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<Potion> potions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
        setMaxHealth(health);
        setDefence(defence);
        setDamage(damage);
        setAccuracy(accuracy);
        setPotionBonus(potionBonus);
    }
    public void attack(Character target) throws InterruptedException { //attack function
        Battle battle = new Battle(this, (Enemy) target);
        battle.start();
    }

    // --------------- Spell --------------- //
    public Spell chooseSpell(List<Spell> knownSpells) { //Choose a spell use in battle loop.
        Scanner sc = new Scanner(System.in);
        System.out.println("* Choose a spell to cast: (Enter a number) *");
        int index = 1; // Start at 1, so the choices start with 1. and not 0.
        for (Spell spell : knownSpells) { //Choice like this : 1. Wingardium Leviosa.
            System.out.println(index++ + ". " + spell.getName());
        }
        int choice; //Make sure the user is typing a valid spell number (an existing spell in the list).
        do {
            choice = sc.nextInt();
            if (choice < 1 || choice > knownSpells.size()) {
                System.out.println("Enter a number in the list.");
            }
        } while (choice < 1 || choice > knownSpells.size());
        return knownSpells.get(choice - 1);// -1 to select the right choice according to the user because Lists start at indices 0, and our indice start at 1.
    }

    // --------------- Potion --------------- //
    public Potion choosePotion(List<Potion> potions) { //Choose a potion use in battle loop.
        Scanner sc = new Scanner(System.in);
        System.out.println("* Choose a potion to use: (Enter a number) *");
        PrintPotions();
        int choice; //Make sure the user is typing a valid potion number (an existing potion in the list).
        do {
            choice = sc.nextInt();
            if (choice < 1 || choice > knownSpells.size()) {
                System.out.println("Enter a number in the list.");
            }
        } while (choice < 1 || choice > knownSpells.size());
        return potions.get(choice - 1);// -1 to select the right choice according to the user because List start at indices 0.
    }
    public void PrintPotions() {
        List<String> uniquePotions = new ArrayList<>(); //Add potion that have the wizard to the list. But not in double.
        for (Potion potion : potions) {
            String potionName = potion.getName();
            if (!uniquePotions.contains(potionName)) {
                uniquePotions.add(potionName);
            }
        }
        int index = 1;
        for (String potionName : uniquePotions) { //Count the occurrence of each potion that the wizard posses, in order to print the right number of potion possessed.
            int count = 0;
            for (Potion potion : potions) {
                if (potion.getName().equals(potionName)) {
                    count++;
                }
            }
            System.out.println(index++ + ". " + count + "x " + potionName);
        }
    }

    public void addPotion(Potion potion, int quantity) {
        for (int i = 0; i < quantity; i++) {
            potions.add(potion);
        }
    }
    // --------------- Levels --------------- //
    public static void levelUp(Wizard wizard) {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Congrats you passed the level ! Choose the stat you want to level up : (Enter a number) *");
        System.out.println("1. Health\n" +
                "2. Damage\n" +
                "3. Defense\n" +
                "4. Potion Bonus Efficacy");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                int newHealth = wizard.getMaxHealth() + 15;
                wizard.setMaxHealth(newHealth);
                System.out.println("* Your health has been increased by 15. *");
                System.out.println(wizard.Stats());
            }
            case 2 -> {
                int newDamage = wizard.getDamage() + 4;
                wizard.setDamage(newDamage);
                System.out.println("* Your damage has been increased to by 4. *");
                System.out.println(wizard.Stats());
            }
            case 3 -> {
                float newDefense = (float) (wizard.getDefence() + 0.1);
                wizard.setDefence(newDefense);
                System.out.println("* Your defense has been increased by 10%. *");
                System.out.println(wizard.Stats());
            }
            case 4 -> {
                int newPotionBonus = wizard.getPotionBonus() + 20;
                wizard.setPotionBonus(newPotionBonus);
                System.out.println("* Your potion bonus has been increased by 20. *");
                System.out.println(wizard.Stats());
            }
            default -> System.out.println("* Invalid choice. Enter a number. *");
        }
    }

    public static void PassivLevelUp(Wizard wizard) { //Levelup stats of the wizard after each years in Hogwards.
        wizard.setMaxHealth(wizard.getMaxHealth() + 10);
        wizard.setDamage(wizard.getDamage() + 4);
        wizard.setPotionBonus(wizard.getPotionBonus() + 5);
        System.out.println(wizard.Stats());
    }

    // --------------- Stats --------------- //
    public String Stats() {
        StringBuilder spells = new StringBuilder();
        return  "*--------Your Stats--------*" +
                "\n" +
                " Name and Last Name : " + getFirstName() + " " + getLastName() + "\n" +
                " Health : " + getMaxHealth() + "\n" +
                " Defence : " + getDefence() + "\n" +
                " Damage : " + getDamage() + "\n" +
                " Accuracy : " + getAccuracy() + "\n" +
                " Potion Bonus Efficacity : " + getPotionBonus() + "\n" +
                " House : " + getHouse() + "\n" +
                " Pet : " + getPet() + "\n" +
                " Wand : " + getWand() + "\n" +
                "*--------------------------*" ;
    }

    public void defend() {}

}