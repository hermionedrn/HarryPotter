package HPCode.composants.WandStuff;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wand {

    private Core core;
    private int size;

    //Get a random core in the total list
    public Core getCore() {
        Random randomNum = new Random();
        return Core.values()[randomNum.nextInt(Core.values().length)];
    }

    //Get a random size between 10 and 25
    public int getWandSize() {
        Random randomNum = new Random();
        return randomNum.nextInt(16) + 10;
    }
}
