public class Selection_Sort_Algorithms {
    public void selection_sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int min = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4,7,6,9,8};
        Selection_Sort_Algorithms myago = new Selection_Sort_Algorithms();
        myago.selection_sort(arr);
        Array.display(arr);
    }
}
