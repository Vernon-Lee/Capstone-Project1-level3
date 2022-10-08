import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Call the menu method
 */
public class PoisePMS {
    /**
     * main method
     *
     * @param args string keys
     * @throws IOException input mismatch
     */
    public static void main(String[] args) throws IOException {
        menu();
    }

    /**
     * contains the methods for the project
     *
     * @throws IOException if user gives incorrect input
     */
    // menu
    private static void menu() throws IOException {
        // main menu
        Scanner input = new Scanner(System.in);
        System.out.println("Enter one of the options below: ");
        System.out.println("1 - Capture Project Details");
        System.out.println("2 - Capture Contractor Details");
        System.out.println("3 - Change project due date");
        System.out.println("4 - Change total amount of fee paid to date");
        System.out.println("5 - Update a contractor's contact details");
        System.out.println("6 - Finalise a project");
        System.out.println("7 - Generate invoice");
        System.out.println("8 - File statistics");
        System.out.println("9 - Exit");
        try {
            //ask user to give input
            System.out.print("\nPlease enter option here: ");
            int menuNum = input.nextInt();
            if (menuNum == 1) {
                // call 'projectObject' method
                projectObject();
            } else if (menuNum == 2) {
                // call 'changeDueDate' method
                personObjectDetail();
            } else if (menuNum == 3) {
                // call 'changeDueDate' method
                changeDueDate();
            } else if (menuNum == 4) {
                // call 'changeFeePaid' method
                changeFeePaid();
            } else if (menuNum == 5) {
                // call 'contactDetails' method
                contactDetails();
            } else if (menuNum == 6) {
                // call 'finalized' method
                finalise();
            } else if (menuNum == 7) {
                invoice();
            } else if (menuNum == 8) {
                fileStatistics();
            } else
                System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("That input is not valid, input a integer.");
        }
    }

