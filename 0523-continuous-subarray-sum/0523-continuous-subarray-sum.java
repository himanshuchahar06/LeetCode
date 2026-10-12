class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int prefix[]= new int [nums.length+1];
      

        for (int i=0;i<nums.length;i++){
            prefix[i+1]=nums[i]+prefix[i];
        }

     HashMap<Integer,Integer> map= new HashMap<>();
     map.put(0,0);
    //  for(int x:prefix){
    //     map.put(x,map.getOrDefault(x,0)+1);

    //  }
     for(int i=1;i<prefix.length;i++){

        int rem = prefix[i]%k;


            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
      
     }
   

return false;
    
    }
}