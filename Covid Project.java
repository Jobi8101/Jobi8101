package CarRentalBusiness;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johnson
 */
public class NewMain {

    public static EmployeeList objEmployeeList = new EmployeeList();
    public static UserAccountList objUserAccountList = new UserAccountList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option;

        option = mainMenuScreen();

        while (option != 0) {

            switch (option) {

                case 1:
                    BackEndManagementScreen();
                    
                    break;
                case 2:
                    startRetailPointOfSales();
                    break;

                default:
                    System.out.println("Incorrect entry, please try again");
                    break;
            } 
            option = mainMenuScreen();

        } 

        System.out.println("    Exiting Program    ");
        System.out.println();

    }
        
        public static int mainMenuScreen() {
        
        Scanner keyboardInput = new Scanner(System.in);
        int option;

        System.out.println();
        System.out.println("Welcome to the Small Business Application");
        System.out.println();
        System.out.println("1    Back-end Magagement Screen");
        System.out.println("2    Retail Point Of Sales Screen");
        System.out.println("0    Exit");
        System.out.println();
        System.out.println();
        System.out.println("Please select a menu option (1, 2 or 0)");

        option = keyboardInput.nextInt();

        System.out.println();

        return option;
    }
        
        public static void BackEndManagementScreen(){
            int option;
            
            option = BackEndScreen();
            
            while (option !=0)
            {
                switch (option){
                    case 1:
                        StartUserAccountManagement();
                        break;
                    case 2:
                        StartEmployeeManagement();
                        break;
                        
                    default: System.out.println("Incorrect input, Please try again");
                    break;                                                           
                            
                }
                option = BackEndScreen();
            }
                    
        }            
                    
        public static int BackEndScreen(){
            Scanner keyboardInput = new Scanner (System.in);
            int option;
            
             System.out.println("Welcome to the Back-end Maintenance"
                     + "Management Portal");
              System.out.println();
              System.out.println("1.    User Account Management");
              System.out.println("2.    Employee Management");
              System.out.println("0.    Exit & Save");
              System.out.println();
              System.out.println("Please select a menu option(1,2 or 0)");
              
              option = keyboardInput.nextInt();

        System.out.println();

        
        return option;
                    
        }
        
        public static int UserAccountManagement() {       
        Scanner keyboardInput = new Scanner(System.in);
        int option;

        System.out.println();
        System.out.println("     Welcome to the User Account Management Portal     ");
        System.out.println();
        System.out.println("1-----------Search for a User Account Record");
        System.out.println("2-----------Add a New User Account Record");
        System.out.println("3-----------Edit a User Account Record");
        System.out.println("4-----------Remove a User Account Record");
        System.out.println("0-----------Exit & Save (Back to Main Screen)");
        System.out.println();
        System.out.println();
        System.out.println("Please select a menu option (1,2,3,4,or 0)");
        option = keyboardInput.nextInt();

        System.out.println();
        return option;
        }
        public static void StartUserAccountManagement() {
        int option;

        try {
            objUserAccountList.load();

            option = UserAccountManagement();

            while (option != 0) {

                switch (option) {

                    case 1:
                        getUserAccountRecord();
                        break;
                    case 2:
                        addUserAccountRecord();
                        break;
                    case 3:
                        editUserAccountRecord();
                        break;
                    case 4:
                        removeUserAccountRecord();
                        break;

                    default:
                        System.out.println("Incorrect entry, please try again");
                        break;
                }
                option = UserAccountManagement();

            }

            System.out.println("Exiting User Account Management Program.............");
            System.out.println();

            objUserAccountList.save();
            objUserAccountList.clear();
               
        }        
       catch (Exception objE) {     
        System.out.println(objE.toString());           
  
        }        
    }
        public static void getUserAccountRecord() {
        
        Scanner keyboardInput = new Scanner(System.in);

        try {
            UserAccount objUserAccount;
            String userid;

            System.out.println("       Search User Account Screen        ");

 
            System.out.println("Please enter User Acount ID number");
            userid = keyboardInput.nextLine();

            objUserAccount = objUserAccountList.search(userid);

            if (objUserAccount != null) {
                System.out.println();
                System.out.println("The User Account information: ");
                System.out.println("User Account ID Number = " + objUserAccount.getUserAccountID());
                System.out.println("User Account Name = " + objUserAccount.getUserName());            
                System.out.println("User Account Email = " + objUserAccount.getEmail());
            } else {
                System.out.println();
                System.out.println("User Account not found!");
            }        
        
        
        }
        catch (Exception objE) {

            System.out.println(objE.toString());           
        }       

    }
        public static void addUserAccountRecord() {
        try {        
           
            Scanner keyboardInput = new Scanner(System.in);

            String userID,username,email;
            boolean success;

            System.out.println("          Adding User Account Screen         ");

            System.out.println("Please enter NEW User Account ID number");
            userID = keyboardInput.nextLine();


            System.out.println("Please enter NEW User Account Name");
            username = keyboardInput.nextLine();
            
            
            System.out.println("Please enter NEW User Account email");
            email = keyboardInput.nextLine();            

            success = objUserAccountList.add(userID, username, email);

            if (success) {
                System.out.println();
                System.out.println("User Account Added");
            } else {
                System.out.println();
                System.out.println("No available space!");
            }
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }  
    }
        public static void editUserAccountRecord() {
        try {        
 
            Scanner keyboardInput = new Scanner(System.in);

            String userID, username, email;
            boolean success;

            System.out.println("           Editing User Account Screen         ");

            System.out.println("Please enter the User Account ID you wish to edit");
            userID = keyboardInput.nextLine();


            System.out.println("Please enter NEW User Account Name you wish to edit");
            username = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW User Account email you wish to edit");
            email = keyboardInput.nextLine();              

            
            success = objUserAccountList.edit( userID, username, email);

            if (success) {
                System.out.println();
                System.out.println("User Account record have been edited successfully");
            } else {
                System.out.println();
                System.out.println("Customer not found!");
            }
        }
        catch (Exception objE) { 
            System.out.println(objE.toString());           
        }  
    }
        public static void removeUserAccountRecord() {
        try {
            Scanner keyboardInput = new Scanner(System.in);

            String userID;
            boolean success;

            System.out.println("          Deleting User Account Screen          ");

            System.out.println("Please enter User Account ID you wish to delete");
            userID = keyboardInput.nextLine();

            success = objUserAccountList.remove(userID);

            if (success) {
                System.out.println();
                System.out.println("User Account deleted");
            } else {
                System.out.println();
                System.out.println("USer Account not found!");
            }
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }  
        
        }
        
        public static int EmployeeManagement() {
        
        Scanner keyboardInput = new Scanner(System.in);
        int option;

        System.out.println();
        System.out.println("      Welcome to the Employee Management Portal    ");

        System.out.println();
        System.out.println("1-----------Search for a Employee Record ");
        System.out.println("2-----------Add a Employee Record");
        System.out.println("3-----------Edit a Employee Record");
        System.out.println("4-----------Remove a Customer Record");
        System.out.println("5-----------Print Employee Record");
        System.out.println("6-----------Print all Employee Records");
        System.out.println("0-----------Exit & Save (Save & return to BAck-end Mgt Screen)");
        System.out.println();
        System.out.println("Please select a menu option (1,2,3,4,5,6 or 0)");

        option = keyboardInput.nextInt();

        System.out.println();

        return option;
    }

    public static void StartEmployeeManagement() {
        int option;

        
        try {
            objEmployeeList.load();

           
            option = EmployeeManagement();

            while (option != 0) {

                switch (option) {

                    case 1:
                        getEmployeeRecord();
                        break;
                    case 2:
                        addEmployeeRecord();
                        break;                                       
                    case 3:
                        editEmployeeRecord();
                        break;
                  
                    case 4:
                        removeEmployeeRecord();
                        break;
                    case 5:
                        printEmployeeRecord();
                        break;
                    case 6:
                        printAllEmployeeRecords();
                        break;

                    default:
                        System.out.println("Incorrect entry, please try again");
                        break;
                }

                option = EmployeeManagement();

            }

            System.out.println("Exiting Employee Management Program");
            System.out.println();
            objEmployeeList.save();
            objEmployeeList.clear();
               
        }        
       catch (Exception objE) {    
        System.out.println(objE.toString());           
  
        }        
    } 

    public static void getEmployeeRecord() {
        Scanner keyboardInput = new Scanner(System.in);

        try {            
            Employee objEmployee;
            
            String ssnumber;

            System.out.println("         Search Employee Screen         ");

            System.out.println("Please enter Employee ssnumber");
            ssnumber = keyboardInput.nextLine();
          
            objEmployee = objEmployeeList.search(ssnumber);
          
            if (objEmployee != null) {
                System.out.println();
                System.out.println("The Employee's information: ");
                System.out.println("Employee Social Security Number = " + objEmployee.getSSnumber());
                System.out.println("Employee Name = " + objEmployee.getName());
                System.out.println("Employee Date Of Birth = " + objEmployee.getdob());               
                System.out.println("Employee Email = " + objEmployee.getEmail());
                System.out.println("Employee Title = " + objEmployee.getJobTitle());
            } else {
                System.out.println();
                System.out.println("Employee not found!");
            }        
        
        
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }       

    }

         public static void addEmployeeRecord() {
        try {        
           
            Scanner keyboardInput = new Scanner(System.in);

            String ssnum, nane, dob, address, phone, email,jobtitle;
            boolean success;

            System.out.println("          Adding Employee Screen         ");

            System.out.println("Please enter NEW Employee Social Security Number ");
            ssnum = keyboardInput.nextLine();

            System.out.println("Please enter NEW Employee Name");
            nane = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee Date Of Birth");
            dob = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee Address");
            address = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee Phone number");
            phone = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee email");            
            email = keyboardInput.nextLine();     
            
            System.out.println("Please enter NEW Employee Job title");
            jobtitle = keyboardInput.nextLine();

            success = objEmployeeList.add(ssnum, nane, dob, address, phone, email,jobtitle );

            if (success) {
                System.out.println();
                System.out.println("User Account Added");
            } else {
                System.out.println();
                System.out.println("No available space!");
            }
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }  
         }
        
        public static void editEmployeeRecord() {
        try {        
 
            Scanner keyboardInput = new Scanner(System.in);

            String ssnum, nane, dob, address, phone, email,jobtitle;
            boolean success;

            System.out.println("           Editing Employee Screen         ");

            System.out.println("Please enter the Employee Social Security Number ");
            ssnum = keyboardInput.nextLine();

            System.out.println("Please enter NEW Employee Name you wish to edit");
            nane = keyboardInput.nextLine();
            
            System.out.println("Please enter the New Employee Date Of Birth ");
            dob = keyboardInput.nextLine();
            
            System.out.println("Please enter the New Employee Address ");
            address = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee phone");
            phone = keyboardInput.nextLine(); 
            
            System.out.println("Please enter NEW Employee email");
            email = keyboardInput.nextLine();
            
            System.out.println("Please enter NEW Employee Job title");
            jobtitle = keyboardInput.nextLine(); 

           
            success = objEmployeeList.edit(ssnum, nane, dob, address, phone, email,jobtitle);

            if (success) {
                System.out.println();
                System.out.println("User Account record have been edited successfully");
            } else {
                System.out.println();
                System.out.println("Customer not found!");
            }
        }
        catch (Exception objE) { 
            System.out.println(objE.toString());           
        }  
        
        
         }
         public static void removeEmployeeRecord() {
        try {
            Scanner keyboardInput = new Scanner(System.in);

            String ssnum;
            boolean success;

            System.out.println("          Deleting Employee Screen          ");

            System.out.println("Please enter Employee Social Security you wish to delete");
            ssnum = keyboardInput.nextLine();

            success = objEmployeeList.remove(ssnum);

            if (success) {
                System.out.println();
                System.out.println("User Employee deleted");
            } else {
                System.out.println();
                System.out.println("Employee not found!");
            }
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }  
        
        }
         
         public static void printEmployeeRecord() {
         try {                 
            Scanner keyboardInput = new Scanner(System.in);

            String ssnum;
            boolean success;
         
            System.out.println("         Printing Employee Screen        ");
            System.out.println("Please enter Social Sercuity of employee you wish to Print");
            ssnum = keyboardInput.nextLine();

            success = objEmployeeList.print(ssnum);

            if (!success) {
                System.out.println();
                System.out.println("Employee not found!");
            }
        }
        catch (Exception objE) {
            System.out.println(objE.toString());           
        }  
    } 
               public static void printAllEmployeeRecords() {
         try {                     
            System.out.println("         Printing all Employee         ");
            System.out.println();

            objEmployeeList.printAll();

            System.out.println();
            System.out.println("          End of Employee List           ");
            }
            catch (Exception objE) {
                System.out.println(objE.toString());           
        }  
    }

        public static void startRetailPointOfSales() {
        int option;

         
        option = retaiPointOfSalesScreen();
        
        while (option != 0) {

            switch (option) {

               case 1:
         
                     System.out.println("Car Rental under construction");
                     System.out.println();
                     break;
               case 2:
                     System.out.println("Car Return under construction");
                     System.out.println();
                     break;
               case 3:                   
                   System.out.println("Customer Management under construction");
                     System.out.println();
                     break;

                  default:
                    System.out.println("Incorrect entry, please try again");
                    System.out.println();
                    break;
            } 

       
            option = retaiPointOfSalesScreen();

        } 

        System.out.println("Exiting Retail Point-of-Sales Section.............");
        System.out.println();
        
        }
        
        static int retaiPointOfSalesScreen() {
        
        Scanner keyboardInput = new Scanner(System.in);
        int option;

     
        System.out.println();
        System.out.println("            Welcome to Retail Point-of-Sales Portal        ");
        System.out.println();        
        System.out.println("1-----------Car Rental");
        System.out.println("2-----------Car Return");        
        System.out.println("3-----------CustomerManagement");           
        System.out.println("0-----------Exit (return to Main Screen)");
        System.out.println();
        System.out.println("Please select a menu option (1, 2, 3 or 0)");

        option = keyboardInput.nextInt();

        System.out.println();
        return option;
    }

}       

 
