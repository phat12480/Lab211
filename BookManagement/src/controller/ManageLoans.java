/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import input.Input;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import model.Book;
import model.Loans;

/**
 *
 * @author ADMIN
 */
public class ManageLoans extends Loans {

    HashMap<String, Loans> mapLoans = new HashMap<>();
    Input input = new Input();
    Loans loans = new Loans();
    ManageUsers manageUser;
    ManageBooks manageBook;
    int count = 10;

    public ManageLoans(ManageUsers user, ManageBooks book) {
        this.manageUser = user;
        this.manageBook = book;
        this.mapLoans = new HashMap<>();
    }

    //
    public void add() {
        readIDLoans();
        String TransactionsID = "1." + count;
        count++;
        writeIDLoans();
        LocalDate borrowDate = LocalDate.now();

        String typeUserID = input.getString("Enter your ID User: ");

        if (manageUser.getMapUser().get(typeUserID) != null && manageUser.getMapUser().get(typeUserID).isActiveUser() == true) {
            String bookID = input.getString("Enter book ID to borrow: ");
            if (manageBook.getMapBook().get(bookID) != null && manageBook.getMapBook().get(bookID).isActiveBook() == true) {
                long addDate = input.getLong("How many days do you want to borrow?:  ");
                LocalDate returnDate = borrowDate.plusDays(addDate);
                Loans loan = new Loans(TransactionsID, typeUserID, bookID, borrowDate, returnDate, true);
                mapLoans.put(TransactionsID, loan);
                loan.setIsActiveLoans(true);
                manageBook.getMapBook().get(bookID).setActiveBook(false);
                System.out.println("Transaction success !!");
            } else {
                System.out.println("Book not Found !!");
            }
        } else {
            System.out.println("User not Found !!");
        }
    }

    public void update(String typeLoansID) {
        Set<String> keyset = mapLoans.keySet();

        int check = 0;

        for (String key : keyset) {
            if (typeLoansID.equalsIgnoreCase(key)) {
                check++;

                String addDa = input.getString("How many days do you want to extend borrow?:  ");
                if (!addDa.isEmpty()) {
                    long addDate = Long.parseLong(addDa);
                    LocalDate returnDate = mapLoans.get(key).getReturnDate().plusDays(addDate);
                    mapLoans.get(key).setReturnDate(returnDate);
                }

                if (mapLoans.get(key).getReturnDate().isBefore(LocalDate.now())) {
                    System.out.println("before ");
                    mapLoans.get(key).setIsActiveLoans(false);
                    manageBook.getMapBook().get(mapLoans.get(typeLoansID).getBookID()).setActiveBook(true);

                }
            }
        }
        if (check < 1) {
            System.out.println("User ID does not Exist!!!");
        }

    }

    public void returnBorrowUpdate() {
        LocalDate current = LocalDate.now();
        Iterator<String> iterator = mapLoans.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (mapLoans.get(key).getReturnDate().isBefore(current)) {

                String bookID = mapLoans.get(key).getBookID();
                System.out.println("bookid= " + bookID);
                manageBook.getMapBook().get(bookID).setActiveBook(true);

                iterator.remove();

            }
        }
    }

    public void readIDLoans() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountLoans.txt"));
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Error reading");
        }

    }

    public void writeIDLoans() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountLoans.txt"));
            writer.println(count);
            writer.close();
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public void disPlayLoans() {
//        TreeMap<String, Loans> sortedMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String author1 = mapLoans.get(o1).getTransactionID();
//                String author2 = mapLoans.get(o2).getTransactionID();
//                return author2.compareTo(author1);
//
//            }
//        });
//        sortedMap.putAll(mapLoans);
        ArrayList<Loans> mapSorted = new ArrayList<>(mapLoans.values());
        Collections.sort(mapSorted, new Comparator<Loans>() {
            @Override
            public int compare(Loans o1, Loans o2) {
                return o2.getTransactionID().compareTo(o1.getTransactionID());
            }
        });

        String horizontalLine = "+----------------------+-------------------------+-----------------+-------------------+----------------------+----------------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-23s | %-15s | %-17s | %-20s | %-21s|%n", "Transaction ID", "User ID", "Book ID", "Borrow Date", "Return Date", "Active Loans ");
        System.out.println(horizontalLine);

        Set<String> keyset = mapLoans.keySet();
