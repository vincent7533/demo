package com.ta;

public class CastleDemo {

    public static void main(String args[]){
        Castle castle = new Castle();
        int[] input1 = {1,2,3,2};
        int counter = castle.castleCounter(input1);
        System.out.println("Input Array {1,2,3,2}");
        System.out.println("Total number of castles to build " + counter);

        int[] input2 = {1,2};
        counter = castle.castleCounter(input2);
        System.out.println("Input Array {1,2}");
        System.out.println("Total number of castles to build " + counter);

        int[] input3 = {1};
        counter = castle.castleCounter(input3);
        System.out.println("Input Array {1}");
        System.out.println("Total number of castles to build " + counter);

        int[] input4 = {};
        counter = castle.castleCounter(input4);
        System.out.println("Input Array {}");
        System.out.println("Total number of castles to build " + counter);

        int[] input5 = {1,2,6,6,6,6,6,6,6,4,8};
        counter = castle.castleCounter(input5);
        System.out.println("Input Array {1,2,6,6,6,6,6,6,6,4,8}");
        System.out.println("Total number of castles to build " + counter);
    }
}
