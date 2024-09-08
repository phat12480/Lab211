/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Event;

/**
 *
 * @author ADMIN
 */
public class Enter {

    Scanner sc = new Scanner(System.in);
    Event event = new Event();

//Scanner
    public int getInt(String mess) {
        int type = 0;
        try {
            System.out.print(mess);
            type = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Enter is empty!");
        }

        return type;
    }

    public String getString(String mess) {
        String type;
        do {
            System.out.print(mess);
            type = sc.nextLine();
            if (type.isEmpty()) {
                System.out.println("Enter is empty!");
            }

        } while (type.isEmpty());
        return type;
    }

    public String getStringStatus(String mess) {
        String type;
        do {
            System.out.print(mess);
            type = sc.nextLine();
            if (type.isEmpty()) {
                System.out.println("Enter is empty!");
            } else if (!type.equalsIgnoreCase("1") && !type.equalsIgnoreCase("2")) {
                System.out.println("Enter 1 or 2");
            }

        } while (type.isEmpty() || (!type.equalsIgnoreCase("1") && !type.equalsIgnoreCase("2")));
        return type;
    }

    public String getStringUpdate(String mess) {
        String type;
        do {
            System.out.print(mess);
            type = sc.nextLine();
            if (type.isEmpty()) {
                System.out.println("Enter is empty!");
            } else if (!type.equalsIgnoreCase("A") && !type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("C")) {
                System.out.println("Enter A, B, C");
            }
        } while (type.isEmpty() || (!type.equalsIgnoreCase("A") && !type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("C")));
        return type;
    }

    public double getDouble(String mess) {
        System.out.print(mess);
        double type = Double.parseDouble(sc.nextLine());
        return type;
    }

    public String getYesNo(String mess) {
        String type;
        do {
            System.out.print(mess);
            type = sc.nextLine();
            if (type.isEmpty()) {
                System.out.println("Enter is empty");
            } else if (!type.equalsIgnoreCase("Y") && !type.equalsIgnoreCase("N")) {
                System.out.println("Enter Y or N");
            }
        } while (type.isEmpty() || (!type.equalsIgnoreCase("Y") && !type.equalsIgnoreCase("N")));
        return type;
    }

    public long checkAutoID() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {

        }
        return t1 % 1000000;
    }
//Check data

    public String checkName() {
        String name;
        do {
            name = getString("Enter name: ");
            if (name.length() < 5 || name.contains(" ")) {
                System.out.println("length of name > 5 and have not space");
            }
        } while (name.length() < 5 || name.contains(" "));
        return name;
    }
    public String updateName() {
        String name;
        do {
            System.out.print("Enter name: ");
            name=sc.nextLine();
            if (name.length() < 5 || name.contains(" ")) {
                System.out.println("length of name > 5 and have not space");
            }
        } while (name.length() < 5 || name.contains(" "));
        return name;
    }
    public String checkDate() {
        String date = null;
        int compareOldYear;
        int compareNewYear;
        boolean out = true;
        do {
            date = getString("Enter Date yyyy-MM-dd: ");
            if (!checkDateBooleanBackup(date)) {
                System.out.println("Format date wrong!");
                out = false;
            } else {
                out = true;
            }

            compareOldYear = date.compareTo("2014-01-01");
            compareNewYear = date.compareTo("2034-01-01");

            if (compareOldYear < 0 || compareNewYear > 0) {
                System.out.println("date have to between 2014 and 2034");
            }
        } while (compareOldYear < 0 || compareNewYear > 0 || out == false);
        return date;

    }
  public String updateDate() {
        String date = null;
        int compareOldYear;
        int compareNewYear;
        boolean out = true;
        do {
            System.out.print("Enter Date yyyy-MM-dd: ");
            date=sc.nextLine();
            
            if (!checkDateBooleanBackup(date)) {
                System.out.println("Format date wrong!");
                out = false;
            } else {
                out = true;
            }

            compareOldYear = date.compareTo("2014-01-01");
            compareNewYear = date.compareTo("2034-01-01");

            if (compareOldYear < 0 || compareNewYear > 0) {
                System.out.println("date have to between 2014 and 2034");
            }
        } while (compareOldYear < 0 || compareNewYear > 0 || out == false);
        return date;

    }
    public boolean checkDateBoolean(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now();
        try {
            localDate.format(format);
            System.out.println(localDate.getDayOfMonth());
            System.out.println("");
            return true;
        } catch (Exception e) {
            System.out.println("error");
            return false;
        }

    }

    public LocalDate convertDate(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        try {
            LocalDate parse = localDate.parse(date);
            return parse;
        } catch (Exception e) {
            System.out.println("error");

        }
        return null;

    }

    public boolean checkDateBooleanBackup(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        try {
            LocalDate parse = localDate.parse(date);
            parse.format(format);
            return true;
        } catch (Exception e) {
            System.out.println("error");
        }
        return false;
    }

    public int checkNumberAttendes() {
        int numberAttendes;
        do {
            numberAttendes = getInt("Enter number Attendes: ");
            if (numberAttendes <= 0) {
                System.out.println("at least 1 attendes");
            }
        } while (numberAttendes <= 0);
        return numberAttendes;

    }

    public String checkStatus() {
        String status = null;
        String choice = null;

        System.out.println("1: Available");
        System.out.println("2: Not Available");

        choice = getStringStatus("Click Status: ");
        if (choice.equals("1")) {
            status = "Available";
        } else if (choice.equals("2")) {
            status = "Not available";
        }
        return status;

    }

//check new type
    public String checkNewName() {
        String name;
        do {
            System.out.print("Enter new name: ");
            name = sc.nextLine();

            if (name.length() < 5 || name.contains(" ")) {
                System.out.println("Length of name > 5 and No have space");
            }
        } while (name.length() < 5 || name.contains(" "));

        return name;

    }

    public String checkNewDate() {
        String date = null;
        int compareOldYear;
        int compareNewYear;
        boolean out = true;
        do {
            System.out.println("Enter date yyyy-MM-dd");
            date = sc.nextLine();
            if (!checkDateBoolean(date)) {
                System.out.println("format date wrong");
                out = false;
            } else {
                out = true;
            }

            compareOldYear = date.compareTo("2014-01-01");
            compareNewYear = date.compareTo("2034-01-01");

            if (compareOldYear < 0 || compareNewYear > 0) {
                System.out.println("date have to between 2014 and 2034");
            }
        } while (compareOldYear < 0 || compareNewYear > 0 || out == false);
        return date;

    }

    public int checkNewNumberAttendes() {
        int numberAttendes = 0;
        String type = null;
        try {
            do {
                type = sc.nextLine();
                if (type.isEmpty()) {
                    System.out.println("Enter is empty");
                    numberAttendes = 0;
                    break;
                } else {
                    numberAttendes = Integer.parseInt(type);
                }

                if (numberAttendes <= 0) {
                    System.out.println("at least 1 attendes");
                }
            } while (numberAttendes <= 0);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return numberAttendes;

    }

    public String checkNewStatus() {
        String Status = null;
        String choice = null;
        do {
            System.out.println("1: Available");
            System.out.println("2: Not Available");

            System.out.print("Enter new Status: ");
            choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2")) {
                System.out.println("Enter 1 or 2");
            }
        } while (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2"));

        if (choice.equalsIgnoreCase("1")) {
            Status = "Available";
        } else if (choice.equalsIgnoreCase("2")) {
            Status = "Not available";
        }

        return Status;

    }

}
