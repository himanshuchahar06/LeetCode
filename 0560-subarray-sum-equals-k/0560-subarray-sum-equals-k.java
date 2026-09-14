class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer>map= new  HashMap<>();


        int prefix[]= new int [nums.length+1];
        // prefix[0]= nums[0];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int count=0;
    
      for(int arr:prefix){
        if(map.containsKey(arr-k)){
            count=count+map.get(arr-k);
        }
        map.put(arr,map.getOrDefault(arr,0)+1);
      }
      return count;
    }
}