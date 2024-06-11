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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;
import model.Book;

/**
 *
 * @author ADMIN
 */
public class ManageBooks extends Book implements Manageable {

    HashMap<String, Book> mapBook;
    Input input = new Input();
    Book book = new Book();
    int count = 10;

    public ManageBooks() {
        mapBook = new HashMap<>();
    }
    //

    public HashMap<String, Book> getMapBook() {
        return mapBook;
    }

    public Book getBookBySomeCriteria() {
        // Implement your logic here to retrieve the book based on specific criteria

        // For example, you might retrieve the book by its title
        String bookTitle = input.getString("Enter the book title: ");
        for (Book book : mapBook.values()) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }

        // If no book matches the criteria, return null or throw an exception
        return null;
    }

    @Override
    public void add() {
        readIDBook();
        String bookID = "1." + count;
        count++;
        writeIDBook();
        String bookTitle = input.getString("Enter bookTitle: ");
        String author = input.getString("Enter author: ");
        String year = input.getString("Enter publicationYear(yyyy): ");
        LocalDate publicationYear = LocalDate.parse(year + "-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String publisher = input.getString("Enter publisher: ");
        String pattern = "^\\d{3}-\\d-\\d{5}-\\d{3}-\\d$";
        String autoISBN = "132-9-12378-0" + count + "5";
        boolean ISBN = Pattern.matches(pattern, autoISBN);

        Book newBook = new Book(bookID, bookTitle, author, publicationYear, publisher, autoISBN, true);
        mapBook.put(bookID, newBook);
        System.out.println("Add Sucess!!!");
    }

    @Override
    public void update(String typebookID) {
        Set<String> keyset = mapBook.keySet();
        int check = 0;
        for (String key : keyset) {
            if (typebookID.equalsIgnoreCase(key)) {
                check++;

                String bookTitle = input.getString("Enter newBookTitle: ");
                if (!bookTitle.isEmpty()) {
                    mapBook.get(key).setBookTitle(bookTitle);
                }
                String author = input.getString("Enter newAuthor: ");
                if (!author.isEmpty()) {
                    mapBook.get(key).setAuthor(author);
                }
                String year = input.getString("Enter newPublicationYear(yyyy): ");
                if (!year.isEmpty()) {
                    LocalDate publicationYear = LocalDate.parse(year + "-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    mapBook.get(key).setPublicationYear(publicationYear);
                }
                String publisher = input.getString("Enter newPublisher: ");
                if (!publisher.isEmpty()) {
                    mapBook.get(key).setPublisher(publisher);
                }
                String ISBN = input.getString("Enter newISBN: ");
                if (!ISBN.isEmpty()) {
                    book.setISBN(ISBN);
                }
            }
        }
        if (check < 1) {
            System.out.println("Book ID does not Exist!!!");
        }
    }

    @Override
    public void delete(String typeBookID) {
        Set<String> keyset = mapBook.keySet();
        int check = 0;
        for (String key : keyset) {
            if (typeBookID.equalsIgnoreCase(key)) {
                check++;
                mapBook.get(key).setActiveBook(false);
            }
        }
        if (check < 1) {
            System.out.println("Book ID does not Exist!!!");
        }

    }

    public void disPlayBooks() {

//        TreeMap<String, Book> sortedMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String author1 = mapBook.get(o1).getBookID();
//                String author2 = mapBook.get(o2).getBookID();
//                return author2.compareTo(author1);
//
//            }
//        });
//        sortedMap.putAll(mapBook);
        ArrayList<Book> mapSorted = new ArrayList<>(mapBook.values());
        Collections.sort(mapSorted, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getBookID().compareTo(o1.getBookID());
            }
        });

        String horizontalLine = "+----------------------+-----------------+----------------+-------------------+----------------+----------------------+-----------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-15s |%n", "Book ID", "Book Title", "Author", "Publication Year", "Publisher", "ISBN", "Active Book");
        System.out.println(horizontalLine);

        Set<String> keyset = mapBook.keySet();

        for (Book book : mapSorted) {
            System.out.println(book);
        }

