public class MergeSort {
    public static void merge_sort(int arr[], int low, int high) {
        if(low == high) return;

        int mid = (low + high) / 2;

        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int k = 0;
        int temp[] = new int[high-low+1];

        while((left <= mid) && (right <= high)) {
            if(arr[left] < arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }

        while(left <= mid) {
            temp[k] = arr[left];
            left++;
            k++;
        }

        while(right <= high) {
            temp[k] = arr[right];
            right++;
            k++;
        }

        for(int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,5,3,12,6,19};

        for(int i: arr) {
            System.out.print(i + " ");
        }

        merge_sort(arr, 0, arr.length-1);
        System.out.println();

        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}