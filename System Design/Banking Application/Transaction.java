
public class Transaction {
    String TransID;
    String TransType;
    int Amount;
    int Balance;

    Transaction(String TransID,String TransType,int Amount,int Balance){
        this.TransID=TransID;
        this.TransType=TransType;
        this.Amount=Amount;
        this.Balance=Balance;
    }
}
