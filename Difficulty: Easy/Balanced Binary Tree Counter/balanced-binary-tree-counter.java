class Solution {
    public int countBT(int h) {
        // code here
        long mod = 1000000007L;
        long a = 1, b = 1;
        for (int i = 2; i <= h; i++) {
            long c = (b * ((2 * a % mod + b) % mod)) % mod;
            a = b;
            b = c;
        }
        return (int) b;
    }
}