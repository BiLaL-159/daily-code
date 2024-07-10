import java.util.ArrayList;

public class Questions {
    public static void main(String[] args) {
       print1ToN(1,10);
        System.out.println(factorial(5));
        ArrayList<Integer> list= new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);
        System.out.println(sortUsingRecursion(list));
    }

    public static void print1ToN(int current,int n){
        if(current==n){
            System.out.println(n);
            return;
        }

        System.out.println(current);
        print1ToN(current+1, n);
    }
    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n* factorial(n-1);
    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftheight= maxDepth(root.left);
        int rightheight=maxDepth(root.right);

        return Math.max(leftheight,rightheight)+1;
    }

    public static ArrayList<Integer> sortUsingRecursion(ArrayList<Integer> list){
        if(list.size()==1){
            return list;
        }
        int element= list.getLast();
        list.remove(element);
        ArrayList<Integer> newlist= new ArrayList<>(sortUsingRecursion(list));
        return insert(newlist, element);
    }
    public static ArrayList<Integer> insert(ArrayList<Integer> list, int element) {
        if (list.isEmpty() || element >= list.getLast()) {
            list.add(element);
            return list;
        }
        int currelement= list.getLast();
        list.remove(currelement);
        list=insert(list,element);
        list.add(currelement);
        return list;
    }


}
