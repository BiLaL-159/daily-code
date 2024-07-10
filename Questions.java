import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

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
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map= new HashMap<>();

        int i=0;
        int j=0;
        int max=0;
        int ans=0;
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            if(map.get(s.charAt(j))>max){
                max=map.get(s.charAt(j));
            }
            if(j-i+1-max<=k){
                if(j-i+1>ans){
                    ans=j-i+1;
                }
                j++;
            }
            else if(j-i+1-max>k){
                while(j-i+1-max>k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
               j++;
            }

        }
        return ans;
    }


}
