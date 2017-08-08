package com.ta;

import java.util.*;

public class TransformerBattle {
    public static void battle(String[] input) {
        List<List<Transformer>> teams = groupTeam(parseInput(input));
        List<Transformer> teamA = teams.get(0);
        List<Transformer> teamD = teams.get(1);
        int winFromTeamA = 0;
        int winFromTeamD = 0;
        int totalBattle = Math.min(teamA.size(),teamD.size());
        for (int i = 0; i < totalBattle; i ++) {
            switch (faceOff(teamA.get(i),teamD.get(i))) {
                case teamAWin:
                    winFromTeamA++;
                    break;
                case teamDWin:
                    winFromTeamD++;
                    break;
                case tie:
            }
        }
        if(winFromTeamA == winFromTeamD){
            printBattleResultTie(teamA,teamD,totalBattle);
        } else {
            if(winFromTeamA > winFromTeamD) {
                printBattleResult("Autobot","Deception", teamD, totalBattle);
            } else {
                printBattleResult("Deception","Autobot", teamA, totalBattle);
            }
        }
    }

    private static faceOffStatus faceOff(Transformer TransformerA, Transformer TransformerD) {
        faceOffStatus currentStatus = faceOffSpecialRule(TransformerA, TransformerD);
        if(currentStatus == faceOffStatus.notApply) {
            currentStatus = faceOffBasicRule(TransformerA, TransformerD);
        }
        return currentStatus;
    }

    private static faceOffStatus faceOffSpecialRule(Transformer transformerA, Transformer transformerD) {
        faceOffStatus currentStatus = faceOffStatus.notApply;
        if(isTransformerSpecial(transformerA.getName())
                && isTransformerSpecial(transformerD.getName())) {
            currentStatus = faceOffStatus.tie;
            transformerA.destroy();
            transformerD.destroy();
        } else if (isTransformerSpecial(transformerA.getName())) {
            currentStatus = faceOffStatus.teamAWin;
            transformerD.destroy();
        } else if (isTransformerSpecial(transformerD.getName())) {
            currentStatus = faceOffStatus.teamDWin;
            transformerA.destroy();
        }
        return currentStatus;
    }

    private static boolean isTransformerSpecial(String transformerName){
        if(transformerName.equalsIgnoreCase("OPTIMUS PRIME")
                || transformerName.equalsIgnoreCase("PREDAKING")) {
            return true;
        }
        return false;
    }

    private static faceOffStatus faceOffBasicRule(Transformer transformerA, Transformer transformerD) {
        faceOffStatus currentStatus = faceOffCourageStrength(transformerA, transformerD);
        if(currentStatus == faceOffStatus.notApply){
            currentStatus = faceOffSkill(transformerA, transformerD);
        }
        if(currentStatus == faceOffStatus.notApply){
            currentStatus = faceOffOverallRating(transformerA, transformerD);
        }
        return currentStatus;
    }

    private static faceOffStatus faceOffOverallRating(Transformer transformerA, Transformer transformerD) {
        faceOffStatus currentStatus = faceOffStatus.tie;
        if(transformerA.getOverallRating() - transformerD.getOverallRating() >= 3) {
            currentStatus = faceOffStatus.teamAWin;
            transformerD.destroy();
        } else if (transformerD.getOverallRating() - transformerA.getOverallRating() >= 3) {
            currentStatus = faceOffStatus.teamDWin;
            transformerA.destroy();
        }
        return currentStatus;
    }

    private static faceOffStatus faceOffSkill(Transformer transformerA, Transformer transformerD) {
        faceOffStatus currentStatus = faceOffStatus.notApply;
        if(transformerA.getSkill() - transformerD.getSkill() >= 3) {
            currentStatus = faceOffStatus.teamAWin;
            transformerD.destroy();
        } else if (transformerD.getSkill() - transformerA.getSkill() >= 3) {
            currentStatus = faceOffStatus.teamDWin;
            transformerA.destroy();
        } else {
            transformerA.destroy();
            transformerD.destroy();
        }
        return currentStatus;
    }

