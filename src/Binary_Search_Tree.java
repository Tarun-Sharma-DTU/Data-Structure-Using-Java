import java.util.LinkedList;
import java.util.Queue;

public class Binary_Search_Tree {
    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }
    public void insert_node(int value){
        root = insert_node(root, value);
    }

    public TreeNode insert_node(TreeNode root, int value){
        if (root == null){
            TreeNode new_node = new TreeNode(value);
            root = new_node;
            return root;
        }
        if (value < root.data){
            root.left = insert_node(root.left, value);
        }
        else {
            root.right = insert_node(root.left, value);
        }
        return root;
    }

    public void inorder_traversal(TreeNode root){
        if (root == null){
            return;
        }
        inorder_traversal(root.left);
        System.out.print(root.data + " ");
        inorder_traversal(root.right);
    }

    public TreeNode search_key(TreeNode root, int value){
        if (root == null || root.data == value){
            return root;
        }
        if (value < root.data){
            return search_key(root.left, value);
        }
        else {
            return search_key(root.right, value);
        }
    }
    public TreeNode search_key(int value){
        return search_key(root, value);
    }

    public static void main(String[] args) {
        Binary_Search_Tree my_tree = new Binary_Search_Tree();
        my_tree.insert_node(30);
        my_tree.insert_node(16);
        my_tree.insert_node(14);
        my_tree.insert_node(12);
        my_tree.insert_node(6);
        my_tree.inorder_traversal(my_tree.root);
        System.out.println();
        if (my_tree.search_key(16) != null){
            System.out.println("Key Found");
        }
        else {
            System.out.println("Not Found");
        }
    }
}
