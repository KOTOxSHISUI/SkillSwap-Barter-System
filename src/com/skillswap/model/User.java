package com.skillswap.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String skillOffered;
    private String skillNeeded;
    private String password;
    private String availability;
    private String exchangeMethod;

    public User(int id, String name, String email, String skillOffered, String skillNeeded, String password, String availability, String exchangeMethod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skillOffered = skillOffered;
        this.skillNeeded = skillNeeded;
        this.password = password;
        this.availability = availability;
        this.exchangeMethod = exchangeMethod;
    }

    // Getters and Setters for all fields

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSkillOffered() { return skillOffered; }
    public void setSkillOffered(String skillOffered) { this.skillOffered = skillOffered; }

    public String getSkillNeeded() { return skillNeeded; }
    public void setSkillNeeded(String skillNeeded) { this.skillNeeded = skillNeeded; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getExchangeMethod() { return exchangeMethod; }
    public void setExchangeMethod(String exchangeMethod) { this.exchangeMethod = exchangeMethod; }
}
