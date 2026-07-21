class Solution {
    public int maxIndexDifference(String s) {
        // code here
      int[] minStart = new int[26];
        Arrays.fill(minStart, Integer.MAX_VALUE);
        int maxDiff = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (idx == 0) {
                minStart[0] = Math.min(minStart[0], i);
                maxDiff = Math.max(maxDiff, 0);
            } else {
                if (minStart[idx - 1] != Integer.MAX_VALUE) {
                    minStart[idx] = Math.min(minStart[idx], minStart[idx - 1]);
                    maxDiff = Math.max(maxDiff, i - minStart[idx]);
                }
            }
        }
        return maxDiff;
    }
}