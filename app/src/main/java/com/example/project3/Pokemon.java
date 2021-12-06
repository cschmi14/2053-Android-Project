package com.example.project3;

public class Pokemon {
    private String name;
    private String icon;
    private int[] stats;
    private String typeA;
    private String typeB;
    private int dexNumber;

    public Pokemon() {

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


    public String getTypeA() {
        return this.typeA;
    }
    public void setTypeA(String type)
    {
        this.typeA = type;
    }

    public String getTypeB() {
        return this.typeB;
    }
    public void setTypeB(String type)
    {
        this.typeB = type;
    }

    public int getDexNumber() {
        return this.dexNumber;
    }
    public void setDexNumber(int dexNumber)
    {
        this.dexNumber = dexNumber;
    }
}
