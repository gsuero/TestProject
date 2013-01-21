/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import testproject.map.GarisHashMap;

public class GarisHashMapTest {

    @Test
    public void readWriteSimpleValue() {
        GarisHashMap<String, Integer> map = new GarisHashMap<String, Integer>();

        map.put("duck", 7);
        map.put("goose", 42);

        assertEquals(Integer.valueOf(7), map.get("duck"));
        assertEquals(Integer.valueOf(42), map.get("goose"));
    }

    @Test
    public void getSomethingThatIsntThere() {
        GarisHashMap<Integer, String> map = new GarisHashMap<Integer, String>();
        assertEquals(null, map.get(42));
    }

    @Test
    public void overWriteValue() {
        GarisHashMap<Integer, String> map = new GarisHashMap<Integer, String>();

        map.put(42, "meh");
        assertEquals("meh", map.get(42));
        map.put(42, "we have the technology to rebuild him");
        assertEquals("we have the technology to rebuild him", map.get(42));
    }

    @Test
    public void doNotOverwriteValueJustBecauseSameHashCode() {
        String diffButSameHash1 = "Ea";
        String diffButSameHash2 = "FB";

        //prove they really have the same hash
        assertEquals(diffButSameHash1.hashCode(), diffButSameHash2.hashCode());

        GarisHashMap<String, String> map = new GarisHashMap<String, String>();

        //prove they really go into the same bucket (yes, might be overdoing it here!)
        assertEquals(map.bucketIndexForKey(diffButSameHash1), map.bucketIndexForKey(diffButSameHash2));

        map.put(diffButSameHash1, "We Are All Unique");
        map.put(diffButSameHash2, "I'm Not!");

        //same hash but amazingly still different values!
        assertEquals("We Are All Unique", map.get(diffButSameHash1));
        assertEquals("I'm Not!", map.get(diffButSameHash2));
    }
}
