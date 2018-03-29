package com.example.utils;


import com.example.model.Account;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

public class SystemUtils {

    public static boolean areAcountsFromSameBank(Account sender, Account receiver){
        return sender.getBank().getName().equals(receiver.getBank().getName());
    }

    public String toString(Object object){
        StandardToStringStyle toStringStyle = new StandardToStringStyle();
        toStringStyle.setContentStart(Constants.TO_STRING_CONTENT_START);
        toStringStyle.setFieldSeparator(Constants.TO_STRING_SEPARATOR);
        toStringStyle.setFieldSeparatorAtStart(false);
        toStringStyle.setContentEnd(Constants.TO_STRING_CONTENT_END);
        toStringStyle.setUseShortClassName(true);
        toStringStyle.setUseIdentityHashCode(false);

        return new ReflectionToStringBuilder(object, toStringStyle).toString();
    }
}
