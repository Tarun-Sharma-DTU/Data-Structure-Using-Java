public class Merge_Two_Sorted_Arrays {
    public int[] merge(int[] arr1, int[] arr2, int n, int m){
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < n && j < m){
            if (arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
            }
            else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n){
            res[k] = arr1[i];
            i++; j++;
        }
        while(j < m){
            res[k] = arr2[j];
            j++; k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,5,7,9,10,12,13};
        int[] arr2 = {2,3,6,7,8};
        Merge_Two_Sorted_Arrays myalgo = new Merge_Two_Sorted_Arrays();
        int[] res = myalgo.merge(arr1, arr2, 8, 5);
        Array.display(res);
    }
}
