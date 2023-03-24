package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        System.out.println("Bienvenue dans Harry Potter at Home, le RPG des sorciers.\n" +
                "Avez-vous l’étoffe des plus grands sorciers ? Saurez-vous relever tous les défis ? \n" +
                "Votre objectif est de valider votre scolarité à Poudlard. Chaque année sera parsemée d’embuches.");
        System.out.println("");
        System.out.println("Bon courage ! ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("Entre ton nom de sorcier : ");
        String wizardName = scanner.nextLine();
        Wand wand = new Wand();
        Wizard wizard = new Wizard(wizardName, wand);
        wizard.equipWand(wand);
        System.out.println("La baguette de " + wizard.getName() + " a un coeur en " + wizard.getWand().getCore() + " et est en bois de " + wizard.getWand().getWandSize() + ".");

    }
}