package com.ta;

public class Transformer {
    private String name;
    private String team;
    private int strength;
    private int intelligence;
    private int speed;
    private int endurance;
    private int rank;
    private int courage;
    private int firepower;
    private int skill;
    private boolean destroyed;

    public Transformer(String inputName, String inputTeam, int[] inputSpec) {
        name = inputName;
        team = inputTeam.toUpperCase();
        strength = inputSpec[0];
        intelligence = inputSpec[1];
        speed = inputSpec[2];
        endurance = inputSpec[3];
        rank = inputSpec[4];
        courage = inputSpec[5];
        firepower = inputSpec[6];
        skill = inputSpec[7];
        destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }

    public int getCourage() {
        return courage;
    }

    public int getStrength() {
        return strength;
    }

    public int getSkill() {
        return skill;
    }

    public int getRank() {
        return rank;
    }

    public int getOverallRating() {
        return strength + intelligence + speed + endurance + firepower;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
