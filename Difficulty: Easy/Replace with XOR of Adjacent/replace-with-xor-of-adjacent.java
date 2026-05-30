class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        
        int first = arr[0] ^ arr[1];
        int last = arr[n - 2] ^ arr[n - 1];
        int prev = arr[0];
        
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prev ^ arr[i + 1];    
            prev = curr;
        }
    
        arr[0] = first;
        arr[n - 1] = last;
    }
}