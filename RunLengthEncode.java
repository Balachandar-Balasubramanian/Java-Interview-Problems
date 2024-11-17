class RunLengthEncode {
    
    public static void method(String str){
        char chr;
        int count=0;
        String result="";
            for(int i=0;i<str.length()-1;i++){
                chr=str.charAt(i);
                count=0;
                while( i + 1 < str.length() && Character.isDigit(str.charAt(i+1))){
                    count=count*10+Character.getNumericValue(str.charAt(i+1));
                    i++;
                    // if(i>=str.length()) break;
                }
                for(int j=0;j<count;j++){
                    result=result+chr;
                }
            }
            
        
        System.out.println(result);
        
    }
    public static void main(String[] args) {
        String str="a1b13";
        method(str);
        System.out.println("Try programiz.pro");
    }
}