
package com.BookingTaxi;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class AESSecurity {
    private final byte[] keyValue;
    public static final String ALGO="AES";
     public static final String ALGO1="AES";
    
    public AESSecurity(){
        keyValue="ravishankarhello".getBytes();
    }
    public  String encrypt(String Data ) throws Exception{
        Key key=generateKey();
        Cipher c= Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal=c.doFinal(Data.getBytes());
        String encryptedValue= new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    
    private  Key generateKey() throws Exception{
        Key key=new SecretKeySpec(keyValue,ALGO);
        return key;
    }
    
    
    
}
