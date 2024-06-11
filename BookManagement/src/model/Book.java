/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Book {
    private String bookID;
    private String bookTitle;
    private String author;
    private LocalDate publicationYear;
    private String publisher;
    private String ISBN;
    private boolean activeBook;
    private int year;
    //

    public Book(String bookID, String bookTitle, String author, LocalDate publicationYear, String publisher, String ISBN, boolean activeBook) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.activeBook = activeBook;
    }

    public Book(String bookID, String bookTitle, String author, String publisher, String ISBN, boolean activeBook, int year) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.activeBook = activeBook;
        this.year = year;
    }

  

    public Book() {
    }
    //

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

  

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isActiveBook() {
        return activeBook;
    }

    public void setActiveBook(boolean activeBook) {
        this.activeBook = activeBook;
    }
    //

    @Override
    public String toString() {
        return String.format("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-15s |", bookID, bookTitle, author, publicationYear.getYear(), publisher, ISBN, activeBook);
    }
    
    
    
    
    
}
