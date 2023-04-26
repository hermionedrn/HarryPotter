package HPCode.composants.Levels;

import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.Pet;
import HPCode.composants.Other.Potion;
import HPCode.composants.WandStuff.Wand;

public class Introduction {
    public void runi(Wizard wizard) {
        Wand wand = wizard.getWand();
        // --------------- Start of the adventure --------------- //
        System.out.println("________________________________________________________________________________________________");
        System.out.println("  _____                _ _               _               _                 _                  ");
        System.out.println(" |  __ \\              | | |             | |     /\\      | |               | |                 ");
        System.out.println(" | |__) |__  _   _  __| | | __ _ _ __ __| |    /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___ ");
        System.out.println(" |  ___/ _ \\| | | |/ _` | |/ _` | '__/ _` |   / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\");
        System.out.println(" | |  | (_) | |_| | (_| | | (_| | | | (_| |  / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/");
        System.out.println(" |_|   \\___/ \\__,_|\\__,_|_|\\__,_|_|  \\__,_| /_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|");
        System.out.println("________________________________________________________________________________________________");
        System.out.println("");
        System.out.println("* Hello "+ wizard.getFirstName() + " " + wizard.getLastName()+ ". *\n" +
                "* Welcome to Hogwards ! *\n" +
                "* You are in the " + wizard.getHouse()+ " house. * \n" +
                "* Your wand is made of "+ wand.getCore() + " and is "+wand.getWandSize()+ " cm long. *");
        //Thread.sleep(4500);
        System.out.println("");
        Pet pet = Pet.ChoosePet(wizard); //Choose your Pet
        wizard.setPet(pet);
        System.out.println("* Great now you own a " + pet.name().toLowerCase() + ". *");
        //Thread.sleep(1000);
        System.out.println("");
        System.out.println(wizard.Stats()); //Printing wizard's stats so the user is aware of his characteristics.
        System.out.println("");
        System.out.println("* Let's start the adventure ! *");
        //Thread.sleep(2000);
        System.out.println("");

        Potion smallHealPotion = new Potion("Small Health Potion", 20);
        wizard.addPotion(smallHealPotion,1);
        System.out.println("* You got 1 small health potion. *");

    }
}
