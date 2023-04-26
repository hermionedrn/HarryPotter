package HPCode.composants.Characters;

import lombok.*;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Character {
    private int maxHealth; //Total health by character. Used to reset the health of characters after each battle.
    private int health; //Variable health used in the battle.
    private float defence;
    private int damage;
    private int accuracy;

    @Setter
    private String name;

    public int damageCalc(Character target) {
        int accuracyBonusDamage = 0;
        if (this.accuracy > 0) {
            accuracyBonusDamage = new Random().nextInt(this.accuracy);
        }
        int damage = Math.round( (this.damage + accuracyBonusDamage) - ( (this.damage + accuracyBonusDamage) * target.getDefence()));
        return damage;
    }
}