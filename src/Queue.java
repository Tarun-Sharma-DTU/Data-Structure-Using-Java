public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

        public int length(){
            return length;
        }


        public boolean is_empty(){
            return length == 0;
        }

        public void enqueue(int data){
            ListNode new_node = new ListNode(data);
            if (is_empty()){
                front = new_node;
            }
            else {
                rear.next = new_node;
            }
            rear = new_node;
            length++;
        }

        public void dequeue(){
            if (is_empty()){
                System.out.println("Queue is Empty.");
            }
            else {
                ListNode current = front;
                front = current.next;
                current = null;
                length--;
            }
        }

    public static void main(String[] args) {
        Queue queue = new Queue();
    }
}
