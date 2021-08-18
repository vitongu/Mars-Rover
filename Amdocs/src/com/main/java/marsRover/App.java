package com.main.java.marsRover;

import com.main.java.marsRover.controler.RoverControler;
import com.main.java.utils.RoverUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {

    public static void main(String args[]) throws IOException {
        runApp();
    }

    private static void runApp() throws IOException {

        //File Path
        String filePath = "File path here";
        ArrayList <String> roverMovements= readFile(filePath);

        RoverControler rover = new RoverControler();

        int count = RoverUtils.NUMBER_1;

        for (int i = 2 ; i < roverMovements.size(); i = i+2 ){
            //Verify data of file
            if(!Pattern.matches(RoverUtils.REGEX_AXIS,roverMovements.get(i)))
                throw new IllegalArgumentException("Check input file data");

            if(!Pattern.matches(RoverUtils.REGEX_MOVEMENT,roverMovements.get(i + RoverUtils.NUMBER_1)))
                throw new IllegalArgumentException("Check input file data");

            //Set rover position
            String[] roverAxis = roverMovements.get(i).split("\\s+");
            rover.setPosition(Integer.parseInt(roverAxis[0]), Integer.parseInt(roverAxis[1]), roverAxis[2].charAt(0));
            //Start rover movements
            rover.process(roverMovements.get(i + RoverUtils.NUMBER_1));
            //Print Result
            rover.printPosition(count++);
        }
    }

    public static ArrayList<String> readFile(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        ArrayList <String> roverMovements = new ArrayList<>();
        while (true) {
            if (line != null) {
                roverMovements.add(line);
            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
        return roverMovements;
    }
}