class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];

        // Mark characters that need to be bold
        for (String word : dict) {
            int index = s.indexOf(word);
            while (index != -1) {
                // Mark all characters of the found word as bold
                for (int i = index; i < index + word.length(); i++) {
                    bold[i] = true;
                }
                // Find the next occurrence of the word
                index = s.indexOf(word, index + 1);
            }
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // Start of a bold section
            if (bold[i] && (i == 0 || !bold[i-1])) {
                result.append("<b>");
            }
            // Append the current character
            result.append(s.charAt(i));
            // End of a bold section
            if (bold[i] && (i == s.length() - 1 || !bold[i+1])) {
                result.append("</b>");
            }
        }

        return result.toString();
    }
}