import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number=0;
        for(int i=0;i<s.length()-1;i++){
            int iChar=map.get(s.charAt(i));
            int jchar=map.get(s.charAt(i+1));
            if(iChar<jchar) number=number-iChar;
            else number=number+iChar;
        }
        number=number+map.get(s.charAt(s.length()-1));

        return number;
    }
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
