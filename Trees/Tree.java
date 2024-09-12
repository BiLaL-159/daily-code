package Trees;

import java.util.Scanner;
public class Tree {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
        }

    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node:");
        int rootVal= scanner.nextInt();
        root= new Node(rootVal);
        populate(scanner,root);
    }

    private void populate(Scanner scanner, Node root){
        System.out.println("Do you want to insert to the left of "+ root.data);
        boolean left= scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left node");
            int data= scanner.nextInt();
            root.left= new Node(data);
            populate(scanner,root.left);
        }
        System.out.println("Do you want to insert to the right of"+ root.data);
        boolean right= scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right node");
            int data= scanner.nextInt();
            root.right= new Node(data);
            populate(scanner,root.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node root, String indent){
        if(root==null){
            return;
        }
        System.out.println(indent + root.data);
        display(root.left, indent+"\t");
        display(root.right, indent+"\t");
    }

    public void displaypretty(){
        displayPretty(root,0);
    }
    private void displayPretty(Node root, int level){
        if(root==null){
            return;
        }

    }

    public void preOrder(Node root){
        if(root==null){
            return ;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root);
    }





}
