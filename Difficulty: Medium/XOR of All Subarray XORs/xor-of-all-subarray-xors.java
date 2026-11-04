class Solution {
    public int subarrayXor(int[] arr) {
        // code here
        int n =arr.length;
        int res = 0;
        for(int i=0;i<n;i++){
            int total = (i+1)*(n-i);
            if (total%2==0) continue;
                res^=arr[i];
        }
        return res;
    }
}

