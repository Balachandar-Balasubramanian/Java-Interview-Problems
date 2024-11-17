public class XStringPrint {
    

    public static void method(String str){
        int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    System.out.print(str.charAt(i));
                    continue;
                }
                if(i+j==n-1){
                    System.out.print(str.charAt(j));
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        String str="geeksforgeeks";
        method(str);
    }
}
