class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // Get length of the string
        int n = s.length();

        // Check whether length is a power of 2
        // Example: 1, 2, 4, 8, 16 ...
        if ((n & (n - 1)) == 0) {
            k = k / 2;
        } else {
            k = k * 2;
        }
        // StringBuilder is used as a stack
        StringBuilder ans = new StringBuilder();

        // Traverse each character of the string
        for (int i = 0; i < n; i++) {
            // Remove larger characters from the end
            // if current character is smaller
            while (ans.length() > 0
                    && ans.charAt(ans.length() - 1) > s.charAt(i)
                    && k > 0) {

                // Remove last character
                ans.deleteCharAt(ans.length() - 1);

                // One deletion used
                k--;
            }

            // Add current character
            ans.append(s.charAt(i));
        }

        // If deletions are still remaining,
        // remove characters from the end
        while (ans.length() > 0 && k > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }

        // If all characters are removed
        if (ans.length() == 0) {
            return "-1";
        }

        // Return final lexicographically smallest string
        return ans.toString();
    }
}