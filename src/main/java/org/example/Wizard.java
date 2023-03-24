package org.example;
import lombok.*;
import org.example.Potion;
import org.example.Spell;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;


    private String name; //nom du sorcier

    public Wizard(String name, Wand wand, House house) {
        this.name = name;
        this.wand = new Wand();
        this.house = house;

    }

    public void equipWand(Wand wand) {
        this.wand = wand;
    }
    public void equipHouse(House house) {
        this.house = house;
    }

    public void defend() {}

    @Override
    public void attack(Character character) {
        // code to attack
    }


}

