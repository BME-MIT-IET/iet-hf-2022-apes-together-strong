package com.complexible.common.reflect;

import org.junit.Test;

public class TestReflectPackage {

    public class withoutDefaultCtor {

    }

    @Test
    public void test_withoutDefaultCtor(){
        boolean result = Classes.hasDefaultConstructor(withoutDefaultCtor.class);
        org.junit.Assert.assertEquals(false, result);
    }

    public interface testInterface {

    }

    public class testClass implements testInterface{

    }

    @Test
    public void test_implements_Interface(){
        boolean result = Classes._implements(testClass.class, testInterface.class);
        org.junit.Assert.assertEquals(true, result);
    }

    public abstract class abstract_testclass{

    }
    @Test
    public void test_notAnAbstractClass(){
        boolean result = Classes.isInstantiable(abstract_testclass.class);
        org.junit.Assert.assertEquals(false, result);

        boolean result2 = Classes.isInstantiable(testClass.class);
        org.junit.Assert.assertEquals(true, result2);

        boolean result3 = Classes.isInstantiable(testInterface.class);
        org.junit.Assert.assertEquals(false, result3);
    }
}
