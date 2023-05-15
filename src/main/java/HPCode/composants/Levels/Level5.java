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
        System.out.println("-------------------- Salle d’examen de Poudlard ---------------------");
        System.out.println("");
        System.out.println("* Bienvenue dans votre 5ème années à Poudlard, cette année est assez spéciale car il y a l'examen BUSE et une grande garden party à la fin *");
        Thread.sleep(2500);
        System.out.println("* Pour la garden-party, vous avez besoin de préparer un feu d'artifice pour surprendre tout le monde. *");
        Thread.sleep(3000);
        System.out.println("* Malheureusement tu es avec Dolores Ombrage pour ton cours, tu dois donc la distraire pour partir ! *");
        Thread.sleep(2000);
        GetFirework();
        Thread.sleep(2000);
        System.out.println("* Tout c'est bien passé. Tu es diplomé ! *");
        System.out.println("* Tu as 5ème année est terminé ! *");
        PassivLevelUp(wizard);
    }
    private void GetFirework() throws InterruptedException{
        boolean haveFirework = false;
        int probaGetFirework = 10;
        while (!haveFirework){
            System.out.println("* Essaye de distraire Dolores Ombrage ! Déplace des objets avec des sorts pour l'embêter jusqu'à ce que vous obteniez des feux d'artifice. *");
            Thread.sleep(2000);
            CastSpellLevel5();
            probaGetFirework = probaGetFirework + 20;
            int random = new Random().nextInt(100); // Calculate the chance to have fireworks.
            if (random < probaGetFirework){
                haveFirework = true;
                Thread.sleep(2000);
                System.out.println("* Tu es prêts à utiiliser les feux d'artifice. *");
                System.out.println("* Tu peux quitter la classe. *");

                Potion mediumHealPotion = new Potion("Potion de vie moyenne", 40);
                Potion bigHealPotion = new Potion("Potion de vie grande", 60);
                wizard.addPotion(mediumHealPotion,2);
                wizard.addPotion(bigHealPotion,1);
                System.out.println("* Tu as une grande potion de vie et deux potions. *");
            } else {
                System.out.println("* Ce n'est pas assez, continue ! *");
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
                    System.out.println("* Tu as déplacé un objet pour la distaire 1 minute. *");
                }
                case "Accio" -> {
                    Thread.sleep(1000);
                    System.out.println("* Tu as déplacé un objet pour la distaire 1 minute. *");
                }
                case "Expecto Patronum" -> {
                    Thread.sleep(1000);
                    System.out.println("* Non, tu ne peux pas lancer ce sort pour la distraire. *");
                }
            }
        } else {
            System.out.println("* Tu as manqué le sort. *");
        }
    }
}
