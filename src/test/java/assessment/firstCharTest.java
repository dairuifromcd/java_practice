package assessment;

import org.junit.Assert;
import org.junit.Test;

public class firstCharTest {

   @Test
   public void testFirstChar() {
       String[] inputs = {"abababac",
                          "",
                          "aaaaaaaaaaaaaa",
                          null,
                          "!@#$$#@!%",
                          "012341234",
                          "abcABC123+_)i)_+321CBAcba",
                          "a",
                          "a banana",
                          Character.toString('\uFFFF')};
       char char_max = Character.MAX_VALUE;
       char[] expects = {'c',
                         char_max,
                         char_max,
                         char_max,
                         '%',
                         '0',
                         'i',
                         'a',
                         ' ',
                         char_max};

       Assert.assertEquals("Should have same numbers of inputs and expects!", inputs.length, expects.length);

       for (int i = 0; i < inputs.length; i++) {
           System.out.println("input = " + inputs[i]);
           System.out.println("expect = " + expects[i] + " get = " + FirstChar.firstChar(new FleshedStream(inputs[i])));
           Assert.assertEquals("Failed to meet expect " + i, expects[i], FirstChar.firstChar(new FleshedStream(inputs[i])));
       }
   }
}