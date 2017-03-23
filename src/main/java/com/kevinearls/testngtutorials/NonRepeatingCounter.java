package com.kevinearls.testngtutorials;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kearls on 21/03/2017.
 */
public class NonRepeatingCounter {

    public boolean checkNumber(String number) {
        char[] digits = number.toCharArray();
        Set<String> foundDigits = new HashSet<String>();
        for (int j=0; j < digits.length; j++) {
            String target = digits[j] + "";
            if (!foundDigits.contains(target)) {
                foundDigits.add(target);
            } else {
                return false;
            }
        }
        return true;
    }

    public List<String> getNotRepeatingNumbers(int min, int max) {
        List<String> results = new ArrayList<>();
        for (int i=min; i <= max; i++) {
            String number = Integer.toString(i);
            if (checkNumber(number)) {
                results.add(number);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        NonRepeatingCounter nrc = new NonRepeatingCounter();
        List<String> results = nrc.getNotRepeatingNumbers(1, 10000);
        System.out.println(results);
        System.out.println(results.size());
    }
}
