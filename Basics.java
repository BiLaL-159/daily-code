import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        NDigitInc("",0,2,list);
        System.out.println(list);
    }

    public static void NDigitInc(String p, int index, int n, ArrayList<Integer> list){
        if(index==n){
            int localval= Integer.parseInt(p);
            list.add(localval);
            return;
        }

        if(index==0){
            for(int i=1; i<10; i++){
                String toAdd=Integer.toString(i);
                NDigitInc(p+toAdd, index+1, n, list);
            }
        }

        else{
            int prev= Integer.parseInt(p.substring(index-1,index));
            for(int i=prev+1; i<10; i++){
                String toAdd=Integer.toString(i);
                NDigitInc(p+toAdd, index+1, n, list);
            }
        }
    }

}
