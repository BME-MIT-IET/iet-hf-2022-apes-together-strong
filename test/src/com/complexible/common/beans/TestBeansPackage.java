package com.complexible.common.beans;

import com.complexible.common.reflect.Fields;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

public class TestBeansPackage {
    @Test
    public void test_isPrimitive(){
        boolean result = Beans.isPrimitive(Integer.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Long.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Short.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Double.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Float.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Date.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(String.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Character.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(java.net.URI.class);
        org.junit.Assert.assertEquals(true, result);

        result = Beans.isPrimitive(Boolean.class);
        org.junit.Assert.assertEquals(true, result);
    }

    //getDeclaredFields()
}
