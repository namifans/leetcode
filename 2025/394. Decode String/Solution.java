class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num = num * 10 + arr[i] - '0';
            } else if (arr[i] == '[') {
                numStack.push(num);
                charStack.push("" + arr[i]);
                num = 0;
            } else if (arr[i] == ']') {
                StringBuilder sb = new StringBuilder();
                while (!"[".equals(charStack.peek())) {
                    sb.insert(0, charStack.pop());
                }
                charStack.pop();
                int times = numStack.pop();
                String tmp = sb.toString();
                for (int k = 1; k < times; k++) {
                    sb.append(tmp);
                }
                charStack.push(sb.toString());
            } else {
                charStack.push("" + arr[i]);
            }
        }
        while (!charStack.isEmpty()) {
            res.insert(0, charStack.pop());
        }
        return res.toString();
    }
}