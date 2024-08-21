package BS;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int pile: piles){
            if(pile>max){
                max=pile;
            }
        }
        int l=0;
        int r=max+1;
        while(l<r){
            int mid= l+(r-l)/2;
            if(isValid(mid,piles,h)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean isValid(int value, int[] piles, int h){
        int totalHours=0;
        for(int i=0; i<piles.length;i++){
            totalHours+=piles[i]/value;
            if(piles[i]%value!=0){
                totalHours++;
            }
        }
        return totalHours<=h;
    }

}
