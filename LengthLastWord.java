public class LengthLastWord {
    
    public static int method(String s){
        int length=0;
        for(int i=s.length()-1;i>=0;i--){

            if(s.charAt(i)  !=' ' && s.charAt(i)!=',' && s.charAt(i)!='.'){
                length++;
            }
            else{
                if(length>0){
                    break;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s="y";
        System.out.println(method(s));
    }
}
