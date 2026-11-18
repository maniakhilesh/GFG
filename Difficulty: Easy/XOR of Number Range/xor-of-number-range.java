class Solution {
    public int findXOR(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }

    private int xorUpto(int n) {
        return switch (n & 3) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
}