class Solution {
    public int strStr(String haystack, String needle) {

        for(int i = 0; i < haystack.length(); i++) {
            int size = 0;
            int hayPtr = i;
            int needlePtr = 0;

            while(needlePtr < needle.length() && hayPtr < haystack.length()) {
                if (haystack.charAt(hayPtr) == needle.charAt(needlePtr)) {
                    hayPtr++;
                    needlePtr++;
                    size++;
                } else {
                    size = 0;
                    needlePtr = 0;
                    break;

                }

                if (size >= needle.length()) {
                    return i;
                }

            }


        }

        return -1;
        
    }
}