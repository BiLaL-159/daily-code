package Basics;

import java.lang.reflect.Array;
import java.util.*;

public class Basic {
    public static void main(String[] args) {



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

    public static Stack<Integer> deleteMiddle(Stack<Integer> stack, int k){
        if(k==1){
            stack.pop();
            return stack;
        }
        int popped= stack.pop();
        deleteMiddle(stack,k-1);
        stack.push(popped);
        return stack;
    }

    public static Stack<Integer> reverseAStack(Stack<Integer> stack){
        if(stack.size()==1){
            return stack;
        }
        int popped= stack.pop();
        reverseAStack(stack);
        return insertCorrectly(stack, popped);
    }

    public static Stack<Integer> insertCorrectly(Stack<Integer> stack, int element ){
        if(stack.isEmpty()){
            stack.push(element);
            return stack;
        }
        int popped= stack.pop();
        insertCorrectly(stack, element);
        stack.push(popped);
        return stack;
    }

    public static void skipChar(String p, String up){
        if(up.length()==0){
            System.out.println(p );
            return;
        }
        char ch= up.charAt(0);
        if(ch=='a'){
            skipChar(p, up.substring(1));
        }
        else{
            skipChar(p+ch, up.substring(1));
        }
        return;
    }
    public static String skipChar( String up){
       if(up.length()==0){
           return up;
       }
       char ch= up.charAt(0);
       if(ch=='a'){
           return skipChar(up.substring(1));
       }
       else{
           return ch +skipChar(up.substring(1));
       }
    }

    public static String skipAString(String up, String skip){
        if(up.length()==0){
            return up;
        }

        if(up.startsWith(skip)){
           return skipAString(up.substring(skip.length()), skip);
        }
        else{
            char ch=up.charAt(0);
            return ch+ skipAString(up.substring(1), skip);
        }
    }

    public static String skipAppNotApple(String up){
        if(up.length()==0){
            return up;
        }

        if(up.startsWith("app") && !up.startsWith("apple")){
           return skipAppNotApple(up.substring(3));
        }
        else{
            char ch=up.charAt(0);
            return ch+ skipAppNotApple(up.substring(1));
        }
    }

    public static void subsets(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        subsets(p+ch, up.substring(1));
        subsets(p, up.substring(1));
    }
    public static void permutationWithSpace(String up, String p){
        if(up.length()==0){
            System.out.println(p);
            return;
        }

        char ch= up.charAt(0);
        permutationWithSpace(up.substring(1), p+" "+ch);
        permutationWithSpace(up.substring(1), p+ch);
    }

    public static void permutationWithCaseChange(String up, String p){
        if(up.length()==0){
            System.out.println(p);
            return;
        }

        String str=up.substring(0,1);



        permutationWithCaseChange(up.substring(1), p+str);
        permutationWithCaseChange(up.substring(1),  p+str.toUpperCase());

    }

    public static List<String> letterCasePermutation(String s){
        return helper(s, "");
    }

    public static List<String> helper(String up, String p){
        if(up.length()==0){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans= new ArrayList<>();

        char ch= up.charAt(0);

        if(ch >='0' && ch<='9'){
          ans.addAll(helper(up.substring(1),p+ch));
        }
        else{
           ans.addAll(helper(up.substring(1), p+Character.toUpperCase(ch))) ;
           ans.addAll(helper(up.substring(1), p+Character.toLowerCase(ch))) ;
        }
        return ans;
    }

    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i< heights.length; i++){
            map.put(heights[i],i);
        }

        Arrays.sort(heights);
        String[] ans= new String[names.length];
        for(int j=heights.length-1; j>=0; j--){
           ans[j]=names[map.get(heights[j])];
        }
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        LinkedList<String> list = new LinkedList<>();
        solve(list, n, n, "");
        return list;
    }

    public void solve(LinkedList<String> list, int open , int closed, String p){
        if(open==0 && closed==0){
            list.add(p);
            return;
        }
        if(open!=0){
            solve(list,open-1, closed, p+"(");
        }
        if(closed>open){
            solve(list, open, closed-1, p+")");
        }
    }
}
