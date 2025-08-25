/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;

import java.sql.Date;

/**
 *
 * @author Rufah
 */
  // Donation.java
public class Donations {
    private Donor donor;
    private DonationCategory category;
    private double amount;
    private Date date;
    private String notes;

    public Donations(Donor donor, DonationCategory category, double amount, Date date, String notes) {
        this.donor = donor;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.notes = notes;
    }

    public Donor getDonor() {
        return donor;
    }

    public DonationCategory getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
