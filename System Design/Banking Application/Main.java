
import java.util.*;
public class Main {
    static Scanner sc =new Scanner(System.in);
    static int ch;
    static String name;
    static String CID;
    static String password="default";
    static Bank bank;
    

    public static void menuPage(){
        while(true){
            System.out.println("");System.out.println("");
            System.out.println("###########################");
            System.out.println("1. View Transactions");
            System.out.println("2. Do Transactions");
            System.out.println("3. Change Password");
            System.out.println("4. Logout");
            System.out.println("###########################");
            System.out.print("Enter your choice: ");
            ch=Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1:
                    // Bank.prin
                    bank.generateAccountStatement();
                    break;
                case 2:
                    doTransactions();
                    break;
                case 4:
                    bank.currentCustomer=null;
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
    public static void doTransactions(){
        int Amount=0;
        String receAcc="";
        System.out.println("###########################");
        System.out.println("1. ATM Withdrawal");
        System.out.println("2. Cash Depoist");
        System.out.println("3. Amount Transfer");
        System.out.println("###########################");    
        ch=Integer.parseInt(sc.nextLine());
        switch (ch) {
            case 1:
                System.out.print("Enter the Amount you want to withdraw: ");
                Amount=Integer.parseInt(sc.nextLine());
                System.out.println("You are required to Re Authenticate before you can do this transaction!!!");
                if(loginPage()){
                    if(bank.doAtmWithDraw(Amount)==200){
                        System.out.println("Please Collect your cash: "+Amount);
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                    }
                    else{
                        System.out.println("Low Balance in you account");
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                    }
                }
                return;
            case 2:
                System.out.print("Enter the Amount you want to Deposit: ");
                Amount=Integer.parseInt(sc.nextLine());
                System.out.println("You are required to Re Authenticate before you can do this transaction!!!");
                if(loginPage()){
                    if(bank.doCashDepoist(Amount)==200){
                        System.out.println("Depoist Successfull: "+Amount);
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                    }
                    else{
                        System.out.println("Low Balance in you account");
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                    }
                }
                return;
            case 3:
                System.out.print("Enter the Amount you want to Transfer: ");
                Amount=Integer.parseInt(sc.nextLine());
                System.out.print("Enter the Beneficiary's Acc number: ");
                receAcc=sc.nextLine();      
                System.out.println("You are required to Re Authenticate before you can do this transaction!!!");
                if(loginPage()){
                    int returncode=bank.doAccountTransfer(Amount, receAcc);
                    if(returncode==200){
                        System.out.println("Transfer Successfull: "+Amount);
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                    }
                    else{
                        if(returncode==300){
                        System.out.println("Low Balance in you account");
                        System.out.println("Your current Balance: "+bank.getCurrentbalance());
                        }
                        if(returncode==404){
                            System.out.println("Invalid bank Account");
                        }
                    }
                }
                // return;
        }


    }

    // public static void 


    public static boolean loginPage(){
        System.out.println("###########################");
        System.out.println("LOGIN PAGE");

        while (true) { 
            System.out.print("1. Enter your Customer ID: ");
            CID=sc.nextLine();
            System.out.print("2. Enter you password: ");
            password=sc.nextLine();
            int returncode = bank.login(CID, Utills.encryptText(password));
            System.out.println("###########################");
            switch (returncode) {
                case 200:
                System.out.println("Login Success");
                return true;
                case 300:                  
                System.out.println("Wrong Password");
                break;
                default:
                    throw new AssertionError();
            }
        }      
    }
    public static void main(String[] args) {
        bank=new Bank();

        while(true){
            System.out.println("###########################");
            System.out.println("1. Create an Account");
            System.out.println("2. Login");
            System.out.println("###########################");
            System.out.print("Enter your choice: ");
            ch=Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1:
    
                String reType="";
                System.out.println("###########################");
                System.out.println("CREATE ACC PAGE");
    
                System.out.print("1. Enter your Name: ");
                name=sc.nextLine();
                while(!(password.equals(reType))){
                    System.out.print("2. Enter Password: ");
                    password=sc.nextLine();
                    System.out.print("3. RE-Enter Password: ");
                    reType=sc.nextLine();
                    if(!(password.equals(reType))) System.out.println("Password Did not Match Please retype");
                }
                System.out.println("###########################");                
                bank.CreateUser(name, Utills.encryptText(password));
                break;
    
                case 2:
                if (loginPage()){
                    menuPage();
                }
                break;

    
                default:
                    throw new AssertionError();
            }
        }

    }
}
