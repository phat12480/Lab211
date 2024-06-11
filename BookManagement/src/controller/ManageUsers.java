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
import model.User;

/**
 *
 * @author ADMIN
 */
public class ManageUsers extends User implements Manageable {

    HashMap<String, User> mapUser;
    int count = 10;
    Input input = new Input();
    User user = new User();

    public ManageUsers() {
        mapUser = new HashMap<>();
    }

    public ManageUsers(HashMap<String, User> mapUser) {
        this.mapUser = mapUser;
    }

    //
    public HashMap<String, User> getMapUser() {
        return mapUser;
    }

    @Override
    public void add() {
        readIDUser();
        String userID = "1." + count;
        count++;
        writeIDUsser();
        
        String name = input.getString("Enter name: ");
        String daBirth = input.getString("Enter dateBirth(yyyy-MM-dd): ");
        LocalDate dateBirth = LocalDate.parse(daBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String phoneNumberRegex = "^\\d{10}$";
        String phoneNumber = input.getString("Enter phoneNumber: ");
        boolean checkPhoneNumber = Pattern.matches(phoneNumberRegex, phoneNumber);

        String emailRegex = "^.+@gmail\\.com$";
        String email = input.getString("Enter name of email (@gmail.com): ");
        String emailComplete=email+"@gmail.com";
        boolean checkEmail = Pattern.matches(emailRegex, emailComplete);

        User newUser = new User(userID, name, dateBirth, phoneNumber, emailComplete, true);

        mapUser.put(userID, newUser);
        System.out.println("Add Sucess!!!");
    }

    @Override
    public void update(String typeUserID) {
        Set<String> keyset = mapUser.keySet();
        int check = 0;
        for (String key : keyset) {
            if (typeUserID.equalsIgnoreCase(key)) {
                check++;

                String name = input.getString("Enter newName: ");
                if (!name.isEmpty()) {
                    mapUser.get(key).setName(name);
                }
                String dateBirth = input.getString("Enter newDateBirth: ");
                if (!dateBirth.isEmpty()) {
                    LocalDate publicationYear = LocalDate.parse(dateBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    mapUser.get(key).setDateBirth(publicationYear);
                }
                String phoneNumber = input.getString("Enter newPhoneNumber: ");
                if (!phoneNumber.isEmpty()) {
                    mapUser.get(key).setPhoneNumber(phoneNumber);
                }
                String email = input.getString("Enter newEmail: ");
                if (!email.isEmpty()) {
                    mapUser.get(key).setEmail(email);
                }
            }
        }
        if (check < 1) {
            System.out.println("User ID does not Exist!!!");
        }
    }

    @Override
    public void delete(String typeUserID) {
        Set<String> keyset = mapUser.keySet();
        int check = 0;
        for (String key : keyset) {
            if (typeUserID.equalsIgnoreCase(key)) {
                check++;
                mapUser.get(key).setActiveUser(false);
            }

        }
        if (check < 1) {
            System.out.println("User ID does not Exist!!!");

        }
        for (String key : keyset) {
            if (!mapUser.get(key).isActiveUser()) {
                disPlayUsers();
            }
        }
    }

    public void disPlayUsers() {
//        TreeMap<String, User> sortedMap = new TreeMap<>((String o1, String o2) -> {
//            String author1 = mapUser.get(o1).getUserID();
//            String author2 = mapUser.get(o2).getUserID();
//            return author2.compareTo(author1);
//        });
//        sortedMap.putAll(mapUser);

 ArrayList<User> mapSorted = new ArrayList<>(mapUser.values());
        Collections.sort(mapSorted, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getUserID().compareTo(o1.getUserID());
            }
        });
        String horizontalLine = "+----------------------+-------------------------+-----------------+-------------------+----------------------+----------------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-20s | %-23s | %-15s | %-17s | %-20s | %-20s |%n", "User ID", "Name", "Date of Birth", "Phone Number", "Email", "Active User");
        System.out.println(horizontalLine);

        Set<String> keyset = mapUser.keySet();
//        for (String key : keyset) {
//            System.out.println(mapUser.get(key));
//        }
   for (User book : mapSorted) {
            System.out.println(book);
        }

//        for (Map.Entry<String, User> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            User user = entry.getValue();
//            System.out.println(user);
//        }
        System.out.println(horizontalLine);
    }

    public void readIDUser() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountUser.txt"));
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
        }
    }

    public void writeIDUsser() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\CountUser.txt"));
            writer.println(count);
            writer.close();
        } catch (Exception e) {
           
        }

    }

    public boolean checkID(String typeUserID) {
        Set<String> keyset = mapUser.keySet();
        boolean checkUserID = false;
        System.out.println("key " + mapUser.get(typeUserID));
        for (String key : keyset) {
            if (typeUserID.equalsIgnoreCase(key) && mapUser.get(key).isActiveUser()) {
                checkUserID = true;
            }
        }
        return checkUserID;
    }

    public String takeUserID(String typeUserID) {
        Set<String> keyset1 = mapUser.keySet();
        String userID = null;
        boolean checkID = false;
        System.out.println("hello");
        for (String key : keyset1) {
            System.out.println("key = " + key);
            if (typeUserID.equalsIgnoreCase(key) && mapUser.get(key).isActiveUser()) {
                userID = key;
                checkID = true;
                break;
            }
        }
        if (checkID == false) {
            System.out.println("ID does not exist: ");
        }
        return userID;
    }

    public void writeFileUser() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Users.dat");
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);
            Set<String> keyset = mapUser.keySet();
            for (String key : keyset) {
                dataOutput.writeUTF(mapUser.get(key).getUserID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapUser.get(key).getName());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapUser.get(key).getDateBirth().toString());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapUser.get(key).getPhoneNumber());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(mapUser.get(key).getEmail());
                dataOutput.writeChar('-');
                dataOutput.writeBoolean(mapUser.get(key).isActiveUser());
            }

            dataOutput.flush();
            System.out.println("SaveUser success!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save error!");
        }
    }

    public void readFileUser() {
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Fpt\\Curriculum_3\\LAB211\\Run\\BookManagement\\src\\fileio\\Users.dat");
            DataInputStream dataInput = new DataInputStream(fileInput);
            while (dataInput.available() > 0) {
                User user = new User();
                String userId = dataInput.readUTF();
                user.setUserID(userId);
                dataInput.readChar();
                user.setName(dataInput.readUTF());
                dataInput.readChar();
                String dateBirth = dataInput.readUTF();
                LocalDate publicationYear = LocalDate.parse(dateBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                user.setDateBirth(publicationYear);
                dataInput.readChar();
                user.setPhoneNumber(dataInput.readUTF());
                dataInput.readChar();
                user.setEmail(dataInput.readUTF());
                dataInput.readChar();
                user.setActiveUser(dataInput.readBoolean());
                mapUser.put(userId, user);
            }
            System.out.println("Read Success!");
        } catch (Exception e) {
        }
    }
}
