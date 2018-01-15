/********************************************************************************
 * Copyright (c) 2018 Ryan Wibawa. All rights reserved.                         *
 *                                                                              *
 * The copyright to the computer software herein is the property of Ryan Wibawa.*
 * The software may be used and/or copied only with the written permission of   *
 * Ryan Wibawa or in accordance with the terms and conditions stipulated in the *
 * agreement/contract under which the software has been supplied.               *
 ********************************************************************************/

import java.util.Stack;

public class Elevator {

    public static void main(String[] args) {
        Elevator elevator = new Elevator(1, 3);
        elevator.buttonGoToFloor(2);
        elevator.buttonClose();

        elevator.buttonCall(3);

        elevator.buttonGoToFloor(1);
        elevator.buttonClose();
    }

    private enum moveDirection {
        UP, STOP, DOWN, HOLD
    }

    private Stack<Integer> queue = new Stack<>();

    public Elevator(int minFloor, int maxFloor)
    {
        min = minFloor;
        max = maxFloor;

        currentFloor = min;
        System.out.println("currentFloor: " + currentFloor);

        state = moveDirection.STOP;
    }

    private int min;
    private int max;
    private int currentFloor;
    private moveDirection state;

    public void moveToFloor(int destinationFloor)
    {
        System.out.println("moveToFloor(" + destinationFloor + ")");

        if (state == moveDirection.HOLD)
        {
            queue.push(destinationFloor);
            return;
        }

        // Move up
        if (destinationFloor > currentFloor)
        {
            state = moveDirection.UP;
            System.out.println("state: " + state);

            currentFloor = destinationFloor;
            System.out.println("currentFloor: " + currentFloor);

            state = moveDirection.STOP;
            System.out.println("state: " + state);

            return;
        }

        // Move down
        if (destinationFloor < currentFloor)
        {
            state = moveDirection.DOWN;
            System.out.println("state: " + state);

            currentFloor = destinationFloor;
            System.out.println("currentFloor: " + currentFloor);

            state = moveDirection.STOP;
            System.out.println("state: " + state);
        }
    }

    public void buttonGoToFloor(int destinationFloor)
    {
        System.out.println("buttonGoToFloor(" + destinationFloor + ")");
        moveToFloor(destinationFloor);
    }

    public void buttonCall(int floorIndex)
    {
        System.out.println("buttonCall(" + floorIndex + ")");
        moveToFloor(floorIndex);
        state = moveDirection.HOLD;
        System.out.println("state: " + state);
    }

    public void buttonClose()
    {
        System.out.println("buttonClose()");
        state = moveDirection.STOP;
        System.out.println("state: " + state);
        if (queue.size() > 0)
        {
            int destinationFloor = queue.pop();
            moveToFloor(destinationFloor);
        }
    }
}
