package com.company;

import com.sun.source.tree.BreakTree;

public class Circular_Linked_List {
    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public Circular_Linked_List(){
        last = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean is_empty(){
        return length == 0;
    }

    public void create_circular_linked_list(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode five = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;
        five.next = first;

        last = five;
    }

    public void display(){
        if (last == null){
            System.out.println("Null");
        }
        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data + "-----");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insert_node_begining(int data){
        ListNode new_node = new ListNode(data);
        ListNode first = last.next;
        new_node.next = first;
        last.next = new_node;
    }


    public void insert_node_at_end(int data){
        ListNode new_node = new ListNode(data);
        ListNode first = last.next;
        new_node.next = first;
        last.next = new_node;
        last = new_node;
    }

    public void remove_first_node(){
        ListNode first = last.next;
        last.next = first.next;
        first = null;
    }

    public static void main(String[] args) {
        Circular_Linked_List cll = new Circular_Linked_List();
        cll.create_circular_linked_list();
        cll.display();
        cll.insert_node_begining(10);
        cll.insert_node_begining(12);
        cll.insert_node_at_end(25);
        cll.display();
        cll.remove_first_node();
        cll.display();
    }
}
