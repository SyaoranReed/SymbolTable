/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class OrderedLinkedListTest
{

    OrderedLinkedList<String> list;

    public OrderedLinkedListTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        this.list = new OrderedLinkedList<String>();
        this.list.add("A");
        this.list.add("B");
        this.list.add(("C"));
        this.list.add("D");

    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of iterator method, of class OrderedLinkedList.
     */
    @Test
    public void removeIndexTest()
    {
        int valor = this.list.size();
        this.list.remove(3);
        assertEquals(valor - 1, this.list.size(), 0);
    }

    @Test
    public void removeItemTest()
    {
        int valor = this.list.size();
        this.list.remove("B");
        assertEquals(valor - 1, this.list.size(), 0);
    }
    
    @Test
    public void iteratorTest()
    {
        String s = "";
        for(String string: this.list){
            s += string;
        }
        assertTrue("ABCD".compareTo(s) == 0);
    }
    
    @Test
    public void sortTest()
    {
        this.list.add("B");
        String s = "";
        for(String string: this.list){
            s += string;
        }
        assertTrue("ABBCD".compareTo(s) == 0);
    }

    @Test
    public void getTest()
    {
        assertTrue(list.get(3).compareTo("D") == 0);
    }
}
