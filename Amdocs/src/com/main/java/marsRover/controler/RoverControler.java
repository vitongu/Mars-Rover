package com.main.java.marsRover.controler;

import com.main.java.marsRover.model.Rover;
import com.main.java.utils.RoverUtils;

public class RoverControler {

    Rover rover = new Rover();

    public RoverControler(){}

    public void setPosition(Integer xAxis, Integer yAxis, Character facing) {
        rover.setXAxis(xAxis);
        rover.setYAxis(yAxis);
        rover.setFacing(facing);
    }

    public void process(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            process(commands.charAt(i));
        }
    }

    private void process(Character command) {
        if (command.equals(RoverUtils.RIGHT)) {
            turnRight();
        } else if (command.equals(RoverUtils.LEFT)) {
            turnLeft();
        } else if (command.equals(RoverUtils.MOVE)) {
            move();
        } else {
            throw new IllegalArgumentException("Rove Command it is wrong : " + command);
        }
    }

    private void move() {
        if (rover.getFacing() == RoverUtils.NORTH) {
            rover.setYAxis(rover.getYAxis() + RoverUtils.NUMBER_1);
        } else if (rover.getFacing() == RoverUtils.EAST) {
            rover.setXAxis(rover.getXAxis() + RoverUtils.NUMBER_1);
        } else if (rover.getFacing() == RoverUtils.SOUTH) {
            rover.setYAxis(rover.getYAxis() - RoverUtils.NUMBER_1);
        } else if (rover.getFacing() == RoverUtils.WEST) {
            rover.setXAxis(rover.getXAxis() - RoverUtils.NUMBER_1);
        }
    }

    private void turnRight() {
        switch (rover.getFacing()) {
            case 'N':
                rover.setFacing(RoverUtils.EAST);
                break;
            case 'E':
                rover.setFacing(RoverUtils.SOUTH);
                break;
            case 'S':
                rover.setFacing(RoverUtils.WEST);
                break;
            case 'W':
                rover.setFacing(RoverUtils.NORTH);
                break;
        }
    }

    private void turnLeft() {
        switch (rover.getFacing()) {
            case 'N':
                rover.setFacing(RoverUtils.WEST);
                break;
            case 'W':
                rover.setFacing(RoverUtils.SOUTH);
                break;
            case 'S':
                rover.setFacing(RoverUtils.EAST);
                break;
            case 'E':
                rover.setFacing(RoverUtils.NORTH);
                break;
        }
    }

    public void printPosition(Integer count) {
        System.out.println("Rover number " + count + " result ==> "
                           + rover.getXAxis() + " " + rover.getYAxis() + " " + rover.getFacing());
    }
}
