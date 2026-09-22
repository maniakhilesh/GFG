class Solution {

    public String findLongestWord(String s, List<String> d) {

        // Sort: Longest words first. If lengths are equal, sort lexicographically.

        Collections.sort(d, (a, b) -> {

            if (a.length() != b.length()) {

                return b.length() - a.length(); // Descending order of length

            }

            return a.compareTo(b); // Ascending order lexicographically

        });



        for (String word : d) {

            // Early exit optimization: if the remaining words are shorter than a found answer, 

            // we could stop, but since we return the *first* match, it's already optimal.

            if (isSubsequence(word, s)) {

                return word; 

            }

        }



        return "";

    }



    private boolean isSubsequence(String word, String s) {

        int wordPtr = 0;

        int sPtr = 0;



        while (wordPtr < word.length() && sPtr < s.length()) {

            if (word.charAt(wordPtr) == s.charAt(sPtr)) {

                wordPtr++;

            }

            sPtr++;

        }



        return wordPtr == word.length();

    }

}