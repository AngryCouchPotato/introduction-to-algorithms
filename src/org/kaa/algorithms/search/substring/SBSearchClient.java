package org.kaa.algorithms.search.substring;


public class SBSearchClient {

    private static final String TEXT = "An obvious method for substring search is to check, for each possible position in the text at which the pattern could match, whether it does in fact match. The search() method below operates in this way to find the first occurrence of a pattern string pat in a text string txt. The program keeps one pointer (i) into the text and another pointer (j) into the pattern. For each i, it resets j to 0 and increments it until finding a mismatch or the end of the pattern (j == M). If we reach the end of the text (i == N-M+1) before the end of the pattern, then there is no match: the pattern does not occur in the text. Our convention is to return the value N to indicate a mismatch."
            + "In a typical text-processing application, the j index rarely increments so the running time is proportional to N. Nearly all of the compares find a mismatch with the first character of the pattern. For example, suppose that you search for the pattern pattern in the text of this paragraph. There are 196 characters up to the end of the first occurrence of the pattern, only 7 of which are the character p (not including the p in pattern). Also, there is only 1 other occurrence of pa and no other occurences of pat, so the total number of character compares is 196+7+1, for an average of 1.041 compares per character in the text. On the other hand, there is no guarantee that the algorithm will always be so efficient. For example, a pattern might begin with a long string of As. If it does, and the text also has long strings of As, then brute-force substring search will be slow."
            + "Such degenerate strings are not likely to appear in English text, but they may well occur in other applications (for example, in binary texts), so we seek better algorithms. The alternate implementation at the bottom of this page is instructive. As before, the program keeps one pointer (i) into the text and another pointer (j) into the pattern. As long as they point to matching characters, both pointers are incremented. This code performs precisely the same character compares as the previous implementation. To understand it, note that i in this code maintains the value of i+j in the previous code: it points to the end of the sequence of already-matched characters in the text (where i pointed to the beginning of the sequence before). If i and j point to mismatching characters, then we back up both pointers: j to point to the beginning of the pattern and i to correspond to moving the pattern to the right one position for matching against the text.";
    private static final String PATTERN = "maintains";

    public static void main(String[] args) {
        testBruteForce();
        testBruteForce2();
        testKnuthMorrisPratt();
    }

    private static void testBruteForce(){
        System.out.println("start test BruteForce algorithm");
        long startTime = System.currentTimeMillis();
        int result = BruteForce.search(PATTERN, TEXT);
        long endTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime + ", endTime = " + endTime + ", ExecutionTime = " + ((endTime - startTime) * 1000) + ", result = " + result);
        System.out.println("finish test BruteForce algorithm");
    }

    private static void testBruteForce2(){
        System.out.println("start test BruteForce algorithm");
        long startTime = System.currentTimeMillis();
        int result = BruteForce.search2(PATTERN, TEXT);
        long endTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime + ", endTime = " + endTime + ", ExecutionTime = " + ((endTime - startTime) * 1000) + ", result = " + result);
        System.out.println("finish test BruteForce algorithm");
    }

    private static void testKnuthMorrisPratt(){
        System.out.println("start test KnuthMorrisPratt algorithm");
        long preStartTime = System.currentTimeMillis();
        KnuthMorrisPratt knuthMorrisPratt = new KnuthMorrisPratt(PATTERN);
        long preEndTime = System.currentTimeMillis();
        System.out.println("preStartTime = " + preStartTime + ", preEndTime = " + preEndTime + ", ExecutionTime = " + ((preEndTime - preStartTime) * 1000));
        long startTime = System.currentTimeMillis();
        int result = knuthMorrisPratt.search(TEXT);
        long endTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime + ", endTime = " + endTime + ", ExecutionTime = " + ((endTime - startTime) * 1000) + ", result = " + result);
        System.out.println("finish test KnuthMorrisPratt algorithm");
    }
}
