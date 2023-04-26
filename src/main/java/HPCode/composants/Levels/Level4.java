package HPCode.composants.Levels;

import HPCode.composants.Characters.Wizard;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@AllArgsConstructor
public class Level4 {
    private Wizard wizard;

    public void run4(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Little Hangleton cemetery ---------------------");
        System.out.println("");
        System.out.println("* Welcome in 4th grade ! This year will be quite difficult because you will participate to the three wizards tournament... *");
        Thread.sleep(1500);
        System.out.println("* The year has been charge in exams but you pass ! *");
        System.out.println("* Today is the great day because the tournament START ! You manage to be in the finalist, however it's a trap... *");
        Thread.sleep(2000);
        System.out.println("* You have been teleport in a graveyard... Watch-out you're in the presence of Voldemort and Petter Pettigrew !!!!! *");
        System.out.println("* Catch the Portkey with a spell to escape ! *");
        Thread.sleep(2000);
        CastSpellLevel4();
        System.out.println("* That was close but well done ! Your fourth year in Hogwwards is finished ! *");
        PassivLevelUp(wizard);
    }
    private void CastSpellLevel4(){
        boolean escape = false;
        while (!escape){
            Spell spell = wizard.chooseSpell(wizard.getKnownSpells());// Wizard need to choose a spell in his list of spells.
            boolean castSucces = Spell.castSpell(spell, wizard);// We defined if the wizard succed to cast his spell.
            if (castSucces) {// If he succes to cast the spell he attack.

                switch (spell.getName()) {
                    case "Wingardium Leviosa" -> {
                        System.out.println("* This spell can't get you the Portkey... *");
                        System.out.println("* Voldemort gently roast you with a spell and you loose 10 Max Health points...");
                        wizard.setMaxHealth(wizard.getMaxHealth() - 10);
                        System.out.println(" >>> Your Health : " + wizard.getMaxHealth() + ".");
                    }
                    case "Accio" -> {
                        System.out.println("* Congrats you quickly drag the Portkey to you and escape ! *");
                        escape = true;
                    }
                    case "Expecto Patronum" -> {
                        System.out.println("* This spell can't get you the Portkey... But you cast a bright shield between you and the enemies ! *");
                        System.out.println("* Try another spell *");
                    }
                }
            } else {
                System.out.println("* You missed your spell ... *");
                System.out.println("* Voldemort gently roast you with a spell and you loose 10 Max Health points...");
                wizard.setMaxHealth(wizard.getMaxHealth() - 10);
                System.out.println(" >>> Your Health : " + wizard.getMaxHealth() + ".");
            }
        }
    }
}