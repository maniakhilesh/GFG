class Solution {
    public int countFriendsPairings(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        // prev2 = f(i-2), prev1 = f(i-1)
        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {

            // Current friend stays single
            int choice1 = prev1;

            // Current friend pairs with one of the (i-1) friends
            int choice2 = (i - 1) * prev2;

            // Total ways for i friends
            int curr = choice1 + choice2;

            // Shift values for next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}