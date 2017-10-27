class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;
        StringBuilder result = new StringBuilder();
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry == 1) {
            int bitA = idxA >= 0 ? Character.getNumericValue(a.charAt(idxA--)) : 0;
            int bitB = idxB >= 0 ? Character.getNumericValue(b.charAt(idxB--)) : 0;
            int sum = bitA ^ bitB ^ carry;
            carry = (bitA + bitB + carry) >= 2 ? 1 : 0;
            result.insert(0, sum);
        }
        return result.toString();
    }
}