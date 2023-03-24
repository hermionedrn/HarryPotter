package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Wand {
    private Core core;
    private int size;
    private String name;
    private String wood;


    public String getName() {
        return name;
    }

    public Core getCore() {
        Random randomNum = new Random();
        return Core.values()[randomNum.nextInt(Core.values().length)];
    }

    public int getWandSize() {
        Random randomNum = new Random();
        return randomNum.nextInt(16) + 10;
    }
}

