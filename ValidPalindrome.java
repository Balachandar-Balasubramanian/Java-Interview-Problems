//LeetCode 125

public class ValidPalindrome {

    public static boolean method(String s){
        String str=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        boolean result= method(s);
        System.out.println(result);

    }
}
