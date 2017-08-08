package com.ta;

public class TransformerDemo {
    public static void main(String args[]){
        try {
            String[] input1 = {
                    "Soundwave,D,8,9,2,6,7,5,6,10",
                    "Bluestreak,A,6,6,7,9,5,2,9,7",
                    "Hubcap,A,4,4,4,4,4,4,4,4",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Soundwave,D,8,9,2,6,7,5,6,10",
                    "Optimus Prime,A,6,6,7,9,5,2,9,7",
                    "Hubcap,A,4,4,4,4,4,4,4,4",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Soundwave,D,8,9,2,6,7,5,6,10",
                    "Soundwave,A,8,9,2,6,7,5,6,10",
                    "Optimus Prime,A,6,6,7,9,5,2,9,7",
                    "Soundwave,D,8,9,2,6,7,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Soundwave,D,8,9,2,6,7,5,6,10",
                    "Soundwave,A,8,9,2,6,7,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Soundwave,D,8,9,2,6,7,5,6,10",
                    "Soundwave,D,8,9,2,6,7,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Soundwave1,D,8,9,2,6,7,5,6,10",
                    "Soundwave2,A,8,9,2,6,7,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Bumblebee,A,10,10,10,10,1,10,10,10",
                    "Cliffjumper,A,10,10,10,10,2,10,10,10",
                    "Wheeljack,A,1,1,1,1,3,1,1,1",
                    "Starscream,D,8,9,2,6,1,5,6,10",
                    "Reflector,D,8,9,2,6,2,5,6,10",
                    "Megatron,D,8,9,2,6,3,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }

        try {
            String[] input1 = {
                    "Bumblebee,A,100000000,10,10,10,1,10,10,10",
                    "Cliffjumper,A,10,10,10,10,2,10,10,10",
                    "Wheeljack,A,1,1,1,1,3,1,1,1",
                    "Starscream,D,8,9,2,6,1,5,6,10",
                    "Reflector,D,8,9,2,6,2,5,6,10",
                    "Megatron,D,8,9,2,6,3,5,6,10",
            };
            TransformerBattle.battle(input1);
        } catch (Exception e) {
            System.out.println("Battle terminated Unexpectedly");
            System.out.println(e.getMessage());
        } finally {
            //split between battles
            System.out.println();
        }
    }
}
