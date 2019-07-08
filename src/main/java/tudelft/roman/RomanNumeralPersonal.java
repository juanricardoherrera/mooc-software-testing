/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudelft.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 *
 * @author juan.herrera
 */
public class RomanNumeralPersonal {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String romanNumeral) {
        int result = 0;

        if (!Optional.ofNullable(romanNumeral).isPresent()) {
            return result;
        }
        if(!Pattern.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$", romanNumeral))
            return result;
        char[] arrayValues = romanNumeral.toCharArray();
        try {
            for (int i = 0; i < arrayValues.length; i++) {

                if (i < arrayValues.length - 1) {
                    if (map.get(arrayValues[i + 1]) > map.get(arrayValues[i])) {
                        result -= map.get(arrayValues[i]);
                    } else {
                        result += map.get(arrayValues[i]);
                    }
                } else {
                    result += map.get(arrayValues[i]);
                }
            }
        } catch (Exception e) {
            return result;
        }

        return result;
    }

}
