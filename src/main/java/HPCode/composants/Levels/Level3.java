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
        System.out.println("-------------------- Lake in the Forbidden Forest ---------------------");
        System.out.println("");
        System.out.println("* The third year in Hogwards starts. However you have heard that dementors are not far from here and look for a prisoner... *");
        System.out.println("* To prevent any kind of evenement, the professor of Defence against forces of evil is going to teach you a knew spell ! *");
        System.out.println("- Teacher - Good morning class ! Are you ready to learn a knew amazing spell ? Yes ? Great ! \n"
                + "It is : Expecto Patronum. Pay attention to say 'Expecto Patronumm' if you want to have better chance of success.");
        Spell.learnExpectoPatronum(wizard.getKnownSpells());
        Thread.sleep(1500);
        System.out.println("* Now with your friend you're about to go to see Hagrid... However it's already dark outside and you should be in your House's rooms... *");
        Thread.sleep(1500);
        System.out.println("* You still go outside... Walk through the park... and...");
        System.out.println("* 3 Dementors comes into you !!! *");
        Thread.sleep(1500);
        System.out.println("* The battle start... *");
        System.out.println("* Small advice : the only way you can beat them is to use the last spell you have learned... *");
        Thread.sleep(1500);
        Enemy dementors = Enemy.Dementor();
        wizard.attack(dementors);
        if (dementors.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* Well done you survived ! I have no doubt that you are going to be successfully for the rest of the year... *");
            Thread.sleep(1500);
            System.out.println("* The third year in Hogwards is now ended. *");
            PassivLevelUp(wizard);
        } else {
            System.out.println("* You loose the fight... GAME OVER *");
            System.exit(0);
        }
    }
}