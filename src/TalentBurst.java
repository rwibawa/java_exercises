import java.util.Scanner;

/********************************************************************************
 * Copyright (c) 2015-2016 GE Digital. All rights reserved.                     *
 *                                                                              *
 * The copyright to the computer software herein is the property of GE Digital. *
 * The software may be used and/or copied only with the written permission of   *
 * GE Digital or in accordance with the terms and conditions stipulated in the  *
 * agreement/contract under which the software has been supplied.               *
 ********************************************************************************/

public class TalentBurst {
    public static void main(String[] args) {
        String sentence = "hi";
        String l = longestEvenWord(sentence);
        System.out.println(l);
    }

    private static String longestEvenWord(String sentence) {
        String result = "00";
        if (sentence == null || sentence.length() < 1 || sentence.length() > Math.pow(10,5)) {
            return result;
        }

        if (!sentence.matches("^[ A-Za-z]+$")) {
            return result;
        }


        Scanner scanner = new Scanner(sentence);
        while (scanner.hasNext()) {
            String word = scanner.next();
            int length = word.length();
            if (result.equals("00") && length == 2) {
                result = word;
                continue;
            }

            if (length % 2 == 0 && length > result.length()) {
                result = word;
            }
//            System.out.println(word);
        }

        return result;
    }


}
