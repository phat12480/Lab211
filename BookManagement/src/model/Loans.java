/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Loans {

    private String transactionID;
    private String bookID;
    private String userID;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isActiveLoans;
    //

    public Loans(String transactionID, String userID, String bookID, LocalDate borrowDate, LocalDate returnDate, boolean isActiveLoans) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.bookID = bookID;
        this.isActiveLoans=isActiveLoans;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

//
    public Loans() {
    }
    //

    public boolean isIsActiveLoans() {
        return isActiveLoans;
    }

    public void setIsActiveLoans(boolean isActiveLoans) {
        this.isActiveLoans = isActiveLoans;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    //
    @Override
    public String toString() {
        return String.format("| %-20s | %-23s | %-15s | %-17s | %-20s | %-20s |",
                transactionID,
                userID,
                bookID,
                borrowDate,
                returnDate,isActiveLoans);
    }

}
