// Creating A Singly Linked List
public class Singly_Linked_List {
    private ListNode head;

    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "---->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void linked_list_length(){
        ListNode current = head;
        int i = 0;
        while (current != null){
            i += 1;
            current = current.next;
        }
        System.out.println("The Length of the linked list is : " + i);
    }

    public void insert_node_at_begining(int data){
        ListNode new_node = new ListNode(data);
        new_node.next = head;
        head = new_node;
    }

    public void insert_node_at_the_end(int data){
        ListNode new_node = new ListNode(data);
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new_node;
    }

    public void insert_node_at_given_position(int data, int loc){
        ListNode new_node = new ListNode(data);
        ListNode current = head;
        for (int i = 0; i < loc - 1; i++){
            current = current.next;
        }
        new_node.next = current.next;
        current.next = new_node;
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

    public void delete_node_at_given_position(int loc){
        ListNode current = head;
        for (int i = 0; i < loc - 1; i++){
            current = current.next;
        }
        ListNode rem = current.next.next;
        current.next = rem;
    }

    public void find_element_in_linked_list(int data){
        ListNode current = head;
        int i = 0;
        while (current != null){
            if (current.data == data){
                System.out.println("Element Fount at index number : " + i);
            }
            i += 1;
            current = current.next;
        }
    }

    public void reverse_linked_list(){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int find_middle_node(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr.data;
    }

    public int find_nth_element_from_the_end(int loc){
        ListNode ref_ptr = head;
        ListNode main_ptr = head;
        int count = 0;

        while (count < loc){
            ref_ptr = ref_ptr.next;
            count++;
        }
        while (ref_ptr != null){
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }
        return main_ptr.data;
    }

    public void remove_duplicate(){
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }

    public int insert_an_element_in_sorted_linked_list(int data){
        ListNode current = head;
        ListNode new_node = new ListNode(data);
        ListNode temp = null;
        while (current != null && current.data < new_node.data){
            temp = current;
            current = current.next;
        }
        new_node.next = current;
        temp.next = new_node;
        return head.data;
    }

    public void remove_given_key(int data){
        ListNode current = head;
        ListNode temp = null;
        if (current.data == data){
            head = current.next;
        }
        else {
            while (current != null && current.data != data) {
                temp = current;
                current = current.next;
            }
            if (current == null)
                return;
            temp.next = current.next;
        }
    }

    public boolean check_loop_in_linked_list(){
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

    public ListNode find_start_loop(){
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;

            if (fast_ptr == slow_ptr){
                return get_started_loop(slow_ptr);
            }
        }
        return null;
    }

    private ListNode get_started_loop(ListNode slow_ptr){
        ListNode temp = head;
        while (temp != slow_ptr){
            temp = temp.next;
            slow_ptr = slow_ptr.next;
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
                remove_loop_start(slow_ptr);
            }
        }
    }

    private void remove_loop_start(ListNode slow_ptr){
        ListNode temp = head;
        while (temp.next != slow_ptr.next){
            slow_ptr = slow_ptr.next;
            temp = temp.next;
        }
        slow_ptr.next = null;
    }

    public static ListNode merge_two_sorted_linked_list(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null){
            if (a.data <= b.data){
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null)
        {
            tail.next = b;
        }
        else {
            tail.next = b;
        }
        return dummy.next;
    }

    public static ListNode add_two_linked_list(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null){
            int x = (a != null)? a.data : 0;
            int y = (b != null)? b.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Creating Nodes
        Singly_Linked_List sll = new Singly_Linked_List();
        sll.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        Singly_Linked_List sll1 = new Singly_Linked_List();
        sll1.head = new ListNode(6);
        ListNode second1 = new ListNode(7);
        ListNode third1 = new ListNode(8);
        ListNode forth1 = new ListNode(9);
        ListNode fifth1 = new ListNode(2);
        ListNode sixth1 = new ListNode(5);

        // Connecting All The Nodes
        sll.head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;

        sll1.head.next = second1;
        second1.next = third1;
        third1.next = forth1;
        forth1.next = fifth1;
        fifth1.next = sixth1;

        //sll.insert_node_at_begining();
        //sll.insert_node_at_the_end(500);
        //sll.insert_node_at_given_position(1000,2);
        //sll.remove_duplicate();
        //sll.display();
        //sll.linked_list_length();
        //sll.delete_first_node();
        //sll.delete_last_node();
        //sll.delete_node_at_given_position(2);
        //sll.display();
        //sll.find_element_in_linked_list(10);
        sll.display();
        sll.reverse_linked_list();
        //sll.display();
        //System.out.println(sll.find_middle_node());
        //System.out.println(sll.find_nth_element_from_the_end(1));
        //sll.insert_an_element_in_sorted_linked_list(2);
        //sll.insert_an_element_in_sorted_linked_list(8);
        //sll.remove_given_key(9);
        //System.out.println(sll.check_loop_in_linked_list());
        //System.out.println(sll.find_start_loop().data);
        //sll.display();
        //sll.remove_loop();
        sll.display();
        //Singly_Linked_List result = new Singly_Linked_List();
        //result.head = merge_two_sorted_linked_list(sll.head, sll1.head);
        //Singly_Linked_List add_result = new Singly_Linked_List();
        //add_result.head = add_two_linked_list(sll.head, sll1.head);
        //add_result.display();
    }
}
