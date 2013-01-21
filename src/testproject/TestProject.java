/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gsuero
 */
public class TestProject {

    static String getMinusString(String values, int quantity) {
        int substringValue = quantity;
        while (quantity > 0) {
            substringValue += --quantity;
        }
        return values.substring(0, substringValue);
    }
   public static void main(String argvs[]) throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }

public static void changeString(String s) {s = "brown"; }
}