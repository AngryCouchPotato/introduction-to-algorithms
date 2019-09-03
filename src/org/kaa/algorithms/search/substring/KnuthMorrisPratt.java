package org.kaa.algorithms.search.substring;

public class KnuthMorrisPratt {

    private int[][] dfa;
    private String pattern;

    public KnuthMorrisPratt(String pattern) {
        this.pattern = pattern;
        prepareDFA(pattern);
    }

    private void prepareDFA(String pattern) {
        int patternLength = pattern.length();
        int alphabethLength = 256;
        dfa = new int[alphabethLength][patternLength];
        dfa[pattern.charAt(0)][0] = 1;
        for(int x = 0, j = 0; j < patternLength; j++) {
            for(int c = 0; c < alphabethLength; c++) {
                dfa[c][j] = dfa[c][x];          // Copy mismatch cases.
            }
            dfa[pattern.charAt(j)][j] = j + 1;  // Set match case.
            x = dfa[pattern.charAt(j)][x];      // Update restart state.
        }
    }

    public int search(String text){
        int i, textLength = text.length();
        int j, patternLength = pattern.length();
        for(i = 0, j = 0; i < textLength && j < patternLength; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if(j == patternLength ){
            return i - patternLength;
        } else {
            return textLength;
        }
    }
}
