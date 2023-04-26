package HPCode.composants.Levels;

import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;

import java.util.Random;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@AllArgsConstructor
public class Level5 {
    private Wizard wizard;
    public void run5(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Hogwarts examination room ---------------------");
        System.out.println("");
        System.out.println("* Welcome in your fifth years in Hogwards, this year is quite special because there is the BUSE exam, plus a big garden party at the end. *");
        Thread.sleep(2500);
        System.out.println("* To prepare the garden party you need firework to surprise every one. However you need Fredd and George (in your class) to create those ones before. *");
        Thread.sleep(3000);
        System.out.println("* Unfortunately you are with Ombrage for your class, so you need to distract her to secure Fredd and George ! *");
        Thread.sleep(2000);
        GetFirework();
        Thread.sleep(2000);
        System.out.println("* Everything went good. You have been diplomed, well done ! *");
        System.out.println("* Your fifth year is now finished ! *");
        PassivLevelUp(wizard);
    }
    private void GetFirework() throws InterruptedException{
        boolean haveFirework = false;
        int probaGetFirework = 10;
        while (!haveFirework){
            System.out.println("* Disturb Ombrage ! Move objects with spells to annoy her until you get fireworks... *");
            Thread.sleep(2000);
            CastSpellLevel5();
            probaGetFirework = probaGetFirework + 20;
            int random = new Random().nextInt(100); // Calculate the chance to have fireworks.
            if (random < probaGetFirework){
                haveFirework = true;
                Thread.sleep(2000);
                System.out.println("* Fredd and Georg finally make pop Fireworks in your Wizard's coat ! They are ready to use. You can dismiss your class with Ombrage ! *");
                System.out.println("* You left the class ... *");

                Potion mediumHealPotion = new Potion("Medium Health Potion", 40);
                Potion bigHealPotion = new Potion("Big Health Potion", 60);
                wizard.addPotion(mediumHealPotion,2);
                wizard.addPotion(bigHealPotion,1);
                System.out.println("* You got 1 big health potion and 2 medium health potions. *");
            } else {
                System.out.println("* It is not enough, continue ! *");
            }
        }
    }

    private void CastSpellLevel5() throws InterruptedException{

        Spell spell = wizard.chooseSpell(wizard.getKnownSpells());// Wizard need to choose a spell in his list of spells.
        boolean castSucces = Spell.castSpell(spell, wizard);// We defined if the wizard succed to cast his spell.
        if (castSucces) {// If he succes to cast the spell he attack.

            switch (spell.getName()) {
                case "Wingardium Leviosa" -> {
                    Thread.sleep(1000);
                    System.out.println("* You move an object around her back and distract her for a minute... *");
                }
                case "Accio" -> {
                    Thread.sleep(1000);
                    System.out.println("* You move an object behind her back and distract her for a minute... *");
                }
                case "Expecto Patronum" -> {
                    Thread.sleep(1000);
                    System.out.println("* No you do not want to cast this spell to distract her... *");
                }
            }
        } else {
            System.out.println("* You missed your spell... *");
        }
    }
}
