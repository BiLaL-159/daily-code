package Trees;

import java.util.*;

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

    public void iterativePreOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node popped= stack.pop();
            System.out.println(popped.data);
            if(popped.right!=null){
                stack.push(popped.right);
            }
            if(popped.left!=null) {
                stack.push(popped.left);
            }
        }
    }

    public void iterativeInOrderTraversal(Node root){
        if(root==null){
            return;
        }

        Stack<Node> stack= new Stack<>();
        Set<Node> set= new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
            Node top= stack.pop();
            if(!set.contains(top)){
                if(top.right!=null ){
                    stack.push(top.right);
                }
                stack.push(top);
                if(top.left!=null){
                    stack.push(top.left);
                }
                set.add(top);
            }
           else{
                System.out.println(top.data);
            }
        }
    }

    public List<Integer> inorderTraversal(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> answer= new ArrayList<>();
        Stack<Node> stack= new Stack<>();
        Set<Node> set= new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
            Node top= stack.pop();
            if(!set.contains(top)){
                if(top.right!=null ){
                    stack.push(top.right);
                }
                stack.push(top);
                if(top.left!=null){
                    stack.push(top.left);
                }
                set.add(top);
            }
            else{
               answer.add(top.data);
            }
        }
        return answer;
    }

    public void iteratvieInOrderT2(Node root){
        if(root==null){
            return ;
        }
        Stack<Node> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
           Node top= stack.peek();
           while(top.left!=null){
               stack.push(top.left);
               top=top.left;
           }
           Node popped= stack.pop();
           System.out.println(popped.data);
           if(popped.right!=null) {
               stack.push(popped.right);
           }
        }
    }

    public List<Integer> inorderTraversal2(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        Stack<Node> stack= new Stack<>();
        List<Integer> list= new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node top= stack.peek();
            while(top.left!=null){
                stack.push(top.left);
                top=top.left;
            }
            Node popped= stack.pop();
            list.add(popped.data);
            if(popped.right!=null) {
                stack.push(popped.right);
            }
        }
        return list;
    }

    public void postOrderTraversalIterative(Node root){
        Stack<Node> stack1= new Stack<>();
        Stack<Node> stack2= new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            root=stack1.pop();
            stack2.push(root);
            if(root.left!=null){
                stack1.push(root.left);
            }
            if(root.right!=null){
                stack1.push(root.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().data);
        }
    }



}
