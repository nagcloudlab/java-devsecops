package com.example;

// IS-A relationship
public class TechEmployee extends Employee {

    private String techSkill;

    public TechEmployee(long id, String name, String department, String techSkill) {
        super(id, name, department);
        this.techSkill = techSkill;
    }

    public String getTechSkill() {
        return techSkill;
    }

    public void setTechSkill(String techSkill) {
        this.techSkill = techSkill;
    }

}
