class Solution {

    public boolean possible(int[] bloomDay, int m, int k, int day) {

        int count = 0;
        int count1 = 0;

        for(int l = 0; l < bloomDay.length; l++){

            if(bloomDay[l] <= day){

                count++;

                if(count == k){
                    count1++;       // one bouquet made
                    count = 0;
                }

            }else{
                count = 0;
            }

            if(count1 == m){
                return true;
            }
        }

        return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        // first think brute force
        int n = bloomDay.length;

        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, bloomDay[i]);
        }

        if(n < m * k){
            return -1;
        }

        int l = 1;          
        int r = max;

        int ans = -1;         

        while(l <= r){

            int mid = l + (r - l) / 2;

            if(possible(bloomDay, m, k, mid)){   

                ans = mid;       
                r = mid - 1;

            }else{

                l = mid + 1;    
            }
        }

        return ans;            
    }
}