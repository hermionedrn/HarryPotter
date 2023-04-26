package HPCode.composants.Spells;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AbstractSpell {
    private String name;
    private int succesChance;
    private int spellDamage;
}



