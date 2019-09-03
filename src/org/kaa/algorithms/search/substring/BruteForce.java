package org.kaa.algorithms.search.substring;

class BruteForce {

    static int search(String pattern, String text) {
        int textLength = text.length();
        int patternLength = pattern.length();
        for(int i = 0; i <= (textLength - patternLength); i++){
            int j;
            for(j = 0; j < patternLength; j++){
                if(text.charAt(i + j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == patternLength){
                return i;
            }
        }
        return textLength;
    }

    static int search2(String pattern, String text) {
        int i, textLength = text.length();
        int j, patternLength = pattern.length();
        for(i = 0, j = 0; i < textLength && j < patternLength; i++){
            if(text.charAt(i) == pattern.charAt(j)){
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if(j == patternLength){
            return i - patternLength;
        } else {
            return textLength;
        }
    }
}
