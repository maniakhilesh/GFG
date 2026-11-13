class Solution {
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {
            while (r1 != null) {
                s1.push(r1);
                r1 = r1.left;
            }
            while (r2 != null) {
                s2.push(r2);
                r2 = r2.left;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            if (top1.data == top2.data) {
                result.add(top1.data);
                s1.pop();
                s2.pop();
                r1 = top1.right;
                r2 = top2.right;
            } else if (top1.data < top2.data) {
                s1.pop();
                r1 = top1.right;
            } else {
                s2.pop();
                r2 = top2.right;
            }
        }

        return result;
    }
}

