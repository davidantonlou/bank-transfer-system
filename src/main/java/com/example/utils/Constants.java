package com.example.utils;

public class Constants {

    public static Double INTER_BANK_MAX_LIMIT = new Double(1000);
    public static Double INTER_BANK_COMMISSION = new Double(5);
    public static Float INTER_BANK_FAILURE_CHANCE = new Float(0.3);

    public static Double INTRA_BANK_MAX_LIMIT = new Double(0);
    public static Double INTRA_BANK_COMMISSION = new Double(0);
    public static Float INTRA_BANK_FAILURE_CHANCE = new Float(0);

    public static String TO_STRING_CONTENT_START = "[";
    public static String TO_STRING_CONTENT_END = "]";
    public static String TO_STRING_SEPARATOR = ", ";

    public static String ERROR_AMOUNT_VALUE = "The amount value %s is greater than the max %s.";

}
