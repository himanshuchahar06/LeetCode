class Solution {

        public  static int days(int capacity,int[] arr){
         
         int day=1;
         int sum=0;

         for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];

            if(sum>capacity){
                
                day++;
                sum=arr[i];

            }
         }

         return day;
        }

    public int shipWithinDays(int[] weights, int days) {

        int max=    Integer.MIN_VALUE;
        int sum=0;

        for(int ele:weights){// i use for each loop ;
        max=Math.max(max,ele);
        sum=sum+ele;


        }

        // making function to find the number of days at partcular capacity

  
        // set the limit
        int l=max;
        int r=sum;
        int ans =-1;


        while(l<=r){
            int mid=l+(r-l)/2;

            if(days(mid, weights)<=days){
                r=mid-1;
                ans= mid;



            }else{
                l= mid+1;

            }
        }
        return ans;
    }
}