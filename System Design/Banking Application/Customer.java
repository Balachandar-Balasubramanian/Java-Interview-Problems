
import java.util.*;
public class Customer {
    String CID;
    String AccNo;
    String Name;
    String Password;
    int Balance;
    public ArrayList<Transaction> transactionHistory=new ArrayList<>();
    Customer(String Name,String Password,String CID,String ACCNo,int Balance){
        this.Name=Name;
        this.Password=Password;
        this.CID=CID;
        this.AccNo=ACCNo;
        this.Balance=Balance;
    }



}
