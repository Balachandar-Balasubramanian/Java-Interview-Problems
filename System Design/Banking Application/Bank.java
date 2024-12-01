

import java.util.HashMap;

public class Bank {
    HashMap<String,Customer> customerList=new HashMap<>();
    HashMap<String,String> AccCIDMap= new HashMap<>();
    Customer currentCustomer;
    private void initalizeBank(){
        CreateUser("bala", "cbmb");
        CreateUser("Chandru", "cbmb");
    }


    Bank(){
        initalizeBank();
    }
    // public void printTopNCustomers(){
    //     for()
    // }
    public void CreateUser(String Name,String Password){
        String CID;
        String AccNO;
        int initialBalance=10000;
        while(true){
            CID=Utills.generateCID();
            if(!(AccCIDMap.values().contains(CID))){
                break;
            }
        }
        while(true){
            AccNO=Utills.generateAccNo();
            if(!(AccCIDMap.keySet().contains(AccNO))){
                break;
            }
        }

        Customer customer=new Customer(Name, Password, CID, AccNO, initialBalance);
        customerList.put(customer.CID, customer);
        AccCIDMap.put(customer.AccNo, customer.CID);
        System.out.println("ACCOUNT CREATED SUCCESSFULLY");
        printCustomerDetails(customer);
    }

    public int login(String CID,String Password){
        if(customerList.containsKey(CID)){
            if(customerList.get(CID).Password.equals(Password)){
                currentCustomer=customerList.get(CID);
                return 200;
            }
            return 300;
        }
        return 404;
    }



    public void printCustomerDetails(Customer customer){
        System.out.println("###########################");
        System.out.println("CUSTOMER ID: "+customer.CID);
        System.out.println("ACCOUNT NO: "+ customer.AccNo);
        System.out.println("NAME: "+customer.Name);
        System.out.println("Balance: "+ customer.Balance);
        System.out.println("PASSWORD: "+customer.Password);
        System.out.println("###########################");
        System.out.println("");

    }

    public int doAtmWithDraw(int Amount){
        if(currentCustomer.Balance>=Amount){
            System.out.println("###########################");
            currentCustomer.Balance=currentCustomer.Balance-Amount;
            System.out.println("Withdraw Successfull");
            if(currentCustomer.Balance<1000){
                System.out.println("[Warning] Low Balance your current balance have reached lower than 1000");
            }
            Transaction transaction=new Transaction(Utills.generateTID(), "ATM WITHDRAW", Amount, currentCustomer.Balance);
            currentCustomer.transactionHistory.add(transaction);
            checkMaintenance();
            return 200;
        }
        return 300;
    }

    public int doCashDepoist(int Amount){
        currentCustomer.Balance=currentCustomer.Balance+Amount;
        Transaction transaction=new Transaction(Utills.generateTID(), "CASH DEPOIST", Amount, currentCustomer.Balance);
        currentCustomer.transactionHistory.add(transaction);
        return 200;
    }

    public int doAccountTransfer(int Amount, String RACCno){
        if(currentCustomer.Balance>=Amount){
            if(AccCIDMap.containsKey(RACCno)){
                if (currentCustomer.AccNo.equals(RACCno)) {
                    System.out.println("you cannot transfer to yourself");
                    return 100;
                }
                String rece=AccCIDMap.get(RACCno);
                currentCustomer.Balance=currentCustomer.Balance-Amount;
                customerList.get(rece).Balance=customerList.get(rece).Balance+Amount;
                Transaction transaction=new Transaction(Utills.generateTID(), "TransferTo"+RACCno, Amount, currentCustomer.Balance);
                currentCustomer.transactionHistory.add(transaction);
                customerList.get(rece).transactionHistory.add(transaction);
                
                if(Amount>5000){
                    currentCustomer.Balance=currentCustomer.Balance-10;
                    System.out.println("Amount exceeds 5000");
                    transaction=new Transaction(Utills.generateTID(), "Cash Trasnfer Fee"+RACCno, 10, currentCustomer.Balance);
                    currentCustomer.transactionHistory.add(transaction);
                }
                checkMaintenance();
                return 200;
            }
            return 404;
        }
        return 300;
    }
    public void checkMaintenance(){
        if(currentCustomer.transactionHistory.size()%1==0){
            System.out.print("You have done 10 transactions");
            Transaction transaction=new Transaction(Utills.generateTID(), "Maintenance Fee", 100, currentCustomer.Balance);
            currentCustomer.transactionHistory.add(transaction);
        }
    }


    public int getCurrentbalance(){
        return currentCustomer.Balance;
    }
    public void generateAccountStatement(){
        System.out.println("Account Statement");
        System.out.println("Customer Name: "+currentCustomer.Name);
        System.out.println("Account num: "+currentCustomer.AccNo);
        System.out.println("Customer ID: "+currentCustomer.CID);


        System.out.println("TransID               TransType                   Amount     Balance    ");
        for (Transaction transaction : currentCustomer.transactionHistory) {
            System.out.println(transaction.TransID+"               "+transaction.TransType+"                  "+transaction.Amount+"              "+transaction.Balance);
        }
    }


}
