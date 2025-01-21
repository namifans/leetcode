class Thread {
    int id;
    int start;
    public Thread(int id, int start) {
        this.id = id;
        this.start = start;
    }
}
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        int prev = 0;
        Stack<Thread> stack = new Stack<>();
        for (String s : logs) {
            String[] arr = s.split(":");
            int id = Integer.parseInt(arr[0]);
            int actionTime = Integer.parseInt(arr[2]);
            String action = arr[1];
            if ("start".equals(action)) {
                Thread thread = new Thread(id, actionTime);
                if (!stack.isEmpty()) {
                    Thread top = stack.peek();
                    time[top.id] += actionTime - prev;
                }
                prev = actionTime;
                stack.push(thread);
            } else {
                Thread thread = stack.pop();
                time[thread.id] += actionTime - prev + 1;
                prev = actionTime + 1;
            }
        }
        return time;
    }
}