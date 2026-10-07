import java.util.Stack;

class Solution {
    public int calPoints(String[] s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            String op = s[i];

            if (op.equals("C")) {
                st.pop();
            } else if (op.equals("D")) {
                st.push(2 * st.peek());
            } else if (op.equals("+")) {
                int top = st.pop();
                int top2 = st.peek();
                int sum = top + top2;
                st.push(top);
                st.push(sum);
            } else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (st.size()>0) {
            sum += st.pop();
        }
        return sum;
    }
}