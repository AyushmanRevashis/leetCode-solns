class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }
      public void push(int x) {
        q.add(x);
        int k= q.size();
        for(int i=1;i<k;i++){
            q.add(q.remove());
        }

    }

    public int pop() {
       return q.remove();
    }

    public int top() {
        return q.peek();
    }

    // public void push(int x) {
    //     q.add(x);

    // }

    // public int pop() {
    //     int k = q.size();
    //     for (int i = 1; i < k; i++) {
    //         q.add(q.remove());
    //     }
    //     int top = q.remove();
    //     return top;
    // }

    // public int top() {
    //     int k = q.size();
    //     for (int i = 1; i < k; i++) {
    //         q.add(q.remove());
    //     }
    //     int top = q.peek();
    //     q.add(q.remove());
    //     return top;

    // }

    public boolean empty() {
        return (q.size() == 0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */