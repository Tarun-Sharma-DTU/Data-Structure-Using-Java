public class Squares_Sorted_Array {
    public int[] square_sorted_array(int[] arr){
        int i = 0, j = arr.length - 1, k =0;
        int[] result = new int[arr.length];
        for (k = arr.length - 1; k >= 0; k--){
            if (Math.abs(arr[i]) > Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            }
            else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2,0,1,4,5,6,7,9};
        Squares_Sorted_Array myalgo = new Squares_Sorted_Array();
        int[] res = myalgo.square_sorted_array(arr);
        Array.display(res);
    }
}
