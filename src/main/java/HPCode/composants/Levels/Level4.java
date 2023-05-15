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
        System.out.println("-------------------- Cimetière de Little Hangleton ---------------------");
        System.out.println("");
        System.out.println("* Bienvenue en 4ème année ! Cette année va être difficile car vous allez participer à un tournoi... *");
        Thread.sleep(1500);
        System.out.println("* Aujourd'hui c'est le tournoi bon courage !! *");
        Thread.sleep(2000);
        System.out.println("* Tu as été téléporté dans un cimetière... Attention il y a aussi Voldemort et Petter Pettigrew !!!!! *");
        System.out.println("* Catch the Portkey with a spell to escape ! *");
        Thread.sleep(2000);
        CastSpellLevel4();
        System.out.println("* C'était juste mais bien joué, car ta 4ème est terminée ! *");
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
                        System.out.println("* Ce sort ne peut pas vous rapporcher du Portkey ... *");
                        System.out.println("* Voldemort vous élimine doucement avec un sort et vous perdez 10 points de vie.");
                        wizard.setMaxHealth(wizard.getMaxHealth() - 10);
                        System.out.println(" >>> Ta vie : " + wizard.getMaxHealth() + ".");
                    }
                    case "Accio" -> {
                        System.out.println("* Bien joué, tu as fait glisser le Portkey vers toi, échappe-toi ! *");
                        escape = true;
                    }
                    case "Expecto Patronum" -> {
                        System.out.println("* Ce sort ne peut pas vous procurer le Portkey, mais tu es protégé par les ennemis ! *");
                        System.out.println("* Essaye un autre sort *");
                    }
                }
            } else {
                System.out.println("* Tu as râté le sort... *");
                System.out.println("* Voldemort t'élimine doucement, tu perds 10 points de vie.");
                wizard.setMaxHealth(wizard.getMaxHealth() - 10);
                System.out.println(" >>> Ta vie : " + wizard.getMaxHealth() + ".");
            }
        }
    }
}