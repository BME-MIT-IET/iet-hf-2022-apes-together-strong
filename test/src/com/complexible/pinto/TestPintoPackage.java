package com.complexible.pinto;

import com.complexible.common.openrdf.model.ModelIO;
import org.junit.Test;
import org.openrdf.model.Model;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    @Test
    public void testReadPrimitives() throws Exception {
        Model aGraph = ModelIO.read(new File(getClass().getResource("/data/primitives.nt").toURI()).toPath());

        RDFMapper aMapper = RDFMapper.create();

        final RDFMapperTests.ClassWithPrimitives aResult = aMapper.readValue(aGraph, null);

        RDFMapperTests.ClassWithPrimitives aExpected = new RDFMapperTests.ClassWithPrimitives();
        aExpected.setString("str value");
        aExpected.setInt(8);
        aExpected.setURI(java.net.URI.create("urn:any"));
        aExpected.setFloat(4.5f);
        aExpected.setDouble(20.22);
        aExpected.setChar('o');

        assertNotEquals(aExpected, aResult);
    }
}
