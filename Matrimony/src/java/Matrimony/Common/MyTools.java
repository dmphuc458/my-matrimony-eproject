/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Common;

/**
 *
 * @author TuyenDN
 */
public class MyTools {
    
    public static String RemoveSpecialChars(String str) {
        String[] chars = new String[]{",", ".", "/", "!", "@", "#", "$", "%", "^", "&", "*", "'", "\"", ";", "-", "_", "(", ")", ":", "|", "[", "]"};
        for (int i = 0; i < chars.length; i++) {
            if (str.contains(chars[i])) {
                str = str.replace(chars[i], "");
            }
        }
        return str;
    }
}
