package Trees;

import java.util.Scanner;
public class Tree {
    private static class Node{
        private int data;
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
        System.out.println("Do you want to insert to the left of"+ root);
        boolean left= scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left node");
            int data= scanner.nextInt();
            root.left= new Node(data);
            populate(scanner,root.left);
        }
        System.out.println("Do you want to insert to the right of"+ root);
        boolean right= scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right node");
            int data= scanner.nextInt();
            root.right= new Node(data);
            populate(scanner,root.right);
        }
        if(!left && !right){
            return;
        }

    }

}
