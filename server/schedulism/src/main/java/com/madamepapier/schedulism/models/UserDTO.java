package com.madamepapier.schedulism.models;

public class UserDTO {
    private String name;

    private String email;

    private String occupation;

    public UserDTO(String name, String email, String occupation) {
        this.name = name;
        this.email = email;
        this.occupation = occupation;
    }

    public UserDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