    /**
     * create a new project
     *
     * @throws IOException if user gives incorrect input
     */
    // create project object
    public static void projectObject() throws IOException {
        // create customer object for project
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            System.out.println("\nExisting customer objects");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT customerId,name, surname, phoneNumber, email, address FROM customer");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("customerId") + ", " + results.getString("name")
                        + ", " + results.getString("surname") + ", " + results.getString("phoneNumber")
                        + ", " + results.getString("email") + ", " + results.getString("address"));
            }
            System.out.println("""
                    Before you can create a project you first need to create the following:
                    1) Customer object
                    2) Architect object
                    3) Contractor object""");
            System.out.println("\nCreate new customer object for project");
            try {
                // Allow user to give input
                Scanner scanner = new Scanner(System.in);
                Scanner id = new Scanner(System.in);
                System.out.print("Customer Id: ");
                int customerId = id.nextInt();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Surname: ");
                String surname = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                // create project object
                projectPerson personObj = new projectPerson();
                personObj.setPersonId(customerId);
                personObj.setPersonName(name);
                personObj.setPersonSurname(surname);
                personObj.setPersonTelNum(phoneNumber);
                personObj.setPersonEmail(email);
                personObj.setPersonAddress(address);
                // add a book
                rowsAffected = statement.executeUpdate("INSERT INTO customer VALUE('" + personObj.getPersonId() + "','" + personObj.getPersonName() + "','" + personObj.getPersonSurname() + "','" + personObj.getPersonTelNum() + "','" + personObj.getPersonEmail() + "','" + personObj.getPersonAddress() + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows added.");
                String string = "SELECT customerId,name, surname, phoneNumber, email, address FROM customer";
                printFromCustomerTable(statement, string);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                e.printStackTrace();
            }
            // create architect ID
            System.out.println("Existing architect objects");
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT architectId,name, surname, phoneNumber, email, address FROM architect");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("architectId") + ", " + results.getString("name")
                        + ", " + results.getString("surname") + ", " + results.getString("phoneNumber")
                        + ", " + results.getString("email") + ", " + results.getString("address"));
            }
            System.out.println("\nCreate new architect object for project");
            try {
                // Allow user to give input
                Scanner scanner = new Scanner(System.in);
                Scanner id = new Scanner(System.in);
                System.out.print("Architect Id: ");
                int architectID = id.nextInt();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Surname: ");
                String surname = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                // create project object
                projectPerson personObj = new projectPerson();
                personObj.setPersonId(architectID);
                personObj.setPersonName(name);
                personObj.setPersonSurname(surname);
                personObj.setPersonTelNum(phoneNumber);
                personObj.setPersonEmail(email);
                personObj.setPersonAddress(address);
                // add a book
                rowsAffected = statement.executeUpdate("INSERT INTO architect VALUE('" + personObj.getPersonId() + "','" + personObj.getPersonName() + "','" + personObj.getPersonSurname() + "','" + personObj.getPersonTelNum() + "','" + personObj.getPersonEmail() + "','" + personObj.getPersonAddress() + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows added.");
                String string = "SELECT architectId, name, surname, phoneNumber, email, address FROM architect";
                printFromArchitectTable(statement, string);
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
            // create contractor ID
            System.out.println("Existing contractor objects");
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT contractorId,name, surname, phoneNumber, email, address FROM structural_engineer");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("contractorId") + ", " + results.getString("name")
                        + ", " + results.getString("surname") + ", " + results.getString("phoneNumber")
                        + ", " + results.getString("email") + ", " + results.getString("address"));
            }
            System.out.println("\nCreate new contractor object for project");
            try {
                // Allow user to give input
                Scanner scanner = new Scanner(System.in);
                Scanner id = new Scanner(System.in);
                System.out.print("Contractor Id: ");
                int contractorId = id.nextInt();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Surname: ");
                String surname = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                // create project object
                projectPerson personObj = new projectPerson();
                personObj.setPersonId(contractorId);
                personObj.setPersonName(name);
                personObj.setPersonSurname(surname);
                personObj.setPersonTelNum(phoneNumber);
                personObj.setPersonEmail(email);
                personObj.setPersonAddress(address);
                // add a book
                rowsAffected = statement.executeUpdate("INSERT INTO structural_engineer VALUE('" + personObj.getPersonId() + "','" + personObj.getPersonName() + "','" + personObj.getPersonSurname() + "','" + personObj.getPersonTelNum() + "','" + personObj.getPersonEmail() + "','" + personObj.getPersonAddress() + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows added.");
                String string = "SELECT contractorId, name, surname, phoneNumber, email, address FROM structural_engineer";
                printFromContractorTable(statement, string);
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
            System.out.println("Existing project objects");
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, " +
                    "totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                        + ", " + results.getString("buildingType") + ", " + results.getString("address")
                        + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                        + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                        + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                        + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                        + ", " + results.getInt("contractorId"));
            }
            try {
                // create project
                System.out.println("\nCreate a new project");
                // Allow user to give input
                Scanner scanner = new Scanner(System.in);
                Scanner number = new Scanner(System.in);
                System.out.print("Project number: ");
                int num = number.nextInt();
                System.out.print("Project name: ");
                String projectName = scanner.nextLine();
                System.out.print("Type of building being designed: ");
                String buildingType = scanner.nextLine();
                System.out.print("Address for the project: ");
                String projectAddress = scanner.nextLine();
                System.out.print("ERF number: ");
                String ERFNumber = scanner.nextLine();
                System.out.print("Total fee being charged: ");
                long totFee = scanner.nextLong();
                System.out.print("Total amount paid: ");
                long totPaid = scanner.nextLong();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                System.out.println("Project start date: " + dateFormat.format(date));
                Scanner input = new Scanner(System.in);
                System.out.print("Deadline for the project(yyyy-MM-dd): ");
                String deadline = input.nextLine();
                System.out.print("Project completed(Yes/No): ");
                String complete = input.nextLine();
                System.out.print("Input Id of customer you created for this project: ");
                int customerId = number.nextInt();
                System.out.print("Input Id of architect you created for this project: ");
                int architectId = number.nextInt();
                System.out.print("Input Id of contractor you created for this project: ");
                int contractorId = number.nextInt();
                // create project object
                projectDetail projectObj = new projectDetail();
                projectObj.setNumber(num);
                projectObj.setName(projectName);
                projectObj.setBuildingType(buildingType);
                projectObj.setAddress(projectAddress);
                projectObj.setERFNumber(ERFNumber);
                projectObj.setTotFee(totFee);
                projectObj.setTotPaid(totPaid);
                projectObj.setStartDate(dateFormat.format(date));
                projectObj.setDeadline(deadline);
                projectObj.setComplete(complete);
                projectObj.setCustomerId(customerId);
                projectObj.setArchitectId(architectId);
                projectObj.setContractorId(contractorId);
                // add a book
                rowsAffected = statement.executeUpdate("INSERT INTO project VALUE('" + projectObj.getNumber() +
                        "','" + projectObj.getName() + "','" + projectObj.getBuildingType() + "','" + projectObj.getAddress()
                        + "','" + projectObj.getERFNumber() + "','" + projectObj.getTotFee() + "','" + projectObj.getTotPaid()
                        + "','" + projectObj.getStartDate() + "','" + projectObj.getDeadline() + "','" + projectObj.getComplete()
                        + "','" + projectObj.getCustomerId() + "','" + projectObj.getArchitectId() + "','"
                        + projectObj.getContractorId() + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows added.");
                String tableString = "SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid, startDate, Deadline, Complete, customerId,architectId,contractorId FROM project";
                printFromProjectTable(statement, tableString);
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
            // close connections
            results.close();
            connection.close();
            statement.close();

            // allow user to return to menu
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("\nDo you wish to return to the main menu? ");
                System.out.print("Input 'Yes' or 'No': ");
                String inputUser = scanner1.nextLine().toLowerCase();
                if (inputUser.equals("yes")) {
                    System.out.println();
                    menu();
                    // allow user to exit program
                } else if (inputUser.equals("no")) {
                    System.out.println("Existing program...");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * create new person object details
     *
     * @throws IOException if menu gives error
     */
    public static void personObjectDetail() throws IOException {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            System.out.println("\nExisting projects:");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT contractorId,name, surname, phoneNumber, email, address FROM structural_engineer");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("contractorId") + ", " + results.getString("name") + ", " + results.getString("surname")
                        + ", " + results.getString("phoneNumber") + ", " + results.getString("email")
                        + ", " + results.getString("address"));
            }
            try {
                // Allow user to give input
                System.out.println("\nCreate new Contractor object");
                Scanner scanner = new Scanner(System.in);
                Scanner num = new Scanner(System.in);
                System.out.print("ContractorId: ");
                int contractorId = num.nextInt();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Surname: ");
                String surname = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                // create project object
                projectPerson personObj = new projectPerson();
                personObj.setPersonId(contractorId);
                personObj.setPersonName(name);
                personObj.setPersonSurname(surname);
                personObj.setPersonTelNum(phoneNumber);
                personObj.setPersonEmail(email);
                personObj.setPersonAddress(address);
                // add a book
                rowsAffected = statement.executeUpdate("INSERT INTO structural_engineer VALUE('" + personObj.getPersonId() + "','" + personObj.getPersonName() +
                        "','" + personObj.getPersonSurname() + "','" + personObj.getPersonTelNum() + "','" + personObj.getPersonEmail()
                        + "','" + personObj.getPersonAddress() + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows added.");
                String string = "SELECT contractorId, name, surname, phoneNumber, email, address FROM structural_engineer";
                printFromContractorTable(statement, string);
                // close connections
                results.close();
                connection.close();
                statement.close();
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // allow user to return to menu
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("\nDo you wish to return to the main menu? ");
            System.out.print("Input 'Yes' or 'No': ");
            String inputUser = scanner1.nextLine().toLowerCase();
            if (inputUser.equals("yes")) {
                System.out.println();
                menu();
                // allow user to exit program
            } else if (inputUser.equals("no")) {
                System.out.println("Existing program...");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nThat is a invalid input.");
        }
    }

    /**
     * change due date of a project
     *
     * @throws IOException if user gives incorrect input
     */
    // Change the due date of the project
    public static void changeDueDate() throws IOException {
        // display all data in table
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber," +
                    " totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                        + ", " + results.getString("buildingType") + ", " + results.getString("address")
                        + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                        + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                        + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                        + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                        + ", " + results.getInt("contractorId"));
            }
            try {
                // allow user to select the record they wish to update
                System.out.println("\nEnter project number to select project: ");
                Scanner num = new Scanner(System.in);
                Scanner userInput = new Scanner(System.in);
                System.out.print("Project number: ");
                int projectNum = num.nextInt();
                // search for record
                results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber" +
                        ", totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project WHERE projectNumber=('" + projectNum + "')");
                System.out.println("\nRecord you selected to update: ");
                // loop over result and display record
                while (results.next()) {
                    System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                            + ", " + results.getString("buildingType") + ", " + results.getString("address")
                            + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                            + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                            + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                            + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                            + ", " + results.getInt("contractorId"));
                    System.out.println("Current due date: " + results.getDate("Deadline"));
                }
                // allow user to change date
                System.out.print("Change record date(yyyy-MM-dd): ");
                String date = userInput.nextLine();
                rowsAffected = statement.executeUpdate("UPDATE project SET Deadline=('" + date + "') WHERE projectNumber=('" + projectNum + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                String string = "SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid," +
                        " startDate, Deadline, Complete,customerId,architectId,contractorId FROM project";
                printFromProjectTable(statement, string);
                // close connections
                results.close();
                connection.close();
                statement.close();
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }// allow user to return to menu
        try {
            // allow user to return to menu
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("\nDo you wish to return to the main menu? ");
            System.out.print("Input 'Yes' or 'No': ");
            String inputUser = scanner1.nextLine().toLowerCase();
            if (inputUser.equals("yes")) {
                System.out.println();
                menu();
                // allow user to exit program
            } else if (inputUser.equals("no")) {
                System.out.println("Existing program...");
                System.exit(0);
            }
        } catch (InputMismatchException i) {
            System.out.println("\nThat is a invalid input.");
        }
    }

    /**
     * change the amount paid for project
     *
     * @throws IOException if user gives incorrect input
     */
    // Change the total amount of the fee paid
    public static void changeFeePaid() throws IOException {
        // display all data in table
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber," +
                    " totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                        + ", " + results.getString("buildingType") + ", " + results.getString("address")
                        + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                        + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                        + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                        + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                        + ", " + results.getInt("contractorId"));
            }
            try {
                // allow user to select the record they wish to update
                System.out.println("\nEnter project number to select project: ");
                Scanner num = new Scanner(System.in);
                Scanner userInput = new Scanner(System.in);
                System.out.print("Project number: ");
                int projectNum = num.nextInt();
                // search for record
                results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber" +
                        ", totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project WHERE projectNumber=('" + projectNum + "')");
                System.out.println("\nRecord you selected to update:");
                // loop over result and display record
                while (results.next()) {
                    System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                            + ", " + results.getString("buildingType") + ", " + results.getString("address")
                            + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                            + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                            + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                            + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                            + ", " + results.getInt("contractorId"));
                    System.out.println("Total fee charged: " + results.getLong("totFee"));
                    System.out.println("Total paid until now: " + results.getLong("totPaid"));
                    System.out.println("Outstanding amount: " + (results.getLong("totFee") - results.getLong("totPaid")));
                }
                // allow user to change date
                System.out.print("Change total amount paid: ");
                String totPaid = userInput.nextLine();
                rowsAffected = statement.executeUpdate("UPDATE project SET totPaid=('" + totPaid + "') WHERE projectNumber=('" + projectNum + "')");
                System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                String string = "SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid, " + "startDate, Deadline, Complete,customerId,architectId,contractorId FROM project";
                printFromProjectTable(statement, string);
                // close connections
                results.close();
                connection.close();
                statement.close();
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // allow user to return to menu
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("\nDo you wish to return to the main menu? ");
            System.out.print("Input 'Yes' or 'No': ");
            String inputUser = scanner1.nextLine().toLowerCase();
            if (inputUser.equals("yes")) {
                System.out.println();
                menu();
                // allow user to exit program
            } else if (inputUser.equals("no")) {
                System.out.println("Existing program...");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nThat is a invalid input.");
        }
    }

    /**
     * change contact details
     *
     * @throws IOException if user gives incorrect input
     */
    // Update contractor's contact details
    public static void contactDetails() throws IOException {
        // display all data in table
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            System.out.println("\nContractor objects in database:");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT contractorId,name, surname, phoneNumber,email, address FROM structural_engineer");
            // check if table is empty
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("contractorId") + ", " + results.getString("name") + ", " + results.getString("surname")
                        + ", " + results.getString("phoneNumber") + ", " + results.getString("email") + ", " + results.getString("address"));
            }
            // ask if user has created contractor detail
            Scanner scan = new Scanner(System.in);
            System.out.print("\nIs the contractor object you wish to update in the database(Yes/No)?");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("yes")) {
                try {
                    // allow user to select the record they wish to update
                    System.out.println("\nUpdate contractors phone number,email and address details:");
                    System.out.println("Enter contractor name or surname to select contractor: ");
                    Scanner userInput = new Scanner(System.in);
                    System.out.print("Name: ");
                    String fName = userInput.nextLine();
                    System.out.print("Surname: ");
                    String sName = userInput.nextLine();
                    // search for record
                    results = statement.executeQuery("SELECT contractorId,name, surname, phoneNumber,email, address FROM structural_engineer" +
                            " WHERE name=('" + fName + "') OR surname=('" + sName + "')");
                    System.out.println("\nRecord you selected to update");
                    // loop over result and display record
                    while (results.next()) {
                        System.out.println(results.getInt("contractorId") + ", " + results.getString("name") + ", " + results.getString("surname")
                                + ", " + results.getString("phoneNumber") + ", " + results.getString("email") + ", " + results.getString("address"));
                        System.out.println("\nCurrent phone number: " + results.getString("phoneNumber"));
                        System.out.println("Current email address: " + results.getString("email"));
                        System.out.println("Current address: " + results.getString("address"));
                    }
                    // allow user to change phone number
                    System.out.println("\nInput the following");
                    System.out.print("New phone number: ");
                    String phoneNum = userInput.nextLine();
                    System.out.print("New email: ");
                    String email = userInput.nextLine();
                    System.out.print("New address: ");
                    String address = userInput.nextLine();
                    rowsAffected = statement.executeUpdate("UPDATE structural_engineer SET phoneNumber=('" + phoneNum + "')" +
                            ",email=('" + email + "'),address=('" + address + "') WHERE name=('" + fName + "') OR surname=('" + sName + "')");
                    System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                    String string = "SELECT contractorId,name, surname, phoneNumber,email, address FROM structural_engineer";
                    printFromContractorTable(statement, string);
                    // close connections
                    results.close();
                    connection.close();
                    statement.close();
                    try {
                        // allow user to return to menu
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("\nDo you wish to return to the main menu? ");
                        System.out.print("Input 'Yes' or 'No': ");
                        String inputUser = scanner1.nextLine().toLowerCase();
                        if (inputUser.equals("yes")) {
                            menu();
                            // allow user to exit program
                        } else if (inputUser.equals("no")) {
                            System.out.println("Existing program...");
                            System.exit(0);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nThat is a invalid input.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nThat is a invalid input.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (input.equals("no")) {
                System.out.println("Please provide contractor details");
                personObjectDetail();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * allows user to finalise project
     *
     * @throws IOException if user gives incorrect input
     */
    // Finalise the project
    public static void finalise() throws IOException {
        // display records
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, " +
                    "totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                        + ", " + results.getString("buildingType") + ", " + results.getString("address")
                        + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                        + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                        + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                        + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                        + ", " + results.getInt("contractorId"));
            }
            try {
                // allow user to select the record they wish to update
                System.out.println("\nEnter project number to select project: ");
                Scanner num = new Scanner(System.in);
                Scanner userInput = new Scanner(System.in);
                System.out.print("Project number: ");
                int projectNum = num.nextInt();
                // search for record
                results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber" +
                        ", totFee, totPaid, startDate, Deadline, Complete,customerId, architectId, contractorId FROM project WHERE projectNumber=('" + projectNum + "')");
                System.out.println("Record you selected to update");
                // loop over result and display record
                while (results.next()) {
                    System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                            + ", " + results.getString("buildingType") + ", " + results.getString("address")
                            + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                            + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                            + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                            + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                            + ", " + results.getInt("contractorId"));
                    System.out.println("Total cost of project: " + results.getLong("totFee"));
                    System.out.println("Total fee paid for project: " + results.getLong("totPaid"));
                    System.out.print("Outstanding amount: ");
                    System.out.println(results.getLong("totFee") - results.getLong("totPaid"));
                    System.out.println("Is project complete: " + results.getString("Complete"));

                    long outstandingFee = results.getLong("totFee") - results.getLong("totPaid");
                    if (outstandingFee == 0) {
                        System.out.println("No invoice needed");
                        // check completion status
                        if (results.getString("Complete").equals("Yes")) {
                            String string = "SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid, startDate, Deadline, Complete, customerId,architectId,contractorId FROM project";
                            System.out.println();
                            printFromProjectTable(statement, string);
                            // close connections
                            results.close();
                            connection.close();
                            statement.close();
                            try {
                                // allow user to return to menu
                                Scanner scanner1 = new Scanner(System.in);
                                System.out.println("\nDo you wish to return to the main menu? ");
                                System.out.print("Input 'Yes' or 'No': ");
                                String inputUser = scanner1.nextLine().toLowerCase();
                                if (inputUser.equals("yes")) {
                                    menu();
                                    // allow user to exit program
                                } else if (inputUser.equals("no")) {
                                    System.out.println("Existing program...");
                                    System.exit(0);
                                }
                            } catch (InputMismatchException i) {
                                System.out.println("\nThat is a invalid input.");
                            }
                        }
                    } else {
                        try {
                            // change tot amount paid

                            System.out.print("\nChange total amount paid: ");
                            long totPaid = num.nextLong();
                            // change completion status
                            System.out.print("Project Complete(Yes\\No): ");
                            String complete = userInput.nextLine();
                            rowsAffected = statement.executeUpdate("UPDATE project SET totPaid=('" + totPaid + "'), " +
                                    "Complete=('" + complete + "') WHERE projectNumber=('" + projectNum + "')");
                            System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                            String string = "SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid, startDate, Deadline, Complete, customerId,architectId,contractorId FROM project";
                            System.out.println();
                            printFromProjectTable(statement, string);
                            // close connections
                            results.close();
                            connection.close();
                            statement.close();
                        } catch (InputMismatchException e) {
                            System.out.println("\nThat is a invalid input.");
                        }
                    }
                    try {
                        // allow user to return to menu
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("\nDo you wish to return to the main menu? ");
                        System.out.print("Input 'Yes' or 'No': ");
                        String inputUser = scanner1.nextLine().toLowerCase();
                        if (inputUser.equals("yes")) {
                            menu();
                            // allow user to exit program
                        } else if (inputUser.equals("no")) {
                            System.out.println("Existing program...");
                            System.exit(0);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nThat is a invalid input.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * generate invoice
     *
     * @throws IOException exception handling
     */
    public static void invoice() throws IOException {
        // display records
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            // generate invoice
            try {
                // runs SELECT statement and return results
                // loop over results and print them
                // display all projects with outstanding fee
                System.out.println("\nDisplay all projects that has outstanding fee:");
                resultSet = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, " +
                        "erfNumber, totFee, totPaid, startDate, Deadline, Complete,customerId,architectId,contractorId FROM project WHERE totFee!=totPaid");
                // loop over results and print them
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("projectNumber") + ", " + resultSet.getString("projectName")
                            + ", " + resultSet.getString("buildingType") + ", " + resultSet.getString("address")
                            + ", " + resultSet.getString("erfNumber") + ", " + resultSet.getLong("totFee")
                            + ", " + resultSet.getLong("totPaid") + ", " + ", " + resultSet.getDate("startDate")
                            + ", " + resultSet.getDate("Deadline") + ", " + resultSet.getString("Complete")
                            + ", " + resultSet.getInt("customerId") + ", " + resultSet.getInt("architectId")
                            + ", " + resultSet.getInt("contractorId"));
                }
                try {
                    // get invoice for specific project
                    System.out.println("\nEnter project number to select project: ");
                    Scanner number = new Scanner(System.in);
                    System.out.print("Project number: ");
                    int projNum = number.nextInt();
                    //invoice for customer
                    System.out.println("\nCustomers Invoice");
                    resultSet = statement.executeQuery("SELECT projectNumber,totFee, totPaid, customer.name, customer.surname, customer.phoneNumber " +
                            "From project, customer WHERE projectNumber=('" + projNum + "') AND project.customerId = customer.customerId AND project.customerId >= customer.customerId");
                    while (resultSet.next()) {
                        System.out.println("Name: " + resultSet.getString("name"));
                        System.out.println("Surname: " + resultSet.getString("surname"));
                        System.out.println("Contact Details: " + resultSet.getString("phoneNumber"));
                        System.out.println("Outstanding Amount: " + (resultSet.getLong("totFee") - resultSet.getLong("totPaid")));
                    }
                    // close connections
                    resultSet.close();
                    connection.close();
                    statement.close();
                } catch (InputMismatchException e) {
                    System.out.println("\nThat is a invalid input.");
                }
                try {
                    // allow user to return to menu
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("\nDo you wish to return to the main menu? ");
                    System.out.print("Input 'Yes' or 'No': ");
                    String inputUser = scanner1.nextLine().toLowerCase();
                    if (inputUser.equals("yes")) {
                        menu();
                        // allow user to exit program
                    } else if (inputUser.equals("no")) {
                        System.out.println("Existing program...");
                        System.exit(0);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nThat is a invalid input.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * allows user to see statistics of all projects
     *
     * @throws IOException if user gives incorrect input
     */
    // Read projects from existing file
    // shows all incomplete projects
    // shows all projects past due date
    public static void fileStatistics() throws IOException {
        // display all records
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms",
                    "root",
                    "220601042002");
            System.out.println("Connection established.");
            // create direct line to database for running queries
            Statement statement = connection.createStatement();
            ResultSet results;
            // runs SELECT statement and return results
            results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, totFee, totPaid, startDate, Deadline, Complete FROM project");
            // loop over results and print them
            while (results.next()) {
                System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                        + ", " + results.getString("buildingType") + ", " + results.getString("address")
                        + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                        + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                        + ", " + results.getDate("Deadline") + ", " + results.getString("Complete"));
            }
            try {
                // user can input if they want to see incomplete projects or not
                Scanner input = new Scanner(System.in);
                System.out.print("\nDo you wish to see incomplete projects(Yes/No)? ");
                String answer = input.nextLine();
                if (answer.equals("Yes")) {
                    System.out.println("All projects that need to be completed:");
                    results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, " +
                            "erfNumber, totFee, totPaid, startDate, Deadline, Complete FROM project WHERE Complete='No'");
                    // loop over results and print them
                    while (results.next()) {
                        System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                                + ", " + results.getString("buildingType") + ", " + results.getString("address")
                                + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                                + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                                + ", " + results.getDate("Deadline") + ", " + results.getString("Complete"));
                    }
                }
                System.out.print("\nDo you wish to see projects past due date(Yes/No)? ");
                String userInput = input.nextLine().toLowerCase();
                if (userInput.equals("yes")) {
                    System.out.println("All projects past due date");
                    results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, " +
                            "erfNumber, totFee, totPaid, startDate, Deadline, Complete FROM project WHERE Complete='No' AND startDate>Deadline");
                    // loop over results and print them
                    while (results.next()) {
                        System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                                + ", " + results.getString("buildingType") + ", " + results.getString("address")
                                + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                                + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                                + ", " + results.getDate("Deadline") + ", " + results.getString("Complete"));
                    }
                }
                // close connections
                results.close();
                connection.close();
                statement.close();

            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
            try {
                // allow user to return to menu
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("\nDo you wish to return to the main menu? ");
                System.out.print("Input 'Yes' or 'No': ");
                String inputUser = scanner1.nextLine().toLowerCase();
                if (inputUser.equals("yes")) {
                    menu();
                    // allow user to exit program
                } else if (inputUser.equals("no")) {
                    System.out.println("Existing program...");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nThat is a invalid input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * print information from project table in database
     *
     * @param statement dbms method to execute query
     * @param string    returns details as string
     * @throws SQLException if data base does not exits
     */

    public static void printFromProjectTable(Statement statement, String string) throws SQLException {

        ResultSet results = statement.executeQuery(string);
        // loop over results and print them
        while (results.next()) {
            System.out.println(results.getInt("projectNumber") + ", " + results.getString("projectName")
                    + ", " + results.getString("buildingType") + ", " + results.getString("address")
                    + ", " + results.getString("erfNumber") + ", " + results.getLong("totFee")
                    + ", " + results.getLong("totPaid") + ", " + ", " + results.getDate("startDate")
                    + ", " + results.getDate("Deadline") + ", " + results.getString("Complete")
                    + ", " + results.getInt("customerId") + ", " + results.getInt("architectId")
                    + ", " + results.getInt("contractorId"));
        }

    }

    /**
     * print information from engineer table in database
     *
     * @param statement dbms method to execute query
     * @param string    returns details as string
     * @throws SQLException if data base does not exits
     */
    public static void printFromCustomerTable(Statement statement, String string) throws SQLException {
        ResultSet results = statement.executeQuery(string);
        // loop over results and print them
        while (results.next()) {
            System.out.println(results.getInt("customerId") + ", " + results.getString("name") + ", " + results.getString("surname")
                    + ", " + results.getString("phoneNumber") + ", " + results.getString("address"));
        }
    }

    /**
     * print information from architect table
     *
     * @param statement dbms method to execute query
     * @param string    returns details as string
     * @throws SQLException if data base does not exits
     */
    public static void printFromArchitectTable(Statement statement, String string) throws SQLException {
        ResultSet results = statement.executeQuery(string);
        // loop over results and print them
        while (results.next()) {
            System.out.println(results.getInt("architectId") + ", " + results.getString("name") + ", " + results.getString("surname")
                    + ", " + results.getString("phoneNumber") + ", " + results.getString("address"));
        }
    }

    /**
     * print information from structural_engineer table
     *
     * @param statement dbms method to execute query
     * @param string    returns details as string
     * @throws SQLException if data base does not exits
     */
    public static void printFromContractorTable(Statement statement, String string) throws SQLException {
        ResultSet results = statement.executeQuery(string);
        // loop over results and print them
        while (results.next()) {
            System.out.println(results.getInt("contractorId") + ", " + results.getString("name") + ", " + results.getString("surname")
                    + ", " + results.getString("phoneNumber") + ", " + results.getString("email") + ", " + results.getString("address"));
        }
    }

}

