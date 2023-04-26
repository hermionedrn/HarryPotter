package HPCode.composants.Characters;

public class Enemy extends AbstractEnemy {
    private Enemy(int maxHealth, int health, float defence, int damage, int accuracy, String name) {
        super(maxHealth, health, defence, damage, accuracy, name);
    }
    public static Enemy Troll() {
        return new Enemy(14,0, 0.0f, 2, 2, "Troll");
    }
    public static Enemy Basilic() {
        return new Enemy(25,0, 0.2f, 5, 3,  "Basilic");
    }
    public static Enemy Dementor() {
        return new Enemy(45,0, 0.0f, 20, 0,  "Dementor");
    }
    public static Enemy Mangemort() {
        return new Enemy(40,0, 0.4f, 15, 10,  "Mangemort");
    }
    public static Enemy BelatrixLestrange() {
        return new Enemy(80,0, 0.35f, 25, 10,  "Belatrix Lestrange");
    }
    public static Enemy Voldemort() {
        return new Enemy(150,0, 0.5f, 30, 20,  "Voldemort");
    }
    public static Enemy DoloresOmbrage() {
        return new Enemy(500,0, 0.95f, 5, 5,  "Dolores Ombrage");
    }

}