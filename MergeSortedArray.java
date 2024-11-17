import java.util.ArrayList;

public class MergeSortedArray {

    public static int[] method1(int[] arr1,int[] arr2){
        ArrayList<Integer> result= new ArrayList<>();

        int i=0;
        int j=0;
        int prev=0;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                if(prev!=arr1[i]) {
                    result.add(arr1[i]);
                     prev=arr1[i];
                    }
                i++;
            }
            else{
                if(arr2[j]!=prev){
                    result.add(arr2[j]);
                    prev=arr2[j];
                }
                j++;
            }
        }
        if(i<arr1.length){
            for(i=i;i<arr1.length;i++){
                result.add(arr1[i]);
            }
        }
        if(j<arr2.length){
            for(j=j;j<arr2.length;j++){
                result.add(arr2[j]);
            }
        }

        return result.stream().mapToInt(k -> k).toArray();

    
    }

    

    public static void main(String[] args) {
        int[] arr1={2,4,5,6,7,9,10,13};
        int[] arr2={2,3,4,5,6,7,8,9,11,15};
        int[] result=method1(arr1, arr2);

        for(int i:result){
            System.out.print(i+",");
        }
    }
}
