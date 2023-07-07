package com.example.tcc_managment.controllers;
import java.util.Random;

public class GeneradorCodigoBarras {
    public static String generarCodigoBarras(int codeLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Caracteres permitidos

        Random random = new Random();

        // Utilizar mejor StringBuilder que String
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        String randomCode = codeBuilder.toString();
        return randomCode;
    }
}
