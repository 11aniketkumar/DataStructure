public class QuickSort
{
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;
        
        while(i<j) {
            while(arr[i]<=pivot && i<=high-1) i++;
            while(arr[j]>pivot && j>=low+1) j--;
            
            if (i<j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }
    
    public static void quicksort(int[] arr, int low, int high) {
        if(low<high) {
            int pIndex = partition(arr, low, high);
            quicksort(arr, low, pIndex-1);
            quicksort(arr, pIndex+1, high);
        }
    }
    
	public static void main(String[] args) {
		int arr[] = {4,1,2,3,6,23,12,45,8,11,483};
		
		for(int i : arr) {
		    System.out.print(i + " ");
		}
		
		System.out.println();
		quicksort(arr, 0, arr.length-1);
		
		for(int i : arr) {
		    System.out.print(i + " ");
		}
	}
}

