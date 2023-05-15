package HPCode.composants.Levels;

import HPCode.composants.Characters.Enemy;
import HPCode.composants.Characters.Wizard;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@AllArgsConstructor
public class Level3 {
    private Wizard wizard;
    public void run3(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Lac dans la forêt interdite ---------------------");
        System.out.println("");
        System.out.println("* La troisième année à Poudlard commence. Vous avez probablement entendu dire que les détraqueurs ne sont pas loin d'ici et cherchent un prisonnier. *");
        System.out.println("* Pour prévenir tout événement, le professeur de Défense contre les forces du mal va vous apprendre un sort connu ! *");
        System.out.println("- Enseignant - Bonjour à tous ! Êtes-vous prêt à apprendre un sort incroyable connu ? Oui ? Super ! \n"
                + "C'est : Expecto Patronum. Dites bien 'Expecto Patronum' si vous voulez avoir de meilleures chances de succès.");
        Spell.learnExpectoPatronum(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* Maintenant vous pouvez aller voir Hagrid. Cependant il fait déjà nuit dehors... Faites attention. *");
        Thread.sleep(1500);
        System.out.println("* Lorsque vous vous retrouvez dehors...");
        System.out.println("* 3 détraqueurs arrivent vers toi !!! *");
        Thread.sleep(1500);
        System.out.println("* Que la bataille commence ! *");
        System.out.println("* Je peux te donner un précieux conseil : Le seul sort qui fonctionne est celui que tu viens d'apprendre. *");
        Thread.sleep(1500);
        Enemy dementors = Enemy.Dementor();
        wizard.attack(dementors);
        if (dementors.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* Bien joué ! Tu as survécue ! Je n'ai plus de doute pour la fin de l'année, tu vas réussir. *");
            Thread.sleep(1500);
            PassivLevelUp(wizard);
        } else {
            System.out.println("* Tu as perdu la bataille... GAME OVER *");
            System.exit(0);
        }
    }
}