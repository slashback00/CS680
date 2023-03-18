package edu.umb.cs680.hw04;

public class EncryptedString {
    private static String cipherText;
    
    public EncryptedString(String cipherString) {
        cipherText = cipherString;
    }
    
    public static String getCipherText() {
        return cipherText;
    }

    public String getPass() {
        return null;
    }
}