//        for (Map.Entry<String, Book> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            Book book = entry.getValue();
//            System.out.println(book);
//        }
        System.out.println(horizontalLine);

    }

    public void disPlayBooksFalse() {
//
//        TreeMap<String, Book> sortedMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String author1 = mapBook.get(o1).getBookID();
//                String author2 = mapBook.get(o2).getBookID();
//                return author2.compareTo(author1);
//
//            }
//        });
//        sortedMap.putAll(mapBook);

        ArrayList<Book> mapSorted = new ArrayList<>(mapBook.values());
        Collections.sort(mapSorted, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getBookID().compareTo(o1.getBookID());
            }
        });

        String horizontalLine = "+----------------------+-----------------+----------------+-------------------+----------------+----------------------+-----------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-15s | %-14s | %-17s | %-14s | %-20s | %-15s |%n", "Book ID", "Book Title", "Author", "Publication Year", "Publisher", "ISBN", "Active Book");
        System.out.println(horizontalLine);

        Set<String> keyset = mapBook.keySet();
        for (Book book : mapSorted) {
            if(book.isActiveBook()==false){
            System.out.println(book);    
            }
            
        }

//        for (Map.Entry<String, Book> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            Book book = entry.getValue();
//            if ((book.isActiveBook() == false)) {
//                System.out.println(book);
//            }
//
//        }
        System.out.println(horizontalLine);

    }

    public void readIDBook() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountBook.txt"));
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
        }
    }

    public void writeIDBook() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountBook.txt"));
            writer.println(count);
            writer.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public boolean checkIDBook(String typeIDBook) {

        Set<String> keyset = mapBook.keySet();
        boolean checkIDBook = false;

        for (String key : keyset) {
            if (typeIDBook.equalsIgnoreCase(key) && mapBook.get(key).isActiveBook()) {
                checkIDBook = true;
                delete(typeIDBook);
            }

        }
        return checkIDBook;

    }

    public String takeIDBook(String typeIDBook) {

        Set<String> keyset = mapBook.keySet();
        boolean checkIDBook = false;
        String idBook = null;
        for (String key : keyset) {
            if (typeIDBook.equalsIgnoreCase(key) && mapBook.get(key).isActiveBook()) {
                checkIDBook = true;
                idBook = key;
            }
        }
        if (checkIDBook == false) {
            System.out.println("Book Run out of");
        }
        return idBook;

    }

    public void writeFileBook() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Books.dat");
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);
            Set<String> keyset = mapBook.keySet();
            for (String key : keyset) {
                dataOutput.writeUTF(mapBook.get(key).getBookID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapBook.get(key).getBookTitle());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapBook.get(key).getAuthor());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapBook.get(key).getPublicationYear().toString());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapBook.get(key).getPublisher());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapBook.get(key).getISBN());
                dataOutput.writeChar('-');
                dataOutput.writeBoolean(mapBook.get(key).isActiveBook());
                
            }
            dataOutput.flush();
            System.out.println("SaveBook success!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save error!");
        }
    }

    public void readFileBook() {
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Books.dat");
            DataInputStream dataInput = new DataInputStream(fileInput);
            while (dataInput.available() > 0) {

                Book book = new Book();
                String bookId = dataInput.readUTF();
                book.setBookID(bookId);
                dataInput.readChar();
                book.setBookTitle(dataInput.readUTF());
                dataInput.readChar();
                book.setAuthor(dataInput.readUTF());
                dataInput.readChar();
                String stringpublication = dataInput.readUTF();
                LocalDate publicationYear = LocalDate.parse(stringpublication, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                book.setPublicationYear(publicationYear);
                dataInput.readChar();
                book.setPublisher(dataInput.readUTF());
                dataInput.readChar();
                book.setISBN(dataInput.readUTF());
                dataInput.readChar();
                book.setActiveBook(dataInput.readBoolean());
                mapBook.put(bookId, book);
            }
            System.out.println("Read Success!");
        } catch (Exception e) {
        }

    }

}