//        for (String key : keyset) {
//            System.out.println(mapLoans.get(key));
//        }
        for (Loans book : mapSorted) {
            System.out.println(book);
        }

//        for (Map.Entry<String, Loans> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            Loans loans = entry.getValue();
//            System.out.println(loans);
//        }
        System.out.println(horizontalLine);
    }

    public void reportCurrentBorrow() {
        LocalDate localNow = LocalDate.now();
        Set<String> keyset = mapLoans.keySet();
        for (String key : keyset) {
            Period betweendate = Period.between(localNow, loans.getBorrowDate());
            if (betweendate.getDays() <= 30) {
                System.out.println(mapLoans.get(key));
            }
        }
    }

    public void overdueBook() {
        LocalDate localNow = LocalDate.now();
        Set<String> keyset = mapLoans.keySet();
        String horizontalLine = "+----------------------+-----------------+----------------+-------------------+----------------+----------------------+----------------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-20s |%n", "Book ID", "Book Title", "Author", "Publication Year", "Publisher", "ISBN", "Overdue Days");
        System.out.println(horizontalLine);
        for (String key : keyset) {
            if (!mapLoans.get(key).isIsActiveLoans()) {
                Loans loan = mapLoans.get(key);
                Book book = manageBook.getMapBook().get(loan.getBookID());
                if (book != null) {
                    long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(),loan.getReturnDate());
                    System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-20d |%n",
                            book.getBookID(), book.getBookTitle(), book.getAuthor(),
                            book.getPublicationYear(), book.getPublisher(), book.getISBN(),daysDifference);
                }
            }
        }
        System.out.println(horizontalLine);
    }

    public void periodBook() {
        Set<String> keyset = mapLoans.keySet();
        String horizontalLine = "+----------------------+-----------------+----------------+-------------------+----------------+----------------------+------------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-16s |%n", "Book ID", "Book Title", "Author", "Publication Year", "Publisher", "ISBN", "Remaining Days ");
        System.out.println(horizontalLine);

        for (String key : keyset) {
            if (mapLoans.get(key).isIsActiveLoans()) {
                Loans loan = mapLoans.get(key);
                Book book = manageBook.getMapBook().get(loan.getBookID());
                long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), loan.getReturnDate());

                System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-16d |%n",
                        book.getBookID(), book.getBookTitle(), book.getAuthor(), book.getPublicationYear(),
                        book.getPublisher(), book.getISBN(), daysDifference);
            }

        }

        System.out.println(horizontalLine);
    }

    public void writeFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Loans.dat");
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);
            Set<String> keyset = mapLoans.keySet();
            for (String key : keyset) {
                dataOutput.writeUTF(mapLoans.get(key).getTransactionID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapLoans.get(key).getUserID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapLoans.get(key).getBookID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapLoans.get(key).getBorrowDate().toString());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapLoans.get(key).getReturnDate().toString());
                dataOutput.writeChar('-');
                dataOutput.writeBoolean(mapLoans.get(key).isIsActiveLoans());
            }
            dataOutput.flush();
            System.out.println("Save success!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save error!");
        }
    }

    public void readFile() {
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Loans.dat");
            DataInputStream dataInput = new DataInputStream(fileInput);
            while (dataInput.available() > 0) {
                Loans loans = new Loans();
                String transactionId = dataInput.readUTF();
                loans.setTransactionID(transactionId);
                dataInput.readChar();
                loans.setUserID(dataInput.readUTF());
                dataInput.readChar();
                loans.setBookID(dataInput.readUTF());
                dataInput.readChar();
                String borrowDate = dataInput.readUTF();
                LocalDate publicationYear = LocalDate.parse(borrowDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                loans.setBorrowDate(publicationYear);
                dataInput.readChar();
                String returnDate = dataInput.readUTF();
                LocalDate publicationYear2 = LocalDate.parse(returnDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                loans.setReturnDate(publicationYear2);
                dataInput.readChar();
                loans.setIsActiveLoans(dataInput.readBoolean());
                mapLoans.put(transactionId, loans);
            }
            System.out.println("Read Success!");
        } catch (Exception e) {
        }
    }

}
