public class Sort_Os_1s_2s_Dutch_Flag_Problem {
    public void sort(int[] arr){
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k){
            if (arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j++;
            }
            else if (arr[i] == 1){
                i++;
            }
            else if (arr[i] == 2){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 2, 1, 1, 0, 0, 1, 0};
        Sort_Os_1s_2s_Dutch_Flag_Problem myalgo = new Sort_Os_1s_2s_Dutch_Flag_Problem();
        myalgo.sort(arr);
        Array.display(arr);
    }
}
