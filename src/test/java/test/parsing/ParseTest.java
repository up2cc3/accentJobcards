package test.parsing;


import com.accent.MegaParser;
import com.accent.Order;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ccc on 24/04/2017.
 */
public class ParseTest {


    @Test
    public void testOneOrderSimple() {
        List<String> lines = Arrays.asList("DBI\t\t\t\t\t\t\t\t\tDBI Whangarei", "38900 B&T", "1 table round", "2 black tables");
        MegaParser parser = new MegaParser();
        List<Order> orders = parser.parse(lines);
        assertEquals("Should be 1 order", 1, orders.size());
        assertEquals("Should be 2 job orders ", 2, orders.get(0).getDepts().get(0).items.size());
    }

    @Test
    public void testOneOrder() {
        List<String> lines = Arrays.asList("DBI\t\t\t\t\t\t\t\t\tDBI Whangarei", "38900 B&T", "1 table round", "2 black tables", "1 screen");
        MegaParser parser = new MegaParser();
        List<Order> orders = parser.parse(lines);
        assertEquals("Should be 1 order", 1, orders.size());
        assertEquals("Should be 2 job orders for 0", 2, orders.get(0).getDepts().get(0).items.size());
        assertEquals("Should be 2 job orders for 1", 1, orders.get(0).getDepts().get(1).items.size());
    }

    @Test
    public void testBracketsOrder() {
        List<String> lines = Arrays.asList("DBI\t\t\t\t\t\t\t\t\tDBI Whangarei", "38900 B&T", "1 table round", "2 black tables", "1 screen","2 screen brackets");
        MegaParser parser = new MegaParser();
        List<Order> orders = parser.parse(lines);
        assertEquals("Should be 1 order", 1, orders.size());
        assertEquals("Should be 2 job orders for 0", 2, orders.get(0).getDepts().get(0).items.size());
        assertEquals("Should be 2 job orders for 1", 1, orders.get(0).getDepts().get(1).items.size());
    }

    @Test
    public void testStriperOrder() {
        List<String> lines = Arrays.asList("DBI\t\t\t\t\t\t\t\t\tDBI Whangarei", "38900 B&T", "1 table round", "2 black tables", "1 screen","2 screen brackets");
        MegaParser parser = new MegaParser();
        List<Order> orders = parser.parse(lines);
        assertEquals("Should be 2 job orders for 1", 1, orders.get(0).getDepts().get(1).items.size());
    }


}
