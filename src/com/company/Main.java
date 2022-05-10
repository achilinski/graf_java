package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = "/Users/a./Desktop/pr_jav/mygraph";
        Reader reader = new Reader(filePath);
        int x = reader.getX();
        int y = reader.getY();
        Double[][] lista;
        lista=reader.getPoints();
        System.out.println(x);
        System.out.println(y);
        System.out.println(Arrays.deepToString(lista));


    }
}
