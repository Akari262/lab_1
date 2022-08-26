package com.company;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Main {
    public static int[][] dataArray = new int[5][5];

    //функція, яка отримує дані з файлу і виводить їх на екран
    public static void arrData() throws IOException {

        String file = "data.csv";
        BufferedReader reader = null;
        String line = "";
        reader = new BufferedReader(new FileReader(file));
        int x = 0;
        while((line = reader.readLine()) != null && x < 5){
            String [] row = line.split(";");
            dataArray[x][0] = Integer.parseInt(row[0]);
            dataArray[x][1] = Integer.parseInt(row[1]);
            dataArray[x][2] = Integer.parseInt(row[2]);
            dataArray[x][3] = Integer.parseInt(row[3]);
            dataArray[x][4] = Integer.parseInt(row[4]);
            x++;
        }

        //Вивід матриці
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                System.out.print(dataArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }

    //функція перевіряє матрицю на рефлекторність(матриця є рефлекторна, якщо всі елементи головної діагоналі дорівнюють одиниці)
    public static String refleksyvne(){
        boolean ref = true;
        for(int i = 0; i < 5; i++){
            if(dataArray[i][i] == 0){
                ref = false;
            }
        }
        if (ref)
            return "Yes";
        else
            return "No";
    }

    //функція перевіряє матрицю на антирефлекторність(матриця є антирефлекторна, якщо всі елементи головної діагоналі дорівнюють нулю)
    public static String antyrefleksyvne(){
        boolean ref = true;
        for(int i = 0; i < 5; i++){
            if(dataArray[i][i] == 1){
                ref = false;
            }
        }
        if (ref)
            return "Yes";
        else
            return "No";
    }

    //функція перевіряє матрицю на симетричність(матриця є симетричною, якщо всі елементи симетричні відносно головної діагоналі)
    public static String symmetrix(){
        boolean ref = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                if(dataArray[i][j] != dataArray[j][i]){
                    ref = false;
                }
            }
        }

        if (ref)
            return "Yes";
        else
            return "No";
    }

    //функція перевіряє матрицю на антисиметричність(матриця є антисиметричною, якщо всі елементи не є симетричні відносно головної діагоналі)
    public static String antisymmetrix(){
        boolean ref = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                if(dataArray[i][j] == dataArray[j][i]){
                    ref = false;
                }
            }
        }

        if (ref)
            return "Yes";
        else
            return "No";
    }

    //функція перевіряє матрицю на асиметричність(матриця є асиметричною, якщо всі елементи головної діагоналі дорівнюють нулю, а також M != M(T))
    public static String asymmetrix(){
        boolean ref = false;

        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                if(dataArray[i][j] != dataArray[j][i]){
                    ref = true;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            if(dataArray[i][i] == 1){
                ref = false;
            }
        }

        if (ref)
            return "Yes";
        else
            return "No";
    }

    public static void printResult() throws IOException {
        File file = new File("result.csv");

        try (PrintWriter out = new PrintWriter("result.csv")){
            out.write("Reflexivity:" + ";" + refleksyvne() + "\n");
            out.write("Anti-reflexivity:" + ";" + antyrefleksyvne() + "\n");
            out.write("Symmetry:" + ";" + symmetrix() + "\n");
            out.write("Anti-symmetry:" + ";" + antisymmetrix() + "\n");

        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        }
    }


    public static void main(String[] args) throws IOException {
        arrData();
        System.out.println("Reflexivity: " + refleksyvne());
        System.out.println("Anti-reflexivity: " + antyrefleksyvne());
        System.out.println("Symmetry: " + symmetrix());
        System.out.println("Anti-symmetry: " + antisymmetrix());
        System.out.println("Asymmetry: " + asymmetrix());
        printResult();
    }
}
