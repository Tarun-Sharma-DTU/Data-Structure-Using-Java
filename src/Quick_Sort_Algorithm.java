public class Quick_Sort_Algorithm {

    private int partition(int[] arr, int low, int high){
        int i = low, j = low, pivot = arr[high];
        while (i <= high){
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    public void sort(int[] arr, int low, int high){
        if (low < high){
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4, 7, 6, 8, 9, 13, 11};
        Quick_Sort_Algorithm myalgo = new Quick_Sort_Algorithm();
        myalgo.sort(arr, 0, arr.length - 1);
        Array.display(arr);
    }
}
