import java.util.Stack;
public class String_Reverse {

    public static String reverse_string_using_stack(String my_str){
        Stack<Character> my_stack = new Stack<>();
        char[] my_char = my_str.toCharArray();
        for (char c : my_char){
            my_stack.push(c);
        }
        for (int i = 0; i < my_str.length(); i++){
            my_char[i] = my_stack.pop();
        }
        return new String(my_char);
    }

    public static void main(String[] args) {
        String str = "Tarun";
        System.out.println("Before String : " + str);
        str = reverse_string_using_stack(str);
        System.out.println("After String : " + str);
    }
}
