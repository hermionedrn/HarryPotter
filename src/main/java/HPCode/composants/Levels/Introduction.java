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
        System.out.println("________________________________________________________________________________________________");
        System.out.println("");
        System.out.println("* Bonjour "+ wizard.getFirstName() + " " + wizard.getLastName()+ ". *\n" +
                "* Bienvenue dans Harry Potter at Home ! *\n" +
                "* A présent, tu appartiens à la maison " + wizard.getHouse()+ ". * \n" +
                "* Ta baguette magique est fabriqué en "+ wand.getCore() + " et elle mesure "+wand.getWandSize()+ " cm. *");
        //Thread.sleep(4500);
        System.out.println("");
        Pet pet = Pet.ChoosePet(wizard); //Choose your Pet
        wizard.setPet(pet);
        System.out.println("* Super ! Maintenant tu possèdes un " + pet.name().toLowerCase() + ". *");
        //Thread.sleep(1000);
        System.out.println("");
        System.out.println(wizard.Stats()); //Printing wizard's stats so the user is aware of his characteristics.
        System.out.println("");
        System.out.println("* Que l'aventure commence ! Bonne chance. *");
        //Thread.sleep(2000);
        System.out.println("");

        Potion smallHealPotion = new Potion("Potion de vie", 20);
        wizard.addPotion(smallHealPotion,1);
        System.out.println("* Tu possèdes 1 potion de vie. *");

    }
}
