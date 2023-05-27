package com.example.pruebasdexml;

import java.io.File;
import java.text.SimpleDateFormat;

public class LectorCarpetas {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        //Carpeta del usuario
        String sCarpAct = "C:\\Users\\Gabriel\\IdeaProjects\\PruebasdeXML\\src\\main\\java\\com\\example\\Carpeta de Prueba";
        System.out.println("Carpeta del usuario = " + sCarpAct);

        System.out.println(ANSI_RED + "//// LISTADO SIMPLE" + ANSI_RESET);
        File carpeta = new File(sCarpAct);
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                ReadXMLFileExample1 LEC = new ReadXMLFileExample1();
                LEC.lector(archivo);
                System.out.println(String.format("%s (%s) - %d - %s",
                        archivo.getName(),
                        archivo.isDirectory() ? "Carpeta" : "Archivo",
                        archivo.length(),
                        sdf.format(archivo.lastModified())
                ));
            }
        }
    }
}