public class SearchInRowColumnwiseMatrix {
    public void search(int[][] matrix, int n, int x){
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0){
            if (matrix[i][j] == x){
                System.out.println("x found at -> " + i + "," + j);
                return;
            }
            if (matrix[i][j] > x){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[][] my_matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        SearchInRowColumnwiseMatrix my_search = new SearchInRowColumnwiseMatrix();
        my_search.search(my_matrix, 4, 1);
    }
}
