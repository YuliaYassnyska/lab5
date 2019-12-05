package ua.lviv.iot.view;


import ua.lviv.iot.controller.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

public class View {
    private static Controller controller;
    private static String submenu =
            "\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Update\n\t5 - Delete\n\tQ - Go back\n";

    public View() {
        controller = new Controller();
    }

    public void show() throws SQLException {
        String menuPoint;
        do {
            System.out.println("Press ENTER key to continue...");
            new Scanner(System.in).nextLine();

            outputMenu();
            System.out.print("\nPlease, select menu point: ");
            menuPoint = new Scanner(System.in).nextLine().toUpperCase();

            switch (menuPoint) {
                case "1":
                    AddressView();
                    break;
                case "2":
                    CollectinCahView();
                    break;
                case "3":
                    InformationView();
                    break;
                case "4":
                    OverhaulView();
                    break;
                case "5":
                    ProvidedServicesView();
                    break;
                case "6":
                    ServicedCompanyView();
                    break;
                case "7":
                    ServiceWizardView();
                    break;
                case "8":
                    ServiceWorkView();
                    break;
                case "9":
                    StandartView();
                    break;
                case "10":
                    TerminalView();
                    break;
                case "Q":
                    System.out.println("\n\nExit...");
                    break;
                default:
                    System.out.println("Menu point does not exist!");
            }
        } while (!menuPoint.equals("Q"));
    }

    private void outputMenu() {
        System.out.println("\t\tMenu");
        System.out.println("(Choose Table to work with:)");
        System.out.print("\t1 - Address\n" + "\t2 - CollectinCah\n" + "\t3 - Information\n" + "\t4 - Overhaul\n" +
                "\t5 - ProvidedServices\n" + "\t6 - ServicedCompany\n" + "\t7 - ServiceWizard\n" + "\t8 - ServiceWork\n" +
                "\t9 - Standart\n" + "\t10 - Terminal\n" +
                "\tQ - Exit\n");
    }

