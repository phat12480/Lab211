/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Input {

    Scanner sc = new Scanner(System.in);

    //
    public int getInt(String mess) {
        System.out.print(mess);
        int type = Integer.parseInt(sc.nextLine());
        return type;
    }
  public long getLong(String mess) {
        System.out.print(mess);
        long type = sc.nextLong();
        sc.nextLine();
        return type;
    }
    public String getString(String mess) {
        System.out.print(mess);
        String type = (sc.nextLine());
        return type;

    }

    public double getDouble(String mess) {
        System.out.print(mess);
        double type = Double.parseDouble(sc.nextLine());
        return type;
    }

    public boolean getBoolean(String mess) {
        System.out.print(mess);
        String choice = null;
        boolean active = false;
        System.out.println("1: true");
        System.out.println("2: false");
        System.out.print("Enter your choice: ");
        choice=sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            active = true;
        } else if (choice.equalsIgnoreCase("2")) {
            active = false;
        } else {
            System.out.println("Enter 1 or 2: ");
        }
        return active;
    }
    //

}
