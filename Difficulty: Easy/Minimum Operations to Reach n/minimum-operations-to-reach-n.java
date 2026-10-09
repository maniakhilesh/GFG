class Solution {
    public int minOperation(int n) {
        if (n <= 0)
            return 0;
        return Integer.bitCount(n) + 31 - Integer.numberOfLeadingZeros(n);
    }
}