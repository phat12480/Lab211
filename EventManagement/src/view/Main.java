/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EventManagement;
import input.Enter;
import model.Event;
import java.util.Scanner;

/**
 * 6
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventManagement manageEvent = new EventManagement();
        Enter input = new Enter();

        //
        String choice;
        String choiceOptioin4;
        String isYesNo;
        String isYesNoOption4;
        String conformDelete;
        manageEvent.readFile();

        do {
            System.out.println("_________________________________________________________________");
            System.out.println("|         1: Create Event                                        |");
            System.out.println("|         2: Check ID                                            |");
            System.out.println("|         3: Search Event by location                            |");
            System.out.println("|         4: Update Event                                        |");
            System.out.println("|         5: Save File                                           |");
            System.out.println("|         6: Read File                                           |");
            System.out.println("|         7: Print all events list                               |");
            System.out.println("|         8: Exist                                               |");
            System.out.println("|________________________________________________________________|");
            choice = input.getString("Enter your choice: ");
            do {
                if (choice.equalsIgnoreCase("1")) {
                    int count = manageEvent.findcount();
                    
                    String newID = "SE" + count;
                    String ID = String.format("%.8s", newID);
                    String name = input.checkName();
                    String date = input.checkDate();
                    String location = input.getString("Enter location: ");
                    int numberAttendes = input.checkNumberAttendes();
                    String status = input.checkStatus();
                    String host=input.getString("Enter Host: ");
                    Event newEvent = new Event(name, date, location, numberAttendes, status, ID, host);
                   
                    manageEvent.createEvent(newEvent);

                } else if (choice.equalsIgnoreCase("2")) {
                    String ID = input.getString("Enter ID to Check: ");
                    manageEvent.checkID(ID);
                } else if (choice.equalsIgnoreCase("3")) {
                    String location = input.getString("Enter location to search: ");
                    manageEvent.searchPartLocation(location);
                } else if (choice.equalsIgnoreCase("4")) {
                    do {
                        System.out.println("A: Update event by ID");
                        System.out.println("B: Delete event by ID");
                        System.out.println("C: Exist");
                        choiceOptioin4 = input.getStringUpdate("Update or Delete: ");

                        do {
                            if (choiceOptioin4.equalsIgnoreCase("A")) {
                                String typeID = input.getString("Enter ID to update: ");
                                manageEvent.updateByIDNull(typeID);
                                manageEvent.printEvent();
                                manageEvent.writeFile();
                            } else if (choiceOptioin4.equalsIgnoreCase("B")) {
                                String deletebyID = input.getString("Enter ID to delete: ");
                                System.out.print("Conform to delete Y/N: ");
                                conformDelete = sc.nextLine();
                                if (conformDelete.equalsIgnoreCase("Y")) {
                                    manageEvent.deleteByID(deletebyID);
                                    manageEvent.printEvent();
                                    manageEvent.writeFile();
                                }
                            } else if (choiceOptioin4.equalsIgnoreCase("C")) {
                                break;
                            }
                            isYesNoOption4 = input.getYesNo("Do you want continue Y/N: ");
                        } while (isYesNoOption4.equalsIgnoreCase("Y"));

                    } while (!choiceOptioin4.equalsIgnoreCase("C"));
                    break;
                } else if (choice.equalsIgnoreCase("5")) {
                    manageEvent.writeFile();
                    break;
                } else if (choice.equalsIgnoreCase("6")) {
                    manageEvent.readFile();

                    break;
                } else if (choice.equalsIgnoreCase("7")) {
                    manageEvent.printEvent();
                    break;
                } else if (choice.equalsIgnoreCase("8")) {
                    break;
                } 
                  else if(choice.equalsIgnoreCase("9")){
                        System.out.println("Enter host to find");
                        String typeHost=sc.nextLine();
                        System.out.println("Enter location to find");
                        String locatioin=sc.nextLine();
                        if(typeHost.isEmpty() || locatioin.isEmpty()){
                            break;
                        }
                        manageEvent.searchByHostAndLocation(typeHost, locatioin);
                        }
                else {
                    break;
                }
              

                isYesNo = input.getYesNo("Do you want continue Y/N: ");
            } while (isYesNo.equalsIgnoreCase("Y"));
        } while (!choice.equalsIgnoreCase("8"));
    }

}
