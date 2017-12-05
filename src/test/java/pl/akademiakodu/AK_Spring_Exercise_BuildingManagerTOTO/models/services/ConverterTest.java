package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services;

/**
 * Imports section
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ConverterTest {

    private static Converter converter;

    @BeforeClass public static void start() {
        converter = new Converter();
    }

    @AfterClass public static void stop() throws Exception {
        converter = null;
    }

    /**
     * testing proper working of replacing given string into integer
     * @throws Exception in case of given invalid user input
     */
    @Test public void testStringToInt() throws Exception {
        assertEquals(converter.stringIntoInteger("552"), 552);
        assertEquals(converter.stringIntoInteger("-3"), -3);
        assertEquals(converter.stringIntoInteger("0"), 0);
        try{
            converter.stringIntoInteger("abc");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse int from string");
        }
        try{
            converter.stringIntoInteger("   5  2  ");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse int from string");
        }
        try{
            converter.stringIntoInteger(" 8");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse int from string");
        }try{
            converter.stringIntoInteger("5o9");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse int from string");
        }
    }

    /**
     * testing proper working of replacing given string into big integer
     * @throws Exception in case of given invalid user input
     */
    @Test public void testStringToBigInt() throws Exception {
        assertEquals(converter.stringIntoBigInteger("522") , new BigInteger("522"));
        assertEquals(converter.stringIntoBigInteger("-569") , new BigInteger("-569"));
        assertEquals(converter.stringIntoBigInteger("0") , new BigInteger("0"));
        try{
            converter.stringIntoBigInteger("0c");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse BigInteger from string");
        }
        try{
            converter.stringIntoBigInteger(" 8");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse BigInteger from string");
        }
        try{
            converter.stringIntoBigInteger("9 c 87");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse BigInteger from string");
        }try{
            converter.stringIntoBigInteger("888 888");
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse BigInteger from string");
        }
    }
}