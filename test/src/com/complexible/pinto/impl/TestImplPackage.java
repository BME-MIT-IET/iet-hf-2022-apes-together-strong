package com.complexible.pinto.impl;

import org.junit.Test;
import org.openrdf.model.Model;

public class TestImplPackage {
    @Test
    public void SourcedObjectImpl_test(){
        SourcedObjectImpl soi = new SourcedObjectImpl();
        Model m = soi.getSourceGraph();
        soi.setSourceGraph(m);
        org.junit.Assert.assertEquals(m, soi.getSourceGraph());
    }
}
