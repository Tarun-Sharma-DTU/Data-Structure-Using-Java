
public class Next_Greter_Element {
    public int[] next_greater_element(int[] arr){
        int[] result = new int[arr.length];
        Stack stack = new Stack();
        for (int i = arr.length - 1; i <= 0; i--){
            if (!stack.is_empty()){
                while (!stack.is_empty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if (stack.is_empty()){
                result[i] = -1;
            }
            else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    static void display(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 4, 8, 1};
        Next_Greter_Element res = new Next_Greter_Element();
        int[] res1 = res.next_greater_element(arr);
        display(res1);
    }
}
