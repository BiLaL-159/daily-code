package Basics;

import java.lang.reflect.Array;
import java.util.*;

public class Basic {
    public static void main(String[] args) {
       String up="4577";
       ArrayList<String> ans= new ArrayList<>();
        maxInKSwaps(up,0, ans, 2);
        System.out.println(ans);


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

    public static void permutations(String p, String up){
        if(p.length()==up.length()){
            System.out.println(p);
            return;
        }

        for(int i=0; i<up.length();i++){
            char ch=up.charAt(i);
            permutations(p+ch, up);
        }
    }

    public static void permutationsWORep(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }

        for(int i=0; i<up.length();i++){
            char ch=up.charAt(i);
            permutationsWORep(p+ch,up.substring(0,i)+up.substring(i+1));
        }
    }

    public static ArrayList<String> permutationsWORepList(String p, String up){
        if(up.length()==0){
            ArrayList<String> locallist= new ArrayList<>();
            locallist.add(p);
            return locallist;
        }
        ArrayList<String> ans= new ArrayList<>();
        for(int i=0; i<up.length();i++){
            char ch=up.charAt(i);
            ans.addAll(permutationsWORepList(p+ch,up.substring(0,i)+up.substring(i+1)));
        }
        return ans;
     }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list= new ArrayList<>();
        return helper(nums, 0, list);
    }

    public List<List<Integer>> helper(int[] nums, int index, ArrayList<Integer> p) {
        if (index == nums.length) {
            List<List<Integer>> locallist = new ArrayList<>();
            locallist.add(p);
            return locallist;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int choice = nums[index];
        List<List<Integer>> leftlist = helper(nums, index + 1, p);
        p.add(choice);
        List<List<Integer>> rightlist = helper(nums, index + 1, p);
        ans.addAll(leftlist);
        ans.addAll(rightlist);
        return ans;
    }

    public static void uniquePermute(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }
        HashSet<Character> set= new HashSet<>();
        for(int i=0; i<up.length();i++){
            char ch= up.charAt(i);
            if(set.contains(ch)){
                continue;
            }
            else{
                set.add(ch);
                uniquePermute(p+ch, up.substring(0,i)+up.substring(i+1));
            }
        }

    }

    public static void backtrackingPermute(String up, int index, ArrayList<String> list){
        if(index==up.length()){
            list.add(up);
            return;
        }
        char ch= up.charAt(index);
        HashSet<Character> set= new HashSet<>();
        for(int i=index; i<up.length(); i++){
           char toswap= up.charAt(i);
            if(set.contains(toswap)){
                continue;
            }
            else{
                set.add(toswap);
               String swapped= swap(up,  i ,  index);
               backtrackingPermute(swapped,index+1,list);
            }
        }
    }
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }


    public static String maxInKSwapsRecur(String up){
       ArrayList<String> listOfAns= helperfun(up, "");
        System.out.println(listOfAns);
       int ans=0;
        for(String element: listOfAns){
            int val= Integer.parseInt(element);
            ans= Math.max(ans, val);
        }
        return Integer.toString(ans);
    }
    public static ArrayList<String> helperfun(String up, String p){
        if(up.length()==0){
            ArrayList<String> locallist= new ArrayList<>();
            locallist.add(p);
            return locallist;
        }
        ArrayList<String> ans= new ArrayList<>();
        for(int i=0; i<up.length(); i++){
            char ch= up.charAt(i);
            ans.addAll(helperfun(up.substring(0,i)+ up.substring(i+1),p+ch));
        }
        return ans;
    }

    public static void maxInKSwaps(String up, int index, ArrayList<String> ans, int k){
        if(k==0 || index==up.length()){
            ans.add(up);
            return;
        }
        // condition --> from index+1 to length
        // find the greatest val
        // for every i from index+1 to length,  if i>index && i==max
        // call recursion, else not
        for(int i=index+1; i<up.length(); i++){
            if((Integer.parseInt(up.substring(i, i + 1)) < Integer.parseInt(up.substring(index,index+1)))){
                continue;
            }
            else{
                String swapped= swap(up, i, index);
                maxInKSwaps(swapped, index+1, ans, k-1);
            }

        }
    }
}
