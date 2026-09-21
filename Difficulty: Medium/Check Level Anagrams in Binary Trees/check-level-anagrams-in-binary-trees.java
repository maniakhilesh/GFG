class Solution {
    int maxLevel1;
    int maxLevel2;
    int maxLevel;
    HashMap<Integer,ArrayList<Integer>> map1;
    HashMap<Integer,ArrayList<Integer>> map2;

    public void dfs(Node root , int level , HashMap<Integer,ArrayList<Integer>> map){
        if(root == null){
            return;
        }
        maxLevel = Math.max(maxLevel , level);
        if(!map.containsKey(level)){
            map.put(level , new ArrayList<>());
        }
        map.get(level).add(root.data);
        dfs(root.left , level+1 , map);
        dfs(root.right , level+1 , map);
    }
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        maxLevel1 = 0;
        maxLevel2 = 0;

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        maxLevel = 0;
        dfs(root1 , 0 , map1);
        maxLevel1 = maxLevel;

        maxLevel = 0;
        dfs(root2 , 0 , map2);
        maxLevel2 = maxLevel;

        if(maxLevel1 != maxLevel2) return false;

        for(int l = 0 ; l <= maxLevel1 ; l++){
            ArrayList<Integer> list1 = map1.get(l);
            ArrayList<Integer> list2 = map2.get(l);
            if (list1.size() != list2.size()) return false;

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int v : list1) {
                freq.put(v, freq.getOrDefault(v, 0) + 1);
            }
            for (int v : list2) {
                int newCount = freq.getOrDefault(v, 0) - 1;
                if (newCount < 0) return false;   
                freq.put(v, newCount);
            }
            for (int count : freq.values()) {
                if (count != 0) return false;
            }
        }
        return true;
    }
}