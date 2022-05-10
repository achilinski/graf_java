package com.company;

import java.io.*;
import java.util.ArrayList;


public class Reader {
    String path;
    ArrayList<Double[]> points = new ArrayList<>();
    int i=0;

    public Reader(String pathToFile){
        path = pathToFile;
    }
    public BufferedReader getBuffer() throws FileNotFoundException {
        File file = new File(path);
        return new BufferedReader(new FileReader(file));
    }
    public int getX() throws IOException {
        BufferedReader br = getBuffer();
        String st=br.readLine();
        String[] sl = st.split(" ");
        return Integer.parseInt(sl[0]);
    }
    public int getY() throws IOException {
        BufferedReader br = getBuffer();
        String st=br.readLine();
        String[] sl = st.split(" ");
        return Integer.parseInt(sl[1]);
    }


    public static Double[] strToDoubleArr(String[] arr){
        Double[] newArr = new Double[arr.length];
        for(int i=0; i<arr.length; i++){
            newArr[i] = Double.parseDouble(arr[i]);
        }
        return newArr;

    }
    public static String[] removeTheElement(String[] arr, int index)
    {

        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        String[] anotherArray = new String[arr.length - 1];


        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }


    public void read() throws Exception {
        BufferedReader br = getBuffer();
        String st;

        while ((st = br.readLine()) != null) {
            String[] syf;
            st = st.trim().replaceAll("/[\\f\\t\\n\\v\\r]*/g", "");
            st = st.trim().replaceAll(":", "");
            syf = st.split(" ");
            for(int j=0; j<syf.length-1; j++){
                if(syf[j].isEmpty() || syf[j].isBlank()){
                    syf = removeTheElement(syf,j);
                }
            }
            points.add(strToDoubleArr(syf));
            i = i+1;

        }


    }
    public Double[][] getPoints() throws Exception {
        read();
        Double[][] lista = new Double[points.size()][];
        for(int i = 0; i< points.size(); i++){
            lista[i] = points.get(i);
        }
        return lista;
    }
}

