public class Test_Singly_Linked_List {
    private ListNode head;

    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insert_at_starting(int data) {       // Perfect
        ListNode new_node = new ListNode(data);
        new_node.next = head;
        head = new_node;
    }

    public void display(){                          // Perfect
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "----->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insert_node_at_end(int data){            // Perfect
        ListNode current = head;
        ListNode new_node = new ListNode(data);
        while (current.next != null){
            current = current.next;
        }
        current.next = new_node;
    }

    public void insert_node_at_given_position(int data, int loc){     // Different Approach Used
        ListNode new_node = new ListNode(data);
        ListNode current = head;
        ListNode previous = head;
        if (loc == 1){
            new_node.next = current.next;
            head = new_node;
        }
        else {
            for (int i = 0; i < loc - 1; i++){
                previous = current;
                current = current.next;
            }
            previous.next = new_node;
            new_node.next = current;
        }
    }

    public void delete_first_node(){
        ListNode current = head;
        head = current.next;
    }

    public void delete_last_node(){
        ListNode current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }

    public void delete_node_at_given_pos(int loc){
        ListNode current = head;
        if (loc == 1){
            head = current.next;
        }
        else {
            ListNode previous = head;
            for (int i = 0; i < loc - 1; i++){
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
    }

    public void remove_given_key(int data){
        ListNode current = head;
        ListNode previous = null;
        if (current.data == data){
            head = current.next;
        }
        else {
            while (current != null) {
                if (current.data == data) {
                    previous.next = current.next;
                }
                previous = current;
                current = current.next;
            }
        }
    }

    public void search_element_in_linked_list(int data){
        ListNode current = head;
        int loc = 1;
        while (current != null && current.data != data){
            current = current.next;
            loc += 1;
        }
        if(current == null){
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element Found At Position : " + loc);
        }
    }

    public void reverse(){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        if (head == null) System.out.println("Null Linked List");;

        while (current != null){
         next = current.next;
         current.next = previous;
         previous = current;
         current = next;
        }
        head = previous;
    }

    public int find_middle_of_a_linked_list(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr.data;
    }

    public boolean Detect_loop_in_a_singly_linked_list(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if (fast_ptr == slow_ptr){
                return true;
            }
        }
        return false;
    }

    public void remove_duplicate(){
        ListNode current = head;
        ListNode previous = head;
        while (current.next != null){
            previous = current;
            current = current.next;
            if (previous.data == current.data){
                previous.next = current.next;
            }
        }
    }

    public ListNode find_start_of_the_loop(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if (fast_ptr == slow_ptr){
                return get_start_find(slow_ptr);
            }
        }
        return null;
    }

    private ListNode get_start_find(ListNode slow_ptr){
        ListNode temp = head;
        while (slow_ptr != temp){
            slow_ptr = slow_ptr.next;
            temp = temp.next;
        }
        return temp;
    }

    public void remove_loop(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if (fast_ptr == slow_ptr){
                remove_loop(slow_ptr);
            }
        }
    }

    public void remove_loop(ListNode slow_ptr){
        ListNode temp = head;
        while (temp.next == slow_ptr.next){
            slow_ptr = slow_ptr.next;
            temp = temp.next;
        }
        slow_ptr.next = null;
    }

    public ListNode merge_sort_linked_list(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (a != null && b != null){
            if (a.data <= b.data){
                temp.next = a;
                a = a.next;
            }
            else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a == null){
            temp.next = b;
        }
        else {
            temp.next = a;
        }
        return dummy.next;
    }

    public ListNode add_two_sorted_list(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (a != null && b != null){
            int x = (a != null)? a.data : 0;
            int y = (b != null)? b.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0){
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Test_Singly_Linked_List tdll = new Test_Singly_Linked_List();
        tdll.insert_at_starting(9);
        tdll.insert_at_starting(8);
        tdll.insert_at_starting(7);
        tdll.insert_at_starting(6);
        tdll.insert_at_starting(5);
        tdll.insert_at_starting(3);
        tdll.insert_at_starting(1);

        Test_Singly_Linked_List tdll1 = new Test_Singly_Linked_List();
        tdll1.insert_at_starting(15);
        tdll1.insert_at_starting(14);
        tdll1.insert_at_starting(12);
        tdll1.insert_at_starting(10);
        tdll1.insert_at_starting(8);
        tdll1.insert_at_starting(6);
        tdll1.insert_at_starting(4);

        //tdll.insert_node_at_end(6);
        //tdll.insert_node_at_end(6);
        //tdll.insert_node_at_given_position(1000,4);
        tdll.display();
        //tdll.delete_first_node();
        //tdll.delete_last_node();
        //tdll.delete_node_at_given_pos(3);
        //tdll.search_element_in_linked_list(100);
        //tdll.reverse();
        //tdll.remove_duplicate();
        //tdll.remove_given_key(2);
        //System.out.println(tdll.Detect_loop_in_a_singly_linked_list());
        //System.out.println(tdll.find_start_of_the_loop());
        //Test_Singly_Linked_List result = new Test_Singly_Linked_List();
        //result.head = result.merge_sort_linked_list(tdll.head, tdll1.head);
        //result.display();
        Test_Singly_Linked_List add_result = new Test_Singly_Linked_List();
        add_result.head = add_result.add_two_sorted_list(tdll.head, tdll1.head);
        add_result.display();
        //tdll.display();
        //System.out.println(tdll.find_middle_of_a_linked_list());
    }
}