    private static faceOffStatus faceOffCourageStrength(Transformer transformerA, Transformer transformerD) {
        faceOffStatus currentStatus = faceOffStatus.notApply;
        if(transformerA.getCourage() - transformerD.getCourage() >= 4
                && transformerA.getStrength() - transformerD.getStrength() >= 3) {
            currentStatus = faceOffStatus.teamAWin;
            transformerD.destroy();
        } else if (transformerD.getCourage() - transformerA.getCourage() >= 4
                && transformerD.getStrength() - transformerA.getStrength() >= 3) {
            currentStatus = faceOffStatus.teamDWin;
            transformerA.destroy();
        }
        return currentStatus;
    }

    private static void printBattleResultTie(List<Transformer> teamA, List<Transformer> teamD, int totalBattle) {
        System.out.println(totalBattle + " Battle(s).");
        System.out.println("No winner, since both team tied.");
    }

    private static void printBattleResult(String winnerTeamName, String loserTeamName,
                                   List<Transformer> loserTeam, int totalBattle) {
        System.out.println(totalBattle + " Battle(s).");
        System.out.println("The winner team is " + winnerTeamName);
        System.out.println("Survivors from the losing team (" + loserTeamName + "): ");
        for(Transformer transformer : loserTeam) {
            if(!transformer.isDestroyed()) {
                System.out.println(transformer.getName());
            }
        }
    }

    private static List<List<Transformer>> groupTeam(List<Transformer> input) {
        List<List<Transformer>> teams = new ArrayList<List<Transformer>>();
        List<Transformer> teamA = new ArrayList<Transformer>();
        List<Transformer> teamD = new ArrayList<Transformer>();
        for(Transformer transformer: input) {
            if(transformer.getTeam().equalsIgnoreCase("A")){
                teamA.add(transformer);
            } else {
                teamD.add(transformer);
            }
        }
        if(teamA.size() == 0 || teamD.size() == 0) {
            throw new RuntimeException("Each team need to have at least one Transformer to battle.");
        }
        sortTransformerByRank(teamA);
        sortTransformerByRank(teamD);
        teams.add(0,teamA);
        teams.add(1,teamD);
        return teams;
    }

    private static void sortTransformerByRank(List<Transformer> team) {
        Collections.sort(team, new Comparator<Transformer>() {
            @Override public int compare(Transformer transformer1, Transformer transformer2) {
                return transformer1.getRank() > transformer2.getRank() ? -1 :(transformer1.getRank() < transformer2.getRank() ? 1 : 0);
            }
        });
    }

    private static List<Transformer> parseInput(String[] input) {
        List<Transformer> totalTransformer = new ArrayList<Transformer>();
        if(input == null || input.length < 2){
            throw new RuntimeException("There is not enough Transfomer to battle.");
        } else {
            for(String line : input) {
                if(line == null){
                    throw new RuntimeException("Invalid Transfomer information.");
                }
                String[] words = line.split(",");
                if(words.length != 10) {
                    throw new RuntimeException("Invalid Transfomer information." +
                            "Valid Transfomer information should look like Soundwave,D,8,9,2,6,7,5,6,10");
                }
                Transformer transformer = new Transformer(getName(words[0]),
                                                        getTeam(words[1]),getSpec(words));
                totalTransformer.add(transformer);
            }
        }
        return totalTransformer;
    }

    private static String getName(String input){
        if(input == null || !input.matches("[a-zA-Z\\s]+")){
            throw new RuntimeException("Transfomer name can only contain letter or space.");
        }
        return input;
    }

    private static String getTeam(String input){
        if(input == null || (!input.equalsIgnoreCase("D")  && !input.equalsIgnoreCase("A"))){
            throw new RuntimeException("Each Transformer must either be an Autobot or a Deception.");
        }
        return input;
    }

    private static int[] getSpec(String[] input) {
        int [] spec = new int[input.length-2];
        for(int i = 0 ; i < spec.length; i++){
            spec[i] = Integer.parseInt(input[i+2]);
            if(spec[i] > 10 || spec[i] < 1){
                throw new RuntimeException("All of these spec criteria are ranked from 1 to 10.");
            }
        }
        return spec;
    }
}
