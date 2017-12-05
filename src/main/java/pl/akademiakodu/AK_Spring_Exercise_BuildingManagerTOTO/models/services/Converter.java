package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * This service is used to transform user input as string into requested variables
 */
@Service
public class Converter {

    /**
     * Methods parse string into integer if possible
     * @param str takes any strings value
     @throws IllegalArgumentException in case of user input error
      * @return result as required int if possible
     */
    public int stringIntoInteger(String str){
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Cannot parse int from string");
        }
        return result;
    }

    /**
     * Methods parse string into BigInteger if possible
     * @param str takes any strings value
     * @throws IllegalArgumentException in case of user input error
     * @return result as required BigInteger if possible
     */
    public BigInteger stringIntoBigInteger(String str){
        BigInteger result;
        try {
            result = BigInteger.valueOf(stringIntoInteger(str));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Cannot parse BigInteger from string");
        }
        return result;
    }

}
