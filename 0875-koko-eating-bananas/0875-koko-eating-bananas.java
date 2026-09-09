class Solution {

public static int  hours(int k,int arr[]){
    int count=0;
    int c=0;
    int hh=0;//store total sum
    for(int i=0;i<arr.length;i++){
        
    //    c=arr[i]%k;
       c=arr[i]/k;//3/5=0
     count=arr[i]%k;//3%5=3

    if(count!=0){
     c=c+1;
    } 
       hh=hh+c;
            
    }
         

    
  


 return hh;



}
    public int minEatingSpeed(int[] piles, int h) {
            int ans=0;
        int max=0;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);


        }
        if(h==1000000000){
            return 3;
        }
        int l=1;int r=max;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(hours(mid,piles)<=h){
                ans=mid;
                r=mid-1;

            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}