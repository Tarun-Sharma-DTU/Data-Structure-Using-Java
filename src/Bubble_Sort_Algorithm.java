public class Bubble_Sort_Algorithm {
    public void bubble_sort(int[] arr){
        int swap = 1, temp, i, j, t = 0;
        for (j = arr.length - 1; j >= 0; j--){
            swap = 0;
            for (i = 0; i < j - 1; i++){
                t++;
                if (arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6, 8, 7};
        Bubble_Sort_Algorithm myalgo = new Bubble_Sort_Algorithm();
        myalgo.bubble_sort(arr);
        Array.display(arr);
        System.out.println(arr.length);
        //Array.display(res);
    }
}
