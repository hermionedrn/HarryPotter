package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le prénom du sorcier : ");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);
        System.out.println(wizard.getName());

    }
}