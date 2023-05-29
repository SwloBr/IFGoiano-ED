package com.swlo;

public class Patient {


    private final int ID;
    private final String name, gender;
    private int age, tier;
    private boolean pregnant, lactating, disabled;

    public Patient(int ID, String name, String gender, int age) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tier = (age > 60) ? 1 : 0;
    }

    public Patient(int ID, String name, String gender, int age, boolean pregnant, boolean lactating, boolean disabled) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.pregnant = pregnant;
        this.lactating = lactating;
        this.disabled = disabled;

        this.tier = (pregnant || lactating) ? 3 : ((disabled) ? 2 : ((age > 60) ? 1 : 0));
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        if (this.tier > 1) {
            return;
        }
        this.tier = 1;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
        this.tier = 3;
    }

    public boolean isLactating() {
        return lactating;
    }

    public void setLactating(boolean lactating) {
        this.lactating = lactating;
        this.tier = 3;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        if (this.tier == 3) {
            return;
        }
        this.tier = 2;
    }
}

