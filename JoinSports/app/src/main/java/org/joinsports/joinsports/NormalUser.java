package org.joinsports.joinsports;

/**
 * Created by Timo on 23.11.2016.
 */

public class NormalUser {
    // Attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;

    // Constructor
    NormalUser() {

    }

    // Functions


    // Get- & Set - Methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
