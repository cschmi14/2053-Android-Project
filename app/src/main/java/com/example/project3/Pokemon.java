package com.example.project3;

public class Pokemon {
    private String name;
    private String icon;
    private int[] stats;
    private String type;
    private int dexNumber;

    public Pokemon(String name, int[] stats, String icon, String type, int dexNumber) {
        this.name = name;
        this.stats = stats;
        this.icon = icon;
        this.type = type;
        this.dexNumber = dexNumber;
    }

    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int[] getStats() {
        return this.stats;
    }
    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name)
    {
    this.name = name;}

    public String getType() {
        return this.type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public int getDexNumber() {
        return this.dexNumber;
    }

    public void setDexNumber(int dexNumber)
    {
        this.dexNumber = dexNumber;
    }
}
