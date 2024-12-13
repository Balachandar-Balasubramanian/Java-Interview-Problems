class StringMatching{

    public static int strStr(String haystack, String needle) {
        int haylen=haystack.length();
        int needlelen=needle.length();
        boolean found=false;
    
        int flag=1;
        for(int i=0;i<haylen-needlelen;i++){
            // int count=0;
            for(int j=0;j<needlelen;j++){
                // System.out.println(haystack.charAt(i+j)+" : "+needle.charAt(j));
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    flag=0;
                    break;
                }
            }
            if(flag==0){
                flag=1;
            }
            else{
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack="mississippi";
        String needle="issipi";
        System.out.print(strStr(haystack, needle));
    }
}