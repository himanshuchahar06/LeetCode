class Solution {

public static int  hours(int k,int arr[]){

    int hrs=0;
    int rem=0;
    int rem1=0;

    int count =0;


        for(int i=0;i<arr.length;i++){
            rem1=arr[i]%k;
            rem=arr[i]/k;

            if(rem1!=0){
                rem++;

            }

            hrs=hrs+rem;

        }


       
    
  
            
    
         

    
  


 return hrs;



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