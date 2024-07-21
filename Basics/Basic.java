package Basics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Basic {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);
        stack.push(9);
        sortStack(stack);
        while(!stack.isEmpty()){
            stack.pop();
        }

    }
    public static int fib(int n){
        if(n==2 || n==1){
            return 1;
        }

        return fib(n-1) + fib(n-2);

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        if(list.size()==1){
            return list;
        }
        int removedElement= list.removeLast();
        return insertInSorted(sort(list), removedElement);
    }

    public static ArrayList<Integer> insertInSorted(ArrayList<Integer> list, int element){
        if(list.getLast()<=element || list.isEmpty()){
            list.add(element);
            return list;
        }
        int removedElement= list.removeLast();
        insertInSorted(list,element);
        list.add(removedElement);
        return list;
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack){
        if(stack.size()==1){
            return stack;
        }
        int popped= stack.pop();
        System.out.println(popped);
        return insertStack(sortStack(stack), popped);
    }

    public static Stack<Integer> insertStack(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()<=element  ){
            stack.push(element);
            return stack;
        }
        int popped= stack.pop();
        insertStack(stack,element);
        stack.push(popped);
        return stack;
    }

}
