public class Doubly_Linked_List {

    private ListNode head;
    private ListNode tail;
    private int length;

     public class ListNode{
         private int data;
         private ListNode previous;
         private ListNode next;

         public ListNode(int data) {
             this.data = data;
         }
     }

     public Doubly_Linked_List(){
         this.head = null;
         this.tail = null;
         this.length = 0;
     }

     public boolean isEmpty(){
         return length == 0;
     }

     public int length(){
         return length;
     }

     public void display(){
         ListNode current = head;
         while (current != null){
             System.out.print(current.data + "<------>");
             current = current.next;
         }
         System.out.println("null");
     }

     public void insert_node_at_last(int data){
         ListNode new_node = new ListNode(data);
         ListNode current = head;
         while (current.next != null){
             current = current.next;
         }
         current.next = new_node;
     }

     public void insert_node_at_starting(int data){
         ListNode new_node = new ListNode(data);
         new_node.next = head;
         head = new_node;
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

    public static void main(String[] args) {
        Doubly_Linked_List dll = new Doubly_Linked_List();
        dll.insert_node_at_starting(1);
        dll.insert_node_at_last(1);
        dll.insert_node_at_last(2);
        dll.insert_node_at_last(3);
        dll.insert_node_at_last(4);
        dll.insert_node_at_last(5);
        dll.insert_node_at_last(6);
        dll.insert_node_at_last(7);
        dll.insert_node_at_starting(13);
        //dll.delete_first_node();
        dll.display();

        //dll.delete_last_node();
        dll.display();
    }
}
