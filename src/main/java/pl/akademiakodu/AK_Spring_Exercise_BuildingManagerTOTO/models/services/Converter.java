package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Converter {

    public int stringIntoInteger(String str){
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Cannot parse int from string");
        }
        return result;
    }

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
