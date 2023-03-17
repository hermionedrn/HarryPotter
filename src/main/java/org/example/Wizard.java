package org.example;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    private String name; //nom du sorcier

    public Wizard(String name, int level, String spell) {
        this.name = name;
    }
    public Wizard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void defend() {

    }
    @Override
    public void attack(Character character) {
        // code to attack
    }


}

