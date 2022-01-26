import com.sun.source.tree.Tree;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree {
    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private void create_tree(){
        TreeNode first = new TreeNode(13);
        TreeNode second = new TreeNode(6);
        TreeNode third = new TreeNode(7);
        TreeNode forth = new TreeNode(2);
        TreeNode fifth = new TreeNode(3);
        TreeNode sixth = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = forth;
        second.right = fifth;
        third.left = sixth;
        third.right = null;

    }

    public void preorder_traversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }

    public void preorder_traversal_by_iteration(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void inorder_traversal_by_recursive(TreeNode root){
        if (root == null){
            return;
        }
        inorder_traversal_by_recursive(root.left);
        System.out.print(root.data + " ");
        inorder_traversal_by_recursive(root.right);
    }

    public void inorder_traversal_by_iteration(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postorder_traversal_by_recursion(TreeNode root){
        if (root == null){
            return;
        }
        postorder_traversal_by_recursion(root.left);
        postorder_traversal_by_recursion(root.right);
        System.out.print(root.data + " ");
    }

    public void postorder_traversal_by_iteration(TreeNode root){   // Very Very Important
        if (root == null){
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if (temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }
    }

    public void level_order_traversal(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    public int find_maximum_value(TreeNode root){
        if (root == null){
            return 0;
        }
        int max = root.data;
        int left = find_maximum_value(root.left);
        int right = find_maximum_value(root.right);
        if (left > max){
            max = left;
        }
        if (right > max){
            max = right;
        }
        return max;
    }

    public void create_max_heap(int[] arr){
        
    }

    public static void main(String[] args) {
        Binary_Tree bin_tree = new Binary_Tree();
        bin_tree.create_tree();
        bin_tree.preorder_traversal(bin_tree.root);
        System.out.println();
        bin_tree.preorder_traversal_by_iteration(bin_tree.root);
        System.out.println();
        bin_tree.inorder_traversal_by_recursive(bin_tree.root);
        System.out.println();
        bin_tree.inorder_traversal_by_iteration(bin_tree.root);
        System.out.println();
        bin_tree.postorder_traversal_by_recursion(bin_tree.root);
        System.out.println();
        bin_tree.postorder_traversal_by_iteration(bin_tree.root);
        System.out.println();
        bin_tree.level_order_traversal(bin_tree.root);
        System.out.println();
        System.out.println(bin_tree.find_maximum_value(bin_tree.root));
    }
}
