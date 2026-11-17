class Solution {
    public boolean findPattern(String s) {
        int cnt = 0;
        char[] arr = s.toCharArray();
        for(char ch: arr) {
            if(ch =='x') cnt += 1;
            else cnt -= 1;
            if(cnt < 0) return false;
        }
        return cnt == 0;
    }
}