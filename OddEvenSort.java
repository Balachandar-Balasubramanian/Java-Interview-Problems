import java.util.ArrayList;

public class OddEvenSort {
     public static void method1(int arr[]){
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even= new ArrayList<>();
         for(int i=0;i<arr.length;i++){
            if((i+1)%2==0)even.add(arr[i]);
            else odd.add(arr[i]);
         }
         odd.sort(null);
         even.sort(null);
        
        int m=odd.size()-1;
        int n=0;

        for(int i=0;i<arr.length;i++){
            if((i+1)%2==0) {
                arr[i]=even.get(n);
                n++;
            }
            else {
                arr[i]=odd.get(m);
                m--;
            }
        }

    
    }
    public static void sort(int arr[]){
        quickSort(arr, 0, arr.length-1);

    }


        // Method to partition the array around the pivot
        private static int partition(int[] array, int low, int high) {
            int pivot = array[high]; // Choosing the last element as pivot
            int i = low - 1; // Index of smaller element
    
            for (int j = low; j < high; j++) {
                // If current element is smaller than or equal to the pivot
                if (array[j] <= pivot) {
                    i++;
                    // Swap array[i] and array[j]
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
    
            // Swap array[i+1] and array[high] (pivot)
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
    
            return i + 1; // Return the partition index
        }
    
        // Quick Sort algorithm
        public static void quickSort(int[] array, int low, int high) {
            if (low < high) {
                // Partition the array
                int pi = partition(array, low, high);
    
                // Recursively sort elements before and after partition
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
    }

    
    public static void method2(int arr[]){
        for(int i=0;i<arr.length;i++){
            if((i+1)%2!=0) arr[i]=arr[i]-2*arr[i];
        }

        sort(arr);
        int n=0;
        if(arr.length%2==0) n=arr.length/2;
        else n=(arr.length+1)/2;
        for(int i=0;i<n;i++){
            arr[i]=arr[i]-2*arr[i];   
        }
    }
    public static void main(String[] args) {
    
        int[] arr ={2,1,10,5,4,9,13,8};
        int[] arr2={2,1,10,5,4,9,13,8};
        method1(arr);
        for (int i : arr) {
            System.out.print(i+" ,");         
        }
        System.out.println();
        method2(arr2);
        for (int i : arr2) {
            System.out.print(i+" ,");          
        }
        // System.out.print(1%2==0);

    }
}
