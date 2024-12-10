class Solution {
    public int calculate(String s) {
        char[] arr = s.trim().replaceAll("\\s+","").toCharArray();
        Deque<Character> opStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
                if (i == arr.length - 1) {
                    if (!opStack.isEmpty() && (opStack.peekLast() == '*' || opStack.peekLast() == '/')) {
                        num = calculate(num, opStack, numStack);
                    }
                    numStack.addLast(num);
                }
            } else {
                if (!opStack.isEmpty() && (opStack.peekLast() == '*' || opStack.peekLast() == '/')) {
                    num = calculate(num, opStack, numStack);
                }
                numStack.addLast(num);
                num = 0;
                opStack.addLast(c);
            }
        }
        while (!opStack.isEmpty()) {
            char op = opStack.removeFirst();
            int num1 = numStack.removeFirst();
            int num2 = numStack.removeFirst();
            if (op == '+') {
                numStack.addFirst(num1 + num2);
            } else if (op == '-') {
                numStack.addFirst(num1 - num2);
            }
        }
        return numStack.peek();
    }

    private int calculate(int num, Deque<Character> opStack, Deque<Integer> numStack) {
        char op = opStack.removeLast();
        if (op == '*') {
            num *= numStack.removeLast();
        } else {
            num = numStack.removeLast() / num;
        } 
        return num;
    }
}