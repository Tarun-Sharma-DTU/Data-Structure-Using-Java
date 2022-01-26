public class Array {

    static void display(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] remove_even_numbers(int[] arr){
        int odd_count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]%2 != 0)
                odd_count++;
        }

        int[] result = new int[arr.length - odd_count];
        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]%2 == 0){
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    public void create_array(){
        int[] my_array = new int[5];
        my_array[0] = 1;
        my_array[1] = 1;
        my_array[2] = 2;
        my_array[3] = 3;
        my_array[4] = 4;
        display(my_array);
        remove_even_numbers(my_array);
    }

    static int[] reverse_array(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[arr.length- i - 1] = arr[i];
        }
        return result;
    }

    static int minimum_value(int[] arr){
        int result = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < result){
                result = arr[i];
            }
        }
        return result;
    }

    static int find_second_maximum_value(int[] arr){
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                second_max = max;
                max = arr[i];
            }
            else if (arr[i] > second_max && arr[i] != max){
                second_max = arr[i];
            }
        }
        return second_max;
    }

    static void move_zeroes_to_end(int[] arr){
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
            }
            if (arr[j] != 0){
                j++;
            }
        }
    }

    static int[] resize_array(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    static void find_missing_number(int[] arr){
        int n = arr.length + 1;
        int total_sum = n*(n+1)/2;
        int sum = 0;
        for (int i = 0; i < n - 1; i++){
            sum += arr[i];
        }
        int missiong_num = total_sum - sum;
        System.out.println("Missing Number is : " + missiong_num);
    }

    static boolean to_check_string_is_palindrome_or_not(String my_str){
        char[] my_char = my_str.toCharArray();
        int start = 0;
        int end = my_str.length() - 1;
        while (start < end){
            if (my_char[start] != my_char[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8};
        //int[] result = remove_even_numbers(arr);
        //display(arr);
        //display(result);

        //int[] result = reverse_array(arr);
        display(arr);
        //display(result);

        //System.out.println(minimum_value(arr));
        //int second_max = find_second_maximum_value(arr);
        //System.out.println(second_max);

        //move_zeroes_to_end(arr);
        //display(arr);

        //System.out.println("The Original Array Size is : " + arr.length);
        //arr = resize_array(arr, 16);
        //System.out.println("The Resized Array Size is : " + arr.length);

        //find_missing_number(arr);

        //System.out.println(to_check_string_is_palindrome_or_not("madak"));
    }
}
