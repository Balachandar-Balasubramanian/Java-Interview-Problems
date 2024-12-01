
import java.util.Random;

public class Utills {
    private static final Random rand=new Random();

    public static String generateAccNo(){
        int n1=rand.nextInt(1, 9);
        int n2=rand.nextInt(1, 9);
        int n3=rand.nextInt(1, 9);
        int n4=rand.nextInt(1, 9);
        return ""+n1+n2+"0"+n3+n4;
    }

    public static String generateCID(){
        int n=rand.nextInt(1,99 );
        return "C"+n;
    }
    public static String generateTID(){
        int n=rand.nextInt(1,99 );
        return "T"+n;
    }
    public static String encryptText(String text){

        String password="";
        for(int i=0;i<text.length();i++){
            int n;
            if(Character.isDigit(text.charAt(i))){
                n=Integer.parseInt(text.charAt(i)+"");
                n=(n+1)%10;
                password=password+n;
                continue;
            }
            n=text.charAt(i)+0;
            // System.out.println(n);
            if(n>=65 && n<=90){ //capital Letter
                n=n-65;
                n=(n+1)%26;
                password=password+Character.toString(n+65);
                continue;
            }
            if(n>=97 && n<=122){
                    n=n-97;
                    n=(n+1)%26;
                    password=password+Character.toString(n+97);
            }
        }
        return password;
    }
}
