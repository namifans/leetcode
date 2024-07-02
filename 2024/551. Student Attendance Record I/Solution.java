class Solution {

    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int absentCount = 0, lateCount = 0;
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case 'A': {
                    absentCount++;
                    lateCount = 0;
                    if (absentCount >=2 )
                        return false;
                } break;
                case 'L': {
                    lateCount++;
                    if (lateCount >= 3)
                        return false;
                } break;
                case 'P': {
                    lateCount = 0;
                } break;
            }
        }
        return true;
    }
}