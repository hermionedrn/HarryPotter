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
        System.out.println("-------------------- Dungeon toilets ---------------------");
        System.out.println("");
        System.out.println("* You are now in the first grade at Hogwards. Here is your first class. *\n"+
                "- Teacher - Welcome to class every one, let's learn your first easy spell : Wingardium Leviosa.");
        Spell WingardiumLeviosa = new Spell("Wingardium Leviosa", 85, 2);
        WingardiumLeviosa.learnWingardium(wizard.getKnownSpells());
        Thread.sleep(1000);
        System.out.println("* Your now have a need to pee. So you go to the bathroom of the school next to the Dungeon... *");
        Thread.sleep(3000);
        System.out.println(" . . . ");
        Thread.sleep(1000);
        Enemy troll = Enemy.Troll();
        System.out.println("- Troll - Rooooarrrrghh !!!");
        Thread.sleep(1500);
        System.out.println("* You need to fight him ! The battle start... *");
        Thread.sleep(1500);
        wizard.attack(troll);
        if (troll.getHealth() <= 0) {
            Thread.sleep(2000);
            System.out.println("* You know have finished your first year in Hogwards. *");
            PassivLevelUp(wizard);
            Potion smallHealPotion = new Potion("Small Health Potion", 20);
            wizard.addPotion(smallHealPotion,2);
            System.out.println("* You got 2 small health potions. *");
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("* You loose the fight... GAME OVER *");
            System.exit(0);
            /*System.out.println("* Restart the fight ? (Enter 'Yes' to restart, anything else to stop) *");
            String input = sc.next();
            if (input.equalsIgnoreCase("Yes")) {
                wizard.attack(troll);
            } else {
                System.out.println("End of the Game");
            }*/ //Not using this for the mo'. I still don't know if i'm going to use this or not.
        }

    }
}