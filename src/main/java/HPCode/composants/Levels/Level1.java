package HPCode.composants.Levels;

import HPCode.composants.Characters.Enemy;
import HPCode.composants.Characters.Wizard;
import HPCode.composants.Other.Potion;
import HPCode.composants.Spells.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Scanner;

import static HPCode.composants.Characters.Wizard.PassivLevelUp;

@Data
@AllArgsConstructor
public class Level1 {
    @NonNull private Wizard wizard;
    public void run1(Wizard wizard) throws InterruptedException {
        System.out.println("");
        System.out.println("-------------------- Toilettes du donjon ---------------------");
        System.out.println("");
        System.out.println("* C'est ta première année dans Harry Potter at Home. Aujourd'hui c'est ta première classe. *\n"+
                "- Professeur - Bienvenue tout le monde, pour votre première leçon vous allez apprendre votre premier sortilège : Wingardium Leviosa.");
        Spell WingardiumLeviosa = new Spell("Wingardium Leviosa", 85, 2);
        WingardiumLeviosa.learnWingardium(wizard.getKnownSpells());
        Thread.sleep(1000);
        System.out.println("* Pour voir si vous l'avez bien acquis, rendez-vous maintenant dans les toilettes à côté du donjon... *");
        Thread.sleep(3000);
        System.out.println(" . . . ");
        Thread.sleep(1000);
        Enemy troll = Enemy.Troll();
        System.out.println("- Troll - Rooooarrrrghh !!!");
        Thread.sleep(1500);
        System.out.println("* C'est l'heure de votre premier combat ! Que la bataille commence... *");
        Thread.sleep(1500);
        wizard.attack(troll);
        if (troll.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* Bien joué, tu as terminé ta première année à Harry Potter at Home. *");
            PassivLevelUp(wizard);
            Potion smallHealPotion = new Potion("Potion de vie", 20);
            wizard.addPotion(smallHealPotion,2);
            System.out.println("* Tu as obtenu 2 potion de vie. *");
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("* Tu as perdu le combat... GAME OVER *");
            System.exit(0);
        }

    }
}