class Solution {
    public String frequencySort(String s) {
        char nums[]=  s.toCharArray();
         String ans = "";
        StringBuilder sb= new StringBuilder(ans);

        HashMap<Character,Integer>map= new HashMap<>();

        for(char arr:nums){
            map.put(arr,map.getOrDefault(arr,0)+1);

        }
       
        char ch=' ';

      while(!map.isEmpty()){

        int max=0;
      for(char arr1 : nums){

    if(map.containsKey(arr1) && map.get(arr1) > max){
        max = map.get(arr1);
        ch = arr1;
    }
}

        for(int i=0;i<max;i++){
           sb.append(ch);

        }
        map.remove(ch);

      }

return sb.toString();


    }
}