class Solution {
    public int findMiddleIndex(int[] nums) {


       
        int prefix[]=new int [nums.length+1];
        // int suffix[]=  new int [nums.length];
     
        prefix[0]= nums[0];
        
        for(int i=1;i<nums.length;i++){

            prefix[i]=prefix[i-1]+nums[i];

        }
        // suffix[nums.length-1]=nums[nums.length-1];
        // for(int i=nums.length-2;i>=0;i--){
        //     suffix[i]=suffix[i+1]+nums[i];

        // }
        
        int index = -1;

        for(int i = 0; i < nums.length; i++){

            int left=0;

            if(i>0){
                left=prefix[i-1];

            }
               int right = prefix[nums.length - 1] - prefix[i];

    if(left == right){
        index = i;
        return index;
    }
        }

        return -1;
        


        
    }
}