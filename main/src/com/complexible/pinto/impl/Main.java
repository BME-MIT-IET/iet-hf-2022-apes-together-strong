package com.complexible.pinto.impl;

import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.manualtesting.Person;
import jdk.vm.ci.amd64.AMD64;
import jdk.vm.ci.sparc.SPARC;
import org.openrdf.model.Graph;
import org.openrdf.model.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        long time = System.currentTimeMillis();
        long creationTimeSum=0;
        for(int i=0; i<20000; i++){
            Thread th=new Thread();
            th.run();
            Model aGraph = RDFMapper.create().writeValue(new Person("Michael Grove"+i));
            creationTimeSum+=System.currentTimeMillis()-time;

            th.stop();
        }
        System.out.println("Time required for creating RDF object from Person:"+creationTimeSum+" millisecs");
        System.out.println("Average creation time:"+creationTimeSum/2000+" millisecs");

        Model aGraph = RDFMapper.create().writeValue(new Person("Michael Grove"));
        long time2 =System.currentTimeMillis();
        long readTimeSum =0;

        for(int j=0; j<20000; j++) {
            Thread th = new Thread();
            th.run();
            final Person aPerson = RDFMapper.create().readValue(aGraph, Person.class);
            readTimeSum += System.currentTimeMillis()-time2;
            th.stop();
        }
        System.out.println("Time required for reading Person from RDF object:"+readTimeSum+" millisecs");
        System.out.println("Average reading time:"+creationTimeSum/2000+" millisecs");

    }
}
