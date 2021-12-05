package com.example.project3;

public class Pokemon {
    private String name;
    private String icon;
    private int[] stats;
    private String description;
    private String type;
    private int dexNumber;

    public Pokemon(String name, int[] stats, String icon, String description, String type, int dexNumber) {
        this.name = name;
        this.stats = stats;
        this.icon = icon;
        this.description = description;
        this.type = type;
        this.dexNumber = dexNumber;
    }

    public String getIcon() {
        return this.icon;
    }

    public int[] getStats() {
        return this.stats;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }

    public int getDexNumber() {
        return this.dexNumber;
    }

}
