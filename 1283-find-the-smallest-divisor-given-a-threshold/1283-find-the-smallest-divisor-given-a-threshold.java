class Solution {

    public static int anss(int num,int arr[]){
        int summ=0;

        for(int i=0;i<arr.length;i++){
            int div= (arr[i]+num-1)/num;

             summ=summ+div;

        }

        return summ;

    }

    public int smallestDivisor(int[] nums, int threshold) {
   //binary search on answer;

   int max=0;

   for(int i=0;i<nums.length;i++){
    max=Math.max(max,nums[i]);

   }

   int l=1;
   int r=max;
   int ans=0;

   while(l<=r){

    int mid=l+(r-l)/2;

    if(anss(mid,nums)<=threshold){
        ans=mid;
        r=mid-1;
    }else{
        l= mid+1;

    }
   }
      


return ans ;



    }
}