/********************************************************************************
 * Copyright (c) 2018 Ryan Wibawa. All rights reserved.                         *
 *                                                                              *
 * The copyright to the computer software herein is the property of Ryan Wibawa.*
 * The software may be used and/or copied only with the written permission of   *
 * Ryan Wibawa or in accordance with the terms and conditions stipulated in the *
 * agreement/contract under which the software has been supplied.               *
 ********************************************************************************/

import java.util.Stack;

public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower tower1 = new HanoiTower(1);
        HanoiTower tower2 = new HanoiTower(2);
        HanoiTower tower3 = new HanoiTower(3);

        int n = 2;
        for (int i = n; i > 0; i--) {
            tower1.add(i);
        }

        tower1.moveDisks(n, tower3, tower2);
    }

    private int index;
    public Stack<Integer> stack;

    public HanoiTower(int index)
    {
        this.index = index;
        stack = new Stack<>();
    }


    public void add(int diskIndex)
    {
        if (stack.size() != 0 && stack.peek() <= diskIndex)
        {
            System.out.println("Error add disk["+diskIndex+"] to tower["+index+"]!");
        }
        else
        {
//            System.out.println("add disk["+diskIndex+"] to tower["+index+"]");
            stack.push(diskIndex);
        }
    }

    public void moveDisks(int numberOfDisks, HanoiTower destination, HanoiTower buffer)
    {
        if (numberOfDisks > 0)
        {
            moveDisks(numberOfDisks - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(numberOfDisks - 1, destination, this);
        }
    }

    private void moveTopTo(HanoiTower destination)
    {
        int diskIndex = stack.pop();
        System.out.println("Move disk["+diskIndex+"] from Tower["+this.index+"] to Tower["+destination.index+"]");
        destination.add(diskIndex);
    }
}
