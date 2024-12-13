class Num {
    int i;
    int val;
    public Num(int i, int val) {
        this.i = i;
        this.val = val;
    }
}

class Solution {
    public int maximumSwap(int num) {
        Queue<Num> queue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Num n1, Num n2) {
                if (n1.val == n2.val) {
                    return n2.i - n1.i;
                } else {
                    return n2.val - n1.val;
                }
            }
        });
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            queue.offer(new Num(i, digit));
        }
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty())
                break;
            Num n = queue.peek();
            if (i > n.i) {
                queue.remove();
                i--;
            }
            int digit = arr[i] - '0';
            if (n.val > digit && i != n.i) {
                char tmp = arr[i];
                arr[i] = arr[n.i];
                arr[n.i] = tmp;
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }
}