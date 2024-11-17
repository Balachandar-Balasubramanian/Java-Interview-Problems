public class RemoveDuplicatezSorted2 {

    public static int method(int[] arr){
        int prev=arr[0];
        int j=1;
        int count=1;
        int totalcount=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=prev){
                arr[j]=arr[i];
                j++;
                prev=arr[i];
                count=1;
                totalcount++;
            }
            else {
                if(arr[i]==prev){
                count++;
    
                if(count<3){
                    arr[j]=arr[i];
                    j++;
                    totalcount++;
                }
            }
        }
        }
        return totalcount;
    }
    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,1,2,3,3};
        method(arr);
        for(int i: arr){
            System.out.print(i+", ");
        }

    }
}
