class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        // code here
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i <n; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        int ans = 0;
        for(int i = 0; i< n; i++){
            int lo = i;
            int hi = n-1;
            int lowerIndex = -1;
            while(lo<=hi){
                int mid = lo+(hi-lo)/2;
                int arraySum = prefix[mid]-prefix[i]+arr[i];
                if(arraySum>=l){
                    lowerIndex=mid;
                    hi=mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            if(lowerIndex!=-1){
                lo=i;
                hi=n-1;
                int higherIndex = -1;
                
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    int arraySum=prefix[mid]-prefix[i]+arr[i];
                    if(arraySum<=r){
                        higherIndex=mid;
                        lo = mid+1;
                    }
                    else{
                        hi=mid-1;
                    }
                }
                if(higherIndex!=-1){
                    ans+=higherIndex-lowerIndex+1;
                }
            }
        }
        return ans;
    }
}