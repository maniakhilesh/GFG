class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                if(i-map.get(arr[i]) <= k) {
                    return true;
                }
            } 
            map.put(arr[i],i);
        }
        return false;
    }
}