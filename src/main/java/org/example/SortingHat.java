package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class SortingHat {

    private House house;

    public House getHouse() {
        Random randomNum = new Random();
        return House.values()[randomNum.nextInt(House.values().length)];
    }

}