    private void TerminalView() throws SQLException {
        System.out.println("\tYou choose table 'terminal'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllTerminals();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findByTerminalId(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter comment data: ");
                String logo = new Scanner(System.in).nextLine();
                System.out.print("Enter location id: ");
                String function = new Scanner(System.in).nextLine();
                controller.createTerminal(id, logo, function);
                break;
            case "4":
            	 System.out.print("Enter id: ");
                 Integer newId = new Scanner(System.in).nextInt();
                 System.out.print("Enter logo: ");
                 String newLogo = new Scanner(System.in).nextLine();
                 System.out.print("Enter function id: ");
                 String newFunction = new Scanner(System.in).nextLine();
                controller.updateTerminal(newId, newLogo, newFunction);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteTerminal(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void StandartView() throws SQLException {
        System.out.println("\tYou choose table 'standart'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllStandart();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findStandartById(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter pay: ");
                Double pay = new Scanner(System.in).nextDouble();
                System.out.println("Enter date for Standart: ");
                String str = new Scanner(System.in).nextLine();
                Date date = Date.valueOf(str);
                controller.createStandart(id, pay, date);
                break;
            case "4":
            	System.out.print("Enter id: ");
                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter pay: ");
                Double newPay = new Scanner(System.in).nextDouble();
                System.out.println("Enter date for Standart: ");
                String newStr = new Scanner(System.in).nextLine();
                Date newDate = Date.valueOf(newStr);
                controller.updateStandart(newId, newPay, newDate);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteStandart(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void ServicedCompanyView() throws SQLException {
        System.out.println("\tYou choose table 'serviced_company'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllServicedCompany();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findServicedCompanyById(new Scanner(System.in).nextInt());
                break;
            case "3":
            	
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter email: ");
                String email = new Scanner(System.in).nextLine();
                System.out.print("Enter staff: ");
                Integer staff = new Scanner(System.in).nextInt();
                controller.createServicedCompany(id, name, email, staff);
                break;
            case "4":
            	System.out.print("Enter id: ");
                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String newName = new Scanner(System.in).nextLine();
                System.out.print("Enter email: ");
                String newEmail = new Scanner(System.in).nextLine();
                System.out.print("Enter staff: ");
                Integer newStaff = new Scanner(System.in).nextInt();

                controller.updateServicedCompany(newId, newName, newEmail, newStaff);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteServicedCompany(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void ServiceWorkView() throws SQLException {
        System.out.println("\tYou choose table 'service_work'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllServiceWork();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findByIdServiceWork(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter master: ");
                String master = new Scanner(System.in).nextLine();
                System.out.print("Enter priceOfMaster: ");
                Double priceOfMaster = new Scanner(System.in).nextDouble();
                System.out.print("Enter servicePrice: ");
                Double servicePrice = new Scanner(System.in).nextDouble();
                System.out.println("Enter tima for ServiceWorkt: ");
                String str = new Scanner(System.in).nextLine();
                Time time = Time.valueOf(str);
               
                controller.createServiceWork(id, master, priceOfMaster, servicePrice, time);
                break;
            case "4":
            	 System.out.print("Enter id: ");
                 Integer newId = new Scanner(System.in).nextInt();
                 System.out.print("Enter master: ");
                 String newMaster = new Scanner(System.in).nextLine();
                 System.out.print("Enter priceOfMaster: ");
                 Double newPriceOfMaster = new Scanner(System.in).nextDouble();
                 System.out.print("Enter servicePrice: ");
                 Double newServicePrice = new Scanner(System.in).nextDouble();
                 System.out.println("Enter tima for ServiceWorkt: ");
                 String newStr = new Scanner(System.in).nextLine();
                 Time newTime = Time.valueOf(newStr);

                controller.updateServiceWork(newId, newMaster, newPriceOfMaster, newServicePrice, newTime);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteServiceWork(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void ServiceWizardView() throws SQLException {
        System.out.println("\tYou choose table 'service_wizard'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllServiceWizard();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findByIdServiceWizard(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter firstName: ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.print("Enter secondName: ");
                String secondName = new Scanner(System.in).nextLine();
                controller.createServiceWizard(id, firstName, secondName);
                break;
            case "4":
            	System.out.print("Enter id: ");
                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter firstName: ");
                String newFirstName = new Scanner(System.in).nextLine();
                System.out.print("Enter secondName: ");
                String newSecondName = new Scanner(System.in).nextLine();
               
                controller.updateServiceWizard(newId, newFirstName, newSecondName);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteServiceWizard(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void ProvidedServicesView() throws SQLException {
        System.out.println("\tYou choose table 'provided_services'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllProvidedServices();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findProvidedServicesById(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter type: ");
                String type = new Scanner(System.in).nextLine();
               
                controller.createProvidedServices(id, type);
                break;
            case "4":
            	 System.out.print("Enter id: ");
                 Integer newId = new Scanner(System.in).nextInt();
                 System.out.print("Enter type: ");
                 String newType = new Scanner(System.in).nextLine();

                controller.updateProvidedServices(newId, newType);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteProvidedServices(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }


    private void OverhaulView() throws SQLException {
        System.out.println("\tYou choose table 'overhaul'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOverhaul();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findOverhaul(new Scanner(System.in).nextInt());
                break;
            case "3":

                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter changeDiscription: ");
                String changeDiscription = new Scanner(System.in).nextLine();
                System.out.print("Enter changeFunctions: ");
                String changeFunctions = new Scanner(System.in).nextLine();
                System.out.print("Enter changingParts: ");
                String changingParts = new Scanner(System.in).nextLine();
                System.out.println("Enter date for Overhaul: ");
                String str = new Scanner(System.in).nextLine();
                Date date = Date.valueOf(str);
                controller.createOverhaul(id, changeDiscription, changeFunctions, changingParts, date);
                break;
            case "4":
            	System.out.print("Enter id: ");
                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter changeDiscription: ");
                String newChangeDiscription = new Scanner(System.in).nextLine();
                System.out.print("Enter changeFunctions: ");
                String newChangeFunctions = new Scanner(System.in).nextLine();
                System.out.print("Enter changingParts: ");
                String newChangingParts = new Scanner(System.in).nextLine();
                System.out.println("Enter date for Overhaul: ");
                String newStr = new Scanner(System.in).nextLine();
                Date newDate = Date.valueOf(newStr);
                controller.updateOverhaul(newId, newChangeDiscription, newChangeFunctions, newChangingParts, newDate);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteOverhaul(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void InformationView() throws SQLException {
        System.out.println("\tYou choose table 'information'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllInformation();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findInformationById(new Scanner(System.in).nextInt());
                break;
            case "3":
            	
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter number: ");
                Integer number = new Scanner(System.in).nextInt();
                System.out.print("Enter details: ");
                String details = new Scanner(System.in).nextLine();
                System.out.println("Enter date for information: ");
                String str = new Scanner(System.in).nextLine();
                Date date = Date.valueOf(str);
                System.out.print("Enter gpsCoordinates: ");
                Double gpsCoordinates = new Scanner(System.in).nextDouble();
                controller.createInformation(id, number, details, date, gpsCoordinates);
                break;
            case "4":
            	System.out.print("Enter id: ");
                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter number: ");
                Integer newNumber = new Scanner(System.in).nextInt();
                System.out.print("Enter details: ");
                String newDetails = new Scanner(System.in).nextLine();
                System.out.println("Enter date for information: ");
                String newStr = new Scanner(System.in).nextLine();
                Date newDate = Date.valueOf(newStr);
                System.out.print("Enter gpsCoordinates: ");
                Double newGpsCoordinates = new Scanner(System.in).nextDouble();
               
                controller.updateInformation(newId, newNumber, newDetails, newDate, newGpsCoordinates);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteInformation(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }

    private void CollectinCahView() throws SQLException {
        System.out.println("\tYou choose table 'collectinCah'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllCollectinCah();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findCollectinCahById(new Scanner(System.in).nextInt());
                break;
            case "3":
            	
                System.out.print("Enter id: ");

                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter number: ");
                Double number = new Scanner(System.in).nextDouble();
                System.out.println("Enter date for collectinCah: ");
                String str = new Scanner(System.in).nextLine();
                Date date = Date.valueOf(str);
                System.out.println("Enter time for collectinCah: ");
                String str1 = new Scanner(System.in).nextLine();
                Time time = Time.valueOf(str1);
                controller.createCollectinCah(id, number, date, time);
                break;
            case "4":
            	 System.out.print("Enter id: ");

                 Integer newId = new Scanner(System.in).nextInt();
                 System.out.print("Enter number: ");
                 Double newNumber = new Scanner(System.in).nextDouble();
                 System.out.println("Enter date for collectinCah: ");
                 String newStr = new Scanner(System.in).nextLine();
                 Date newDate = Date.valueOf(newStr);
                 System.out.println("Enter time for collectinCah: ");
                 String newStr1 = new Scanner(System.in).nextLine();
                 Time newTime = Time.valueOf(newStr1);
                controller.updateCollectinCah(newId, newNumber, newDate, newTime);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCollectinCah(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }
    
    private void AddressView() throws SQLException {
        System.out.println("\tYou choose table 'address'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllAddress();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findAddressById(new Scanner(System.in).nextInt());
                break;
            case "3":
            	
                System.out.print("Enter id: ");

                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter street: ");
                String street = new Scanner(System.in).nextLine();
                System.out.print("Enter number: ");
                Integer number = new Scanner(System.in).nextInt();
                System.out.print("Enter city: ");
                String city = new Scanner(System.in).nextLine();
                System.out.print("Enter country: ");
                String country = new Scanner(System.in).nextLine();
                controller.createAddress(id, street, number, city, country);
                break;
            case "4":
            	System.out.print("Enter id: ");

                Integer newId = new Scanner(System.in).nextInt();
                System.out.print("Enter street: ");
                String newStreet = new Scanner(System.in).nextLine();
                System.out.print("Enter number: ");
                Integer newNumber = new Scanner(System.in).nextInt();
                System.out.print("Enter city: ");
                String newCity = new Scanner(System.in).nextLine();
                System.out.print("Enter country: ");
                String newCountry = new Scanner(System.in).nextLine();
                controller.updateAddress(newId, newStreet, newNumber, newCity, newCountry);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteAddress(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;

        }
    }
    private void cityView() throws SQLException {
        System.out.println("\tYou choose table 'city'");
        System.out.println(submenu);
        System.out.print("Select point: ");
    }
}