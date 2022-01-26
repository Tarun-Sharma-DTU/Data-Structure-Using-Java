public class Insertion_Sort_Algorithm {

    public void insertion_sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6, 5};
        Insertion_Sort_Algorithm myalgo = new Insertion_Sort_Algorithm();
        myalgo.insertion_sort(arr);
        Array.display(arr);
    }
}
