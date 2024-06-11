/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class User {

    private String userID;
    private String name;
    private LocalDate dateBirth;
    private String phoneNumber;
    private String email;
    private boolean activeUser;
    //

    public User(String userID, String name, LocalDate dateBirth, String phoneNumber, String email, boolean activeUser) {
        this.userID = userID;
        this.name = name;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activeUser = activeUser;
    }

    public User() {
    }
    //

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }
    //

    @Override
    public String toString() {
        return String.format("| %-20s | %-23s | %-15s | %-17s | %-20s | %-20s |",
            userID,
            name,
            dateBirth,
            phoneNumber,
            email,
            activeUser);
    }

}
