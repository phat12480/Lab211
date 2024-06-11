/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import controller.ManageBooks;
import controller.ManageLoans;
import controller.ManageUsers;
import input.Input;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        ManageBooks manageBook = new ManageBooks();
        ManageUsers manageUser = new ManageUsers();
        ManageLoans manageLoan = new ManageLoans(manageUser, manageBook);
        //
        String choiceMenu = null;
        String choiceBook = null;
        String choiceUser = null;
        String choiceYesNo = null;
        String choiceConform = null;
        //

        do {
            manageBook.readFileBook();
            manageBook.disPlayBooks();
            manageUser.readFileUser();
            manageUser.disPlayUsers();
            manageLoan.readFile();
            manageLoan.disPlayLoans();
            String[] menu = {"ManageBook.",
                "ManageUser.",
                "ManageLoan.",
                "Reporting.",
                "Save file.",
                "Quit."};
            Main.printMenu(menu);
            //
            choiceMenu = input.getString("Enter your choice: ");
            if (choiceMenu.equalsIgnoreCase("1")) {

                do {
                    String[] menuBook = {"Add book.",
                        "Update book.",
                        "Delete book.",
                        "Show all book.",
                        "Quit."};
                    Main.printMenu(menuBook);
                    //
                    choiceBook = input.getString("Enter your choice: ");
                    if (choiceBook.equalsIgnoreCase("1")) {
                        manageBook.add();
                        manageBook.writeFileBook();
                        manageBook.disPlayBooks();
                    } else if (choiceBook.equalsIgnoreCase("2")) {
                        String updateBookID = input.getString("Enter bookID to update: ");
                        manageBook.update(updateBookID);
                        manageBook.writeFileBook();
                        manageBook.disPlayBooks();
                    } else if (choiceBook.equalsIgnoreCase("3")) {
                        String deleteBookID = input.getString("Enter bookID to delete: ");
                        choiceConform = input.getString("Do you want to Delete? Y/N: ");
                        if (choiceConform.equalsIgnoreCase("Y")) {
                            manageBook.delete(deleteBookID);
                            manageBook.writeFileBook();
                            manageBook.disPlayBooks();
                        } else {
                            System.out.println("No Delete!!!");
                        }
                    } else if (choiceBook.equalsIgnoreCase("4")) {
                        manageBook.readFileBook();
                        manageBook.disPlayBooks();
                    } else {
                        break;
                    }
                    choiceYesNo = input.getString("Do you want continue manageBook? Y/N: ");

                } while (choiceYesNo.equalsIgnoreCase("Y"));

            } else if (choiceMenu.equalsIgnoreCase("2")) {
                do {
                    String[] menuUser = {"Add User.",
                        "Update User.",
                        "Delete User.",
                        "Show all user.",
                        "Quit."};
                    Main.printMenu(menuUser);
                    //
                    choiceUser = input.getString("Enter your choice: ");
                    if (choiceUser.equalsIgnoreCase("1")) {
                        manageUser.add();
                        manageUser.writeFileUser();
                        manageUser.disPlayUsers();
                    } else if (choiceUser.equalsIgnoreCase("2")) {
                        String updateUserID = input.getString("Enter userID to update: ");
                        manageUser.update(updateUserID);
                        manageUser.writeFileUser();
                        manageUser.disPlayUsers();

                    } else if (choiceUser.equalsIgnoreCase("3")) {
                        String deleteUserID = input.getString("Enter userID to delete: ");
                        choiceConform = input.getString("Do you want to Delete? Y/N: ");
                        if (choiceConform.equalsIgnoreCase("Y")) {
                            manageUser.delete(deleteUserID);
                            manageUser.writeFileUser();
                            manageUser.disPlayUsers();
                        } else {
                            System.out.println("No Delete!!!");
                        }

                    } else if (choiceUser.equalsIgnoreCase("4")) {
                        manageUser.readFileUser();
                        manageUser.disPlayUsers();
                    } else {
                        break;
                    }
                    choiceYesNo = input.getString("Do you want continue Y/N: ");

                } while (choiceYesNo.equalsIgnoreCase("Y"));

            } else if (choiceMenu.equalsIgnoreCase("3")) {
                do {
                    String[] menuLoans = {"Add Borrow.",
                        "Update borrow.",
                        "Displays all borrow.",
                        "Quit."};
                    Main.printMenu(menuLoans);
                    choiceUser = input.getString("Enter your choice: ");
                    if (choiceUser.equalsIgnoreCase("1")) {
                        manageLoan.add();
                        manageLoan.writeFile();
                        manageBook.writeFileBook();
                        manageLoan.disPlayLoans();
                    } else if (choiceUser.equalsIgnoreCase("2")) {
                        String updateLoansID = input.getString("Enter LoansID to update: ");
                        manageLoan.update(updateLoansID);
                        manageBook.disPlayBooks();
                        manageLoan.writeFile();
                        manageBook.writeFileBook();
                        manageLoan.disPlayLoans();
                    } else if (choiceUser.equalsIgnoreCase("3")) {
                        manageLoan.readFile();
                        manageLoan.disPlayLoans();
                    } else {
                        break;
                    }

                    choiceYesNo = input.getString("Do you want continue Y/N: ");

                } while (choiceYesNo.equalsIgnoreCase("Y"));
            } else if (choiceMenu.equalsIgnoreCase("4")) {
                do {
                    String[] menuReport = {"Report on Borrowed Books.",
                        "Report on Overdue Books.",
                        "Report on Borrowing Activities.",
                        "Quit."};
                    Main.printMenu(menuReport);
                    choiceUser = input.getString("Enter your choice: ");
                    if (choiceUser.equalsIgnoreCase("1")) {
                        manageBook.disPlayBooksFalse();
                    } else if (choiceUser.equalsIgnoreCase("2")) {
                        manageLoan.overdueBook();
                    } else if (choiceUser.equalsIgnoreCase("3")) {
                        manageLoan.periodBook();
                    } else {
                        break;
                    }

                    choiceYesNo = input.getString("Do you want continue Y/N: ");

                } while (choiceYesNo.equalsIgnoreCase("Y"));
            } else {
                break;
            }
        } while (!choiceMenu.equalsIgnoreCase("5"));

    }

    public static void printMenu(String[] menu) {

        String format = "| %-2d. %-34s |%n";
        System.out.format("+----------------------------------------+%n");
        System.out.format("|                Menu                    |%n");
        System.out.format("+----------------------------------------+%n");

        for (int i = 0; i < menu.length; i++) {
            System.out.format(format, i + 1, menu[i]);
        }

        System.out.format("+----------------------------------------+%n");
    }

}
