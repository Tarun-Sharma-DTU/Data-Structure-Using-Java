public class Merge_Sort_Algorithms {

    public void sort(int[] arr, int[] temp, int low, int high){
        if (low < high){
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++){
            temp[i] = arr[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high){
            if (temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }
            else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            arr[k] = temp[i];
            i++; k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 5, 7, 6, 8, 9, 20};
        Merge_Sort_Algorithms myalgo = new Merge_Sort_Algorithms();
        myalgo.sort(arr, new int[arr.length], 0, arr.length - 1);
        Array.display(arr);
    }
}
