package edu.umb.cs680.hw09.PrintingFramework;


public class EncryptedString {
    private static String pwd;
    public EncryptedString(String passwordString){
        EncryptedString.pwd=passwordString;
    }
    public String getPwd(){
        return pwd;
    }
}
