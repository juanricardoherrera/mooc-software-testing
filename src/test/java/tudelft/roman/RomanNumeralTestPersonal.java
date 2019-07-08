/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author juan.herrera
 */
public class RomanNumeralTestPersonal {

    RomanNumeralPersonal numeralPersonal;
    @BeforeEach
    public void initialize(){
        numeralPersonal = new RomanNumeralPersonal();
    }
    
    
    @Test
    public void testSingleValue(){
        int result = numeralPersonal.convert("I");
        Assertions.assertEquals(result, 1);
    }
    
    @Test
    public void testTwoSameValue(){
        int result = numeralPersonal.convert("II");
        Assertions.assertEquals(result, 2);
    }
    
    @Test
    public void testRestValue(){
        int result = numeralPersonal.convert("IV");
        Assertions.assertEquals(result, 4);
    }
    
    @Test
    public void testRestLongValue(){
        int result = numeralPersonal.convert("CMXCIX");
        Assertions.assertEquals(result, 999);
    }
    
    @Test
    public void testWrongLettersValue(){
        int result = numeralPersonal.convert("AA");
        Assertions.assertEquals(result, 0);
    }
    
    @Test
    public void testWrongRuleIXCValue(){
        int result = numeralPersonal.convert("IIII");
        Assertions.assertEquals(result, 0);
    }
    
    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = numeralPersonal.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
    
}
