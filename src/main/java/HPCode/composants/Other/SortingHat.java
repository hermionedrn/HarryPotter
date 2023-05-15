package HPCode.composants.Other;

import HPCode.composants.Characters.Wizard;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SortingHat {
    public void assignHouse(Wizard wizard) {
        // Generate a random number between 0 and 4
        int randomNum = (int) (Math.random() * 5);
        // Assign a house based on the random number
        if (randomNum == 0) {
            wizard.setPotionBonus(wizard.getPotionBonus() + 5);
            wizard.setHouse(House.POUFSOUFFLE);
        } else if (randomNum == 1) {
            wizard.setDefence(wizard.getDefence() + 0.1f);
            wizard.setHouse(House.GRYFFONDOR);
        } else if (randomNum == 2) {
            wizard.setAccuracy(wizard.getAccuracy() + 3);
            wizard.setHouse(House.SERDAIGLE);
        } else {
            wizard.setDamage(wizard.getDamage() + 5);
            wizard.setHouse(House.SERPENTARD);
        }
    }
}