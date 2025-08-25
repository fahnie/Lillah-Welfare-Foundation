/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;

/**
 *
 * @author Rufah
 */
public class Donor extends User {
    String org;
    String don_freq;

    public Donor(String name, String contact, String username, String password,String email,String org,String don) {
        super(name, contact, username, password, "Donor",email);
        this.org=org;
        this.don_freq=don;
    }

    Donor() {
    }

   

    String getOrganization() {
       return org;
    }

    String getDonationFrequency() {
        return don_freq;
    }
}