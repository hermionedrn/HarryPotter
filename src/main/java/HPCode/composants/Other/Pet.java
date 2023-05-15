package HPCode.composants.Other;
import HPCode.composants.Characters.Wizard;

import java.util.Scanner;
public enum Pet {
    OWL,
    RAT,
    CAT,
    TOAD,
    ;

    public static Pet ChoosePet(Wizard wizard) {
        Scanner sc = new Scanner(System.in);
        Pet pet = null;
        int choix = 0;
        while(pet == null) {
            System.out.println("* Lequel de ces animaux aimeriez-vous avoir ? (entrer un chiffre). *\n" +
                    "1. Hibou \n" +
                    "2. Rat \n" +
                    "3. Chat \n" +
                    "4. Crapaud \n");

            if (sc.hasNextInt()) {
                choix = sc.nextInt();
                if (choix < 1 || choix > 4) { //If the user enter a number but not in the list.
                    System.out.println("* Enter a number between 1 and 4. *");
                }
            } else { //If the user enter something else than a number.
                System.out.println("* Enter a number between 1 and 4. *");
                sc.next();
            }
            String choice = "";
            switch (choix) {
                case 1:
                    choice = String.valueOf(OWL);
                    break;
                case 2:
                    choice = String.valueOf(RAT);
                    break;
                case 3:
                    choice = String.valueOf(CAT);
                    break;
                case 4:
                    choice = String.valueOf(TOAD);
                    break;
            }
            for (Pet i : Pet.values()) { //I go through my list of pets with the index i.
                if ( i.name().equals(choice) ) { //We compare the variable choice to the name of the index.
                    pet = i; //We set the pet that correspond to the choice = the index i.
                    break;
                }
            }
        }
        //Modification of statistics with the pet chosen.
        if (pet == Pet.OWL) {
            wizard.setMaxHealth(wizard.getMaxHealth() + 8);
        }
        if (pet == Pet.RAT) {
            wizard.setDefence((float) (wizard.getDefence()+ 0.2));
        }
        if (pet == Pet.CAT) {
            wizard.setDamage(wizard.getDamage() + 4);
        }
        if (pet == Pet.TOAD) {
            wizard.setPotionBonus(wizard.getPotionBonus() + 8);
        }
        return pet;
    }
}
