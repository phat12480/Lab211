/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Event;
import input.Enter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class EventManagement {

    public ArrayList<Event> listEvent;
    ArrayList<Event> listDelete = new ArrayList<>();
    Enter input = new Enter();
    int count = 171230;
    //

    public EventManagement() {
        listEvent = new ArrayList<>();
    }

    //methods
    public void createEvent(Event e) {
        int sizeOld = listEvent.size();
        listEvent.add(e);
        if (listEvent.size() > sizeOld) {
            System.out.println("Add success!");
        } else {
            System.out.println("Add faild!");
        }
        readID();
        count++;
        writeID();
        writeFile();
    }

    public void printEvent() {
        printFile();
        if (listEvent.isEmpty()) {
            System.out.println("List is empty!");
        }
        System.out.println("_________________________________________________________________________________________________________________________");
        System.out.printf("%-15s%-15s%-15s%-15s%12s", "|     ID", "|   Name", "|   Date", "|   Location   ", "|    Attendes ");
        System.out.print("       |          Status      |  Host         |");
        System.out.println("");
        System.out.println("|_______________________________________________________________________________________________________________________|");
        for (Event event : listEvent) {
            System.out.println(event);
        }
        System.out.println("|_______________________________________________________________________________________________________________________|");
    }

    public List<Event> checkID(String ID) {
        ArrayList<Event> listEventID = new ArrayList<>();
        for (Event event : listEvent) {
            if (event.getID().equalsIgnoreCase(ID)) {
                listEventID.add(event);
            }
        }
        if (listEventID.isEmpty()) {
            System.out.println("No Event Found!");
        } else {
            System.out.println("Exist Event!");
            System.out.println("____________________________________________________________________________________________________________");
            System.out.printf("%-15s%-15s%-15s%-15s%12s", "|     Name", "|   Date", "|   Location", "|   NumberAttendes ", "|       Status ");
            System.out.print("     |          ID");
            System.out.println("");
            System.out.println("|__________________________________________________________________________________________________________|");
            for (Event event : listEventID) {
                System.out.println(event);
            }
            System.out.println("|__________________________________________________________________________________________________________|");
        }
        return listEventID;
    }

    public List<Event> searchPartLocation(String partLocation) {
        ArrayList<Event> listSearch = new ArrayList<>();
        for (Event event : listEvent) {
            if (event.getLocation().toLowerCase().contains(partLocation.toLowerCase())) {
                listSearch.add(event);
            }
        }
        Collections.sort(listSearch, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getNumberAttendes() - o2.getNumberAttendes();
            }
        });

        if (listSearch.isEmpty()) {
            System.out.println("No Event Found!");
        } else {
            System.out.println("____________________________________________________________________________________________________________");
            System.out.printf("%-15s%-15s%-15s%-15s%12s", "|     Name", "|       Date    ", "|   Location", "|   NumberAttendes ", "|       Status ");
            System.out.print("     |          ID");
            System.out.println("");
            System.out.println("|__________________________________________________________________________________________________________|");
            for (Event event : listSearch) {
                System.out.println(event);
            }
            System.out.println("|__________________________________________________________________________________________________________|");
        }
        return listSearch;
    }

    public void updateByID(String ID) {
        Scanner sc = new Scanner(System.in);
        int check = 0;
        for (Event event : listEvent) {
            if (event.getID().equalsIgnoreCase(ID)) {
                String newName = input.checkNewName();
                if (!newName.isEmpty()) {
                    event.setName(newName);
                }

                String newDate = input.checkDate();
                if (!newDate.isEmpty()) {
                    event.setDate(newDate);
                }

                String newLocation = input.getString("Enter New Location: ");
                if (!newLocation.isEmpty()) {
                    event.setLocation(newLocation);
                }
                int hoa = 0;

                while (true) {
                    System.out.println("Enter Number Attendes: ");
                    String checkNumber = sc.nextLine();
                    if (checkNumber.trim().isEmpty()) {
                        break;
                    } else {
                        try {
                            hoa = Integer.parseInt(checkNumber);
                        } catch (Exception e) {
                        }
                    }
                    if (hoa > 0) {
                        event.setNumberAttendes(hoa);
                        break;
                    }
                    System.out.println("Number Not Valid! ");

                }

                String newStatus = input.checkNewStatus();
                if (!newStatus.isEmpty()) {
                    event.setStatus(newStatus);
                    check++;
                }
                check++;
            }
        }

        if (check != 0) {
            System.out.println("Update success!");
        } else {
            System.out.println("Event does not exist!");
            System.out.println("Update falure!");
        }

    }

    public void updateByIDNull(String ID) {
        Scanner sc = new Scanner(System.in);
        int check = 0;
        for (Event event : listEvent) {
            if (event.getID().equalsIgnoreCase(ID)) {
                
                String newName = input.checkName();
                if (!newName.trim().isEmpty()) {
                    event.setName(newName);
                }
                String host=input.getString("Enter host: ");
                if(!host.isEmpty()){
                    event.setHost(host);
                }
                
                String newDate = input.checkDate();
                if (!newDate.trim().isEmpty()) {
                    event.setDate(newDate);
                }
                System.out.print("Enter new Location: ");
                String newLocation = sc.nextLine();
                if (!newLocation.trim().isEmpty()) {
                    event.setLocation(newLocation);
                }
                System.out.print("Enter new NumberAttendes: ");
                int newNumberAttendes = 0;
                try {
                    newNumberAttendes = Integer.parseInt(sc.nextLine());
                    event.setNumberAttendes(newNumberAttendes);
                } catch (Exception e) {

                }

                System.out.println("Enter status: ");
                String newStatus = input.checkNewStatus();
                if (!newStatus.trim().isEmpty()) {
                    event.setStatus(newStatus);
                    check++;
                }
                check++;
            }
        }

        if (check != 0) {
            System.out.println("Update success!");
        } else {
            System.out.println("Event does not exist!");
            System.out.println("Update falure!");
        }

    }

    public List<Event> deleteByID(String ID) {
        if (listEvent.isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        

        for (Event event : listEvent) {
            if (event.getID().equalsIgnoreCase(ID)) {
                listDelete.add(event);
                listEvent.remove(event);
                break;
            }
        }
        if (listDelete.isEmpty()) {
            System.out.println("Event does not exist!");
            System.out.println("Delete failure!");
        } else {
            System.out.println("Delete sucess!");
        }
        return listDelete;
    }
//file    

    public void writeFile() {

        try {
            FileOutputStream fileOutput = new FileOutputStream("src\\file\\events.dat");
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);
            for (Event event : listEvent) {
                dataOutput.writeUTF(event.getID());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(event.getName());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(event.getDate());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(event.getLocation());
                dataOutput.writeChar('-');
                dataOutput.writeInt(event.getNumberAttendes());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(event.getStatus());
                dataOutput.writeChar('-');
                dataOutput.writeUTF(event.getHost());
                

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
            FileInputStream fileInput = new FileInputStream("src\\file\\events.dat");
            DataInputStream dataInput = new DataInputStream(fileInput);
            while (dataInput.available() > 0) {

                Event event = new Event();
                event.setID(dataInput.readUTF());
                dataInput.readChar();
                event.setName(dataInput.readUTF());
                dataInput.readChar();
                event.setDate(dataInput.readUTF());
                dataInput.readChar();
                event.setLocation(dataInput.readUTF());
                dataInput.readChar();
                event.setNumberAttendes(dataInput.readInt());
                dataInput.readChar();
                event.setStatus(dataInput.readUTF());
                dataInput.readChar();
                event.setHost(dataInput.readUTF());
                listEvent.add(event);
            }
            System.out.println("Read Success!");
        } catch (Exception e) {
        }
    }

    public void printFile() {
        Collections.sort(listEvent, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (!(o1.getDate().compareToIgnoreCase(o2.getDate()) == 0)) {
                    return o1.getDate().compareTo(o2.getDate());
                }
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

    }

    public void writeID() {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\upid.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(count);
            printWriter.println(count);
        } catch (IOException e) {
        }
    }

    public void readID() {
        try {
            FileReader fileRead = new FileReader("src\\file\\upid.txt");
            BufferedReader read = new BufferedReader(fileRead);
            count = Integer.parseInt(read.readLine());

        } catch (Exception e) {
        }

    }

    public int findcount() {
        readID();
        
        for (Event event : listEvent) {
            for (Event event1 : listDelete) {
                if(event1.getID().equalsIgnoreCase(event.getID())){
                    count++;
                }
            }
            
        }
        count++;
        writeID();
        return count;
    }
    
    
    public void searchByHostAndLocation(String host, String location){
        Scanner sc=new Scanner(System.in);
        ArrayList<Event> newList=new ArrayList<>();
        for (Event event : listEvent) {
            if(event.getLocation().toLowerCase().contains(location.toLowerCase()) && event.getHost().toLowerCase().contains(host.toLowerCase()) ){
                newList.add(event);
            }
        }
        for (Event event : newList) {
            System.out.println(event);
        }
        
    }

}
