package com.complexible.pinto;

import org.junit.Test;

public class TestPintoPackage {
    @Test(expected = RuntimeException.class)
    public void test_exceptionWithCause(){
        Throwable t = new Throwable("Throwable test_object");
        RDFMappingException r = new  RDFMappingException(t);
        throw r;
    }
    @Test(expected = RuntimeException.class)
    public void test_exceptionWithMessageAndCause(){
        Throwable t = new Throwable("Error : ");
        String msg = new String("Msg");
        RDFMappingException r = new RDFMappingException(msg, t);
        throw r;
    }
}
