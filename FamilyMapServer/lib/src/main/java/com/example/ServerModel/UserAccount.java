package com.example.ServerModel;

/**
 * UserAccount is used to represent all of the registered users in the family map program.
 */
public class UserAccount {
    /** A unique username given to each user */
    private String userName;

    /** The password to login to the account */
    private String password;

    /** First name of the user */
    private String firstName;

    /** last name of the user */
    private String lastName;

    /** User's email address */
    private String email;

    /** User's gender */
    private String gender;

    /** The ID for the users associated Person object */
    private String personID;

    /**
     * Creates a new instance of the UserAccount class.
     * @param username desired username.
     * @param password the new user's password
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email user's email address
     * @param gender user's gender
     */
    public UserAccount(String username, String password, String firstName, String lastName, String email, String gender){
        this.userName = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        personID = null;
    }

    @Override
    public int hashCode(){
        return userName.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if (o instanceof  UserAccount){
            UserAccount obj = (UserAccount) o;
            if(obj.getUsername().equals(this.userName)){
                return true;
            }
        }

        return false;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() { return email; }

    public String getGender() {
        return gender;
    }

    public String getPersonid() {
        return personID;
    }

    public void setPersonid(String personid) { this.personID = personid; }
}
