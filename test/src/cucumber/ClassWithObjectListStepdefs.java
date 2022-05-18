package cucumber;

import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.RDFMapperTests;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.cucumber.java8.En;
import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClassWithObjectListStepdefs implements En {
    Model aGraph;
    RDFMapperTests.ClassWithObjectList aExpected;
    List<RDFMapperTests.Person> personCollection = new ArrayList<>();
    List<RDFMapperTests.Person> personSet = new ArrayList<>();
    List<RDFMapperTests.Person> personList = new ArrayList<>();
    List<RDFMapperTests.Person> personSortedSet = new ArrayList<>();
    public ClassWithObjectListStepdefs() {
        Given("a graph in {string}", (String file) -> { // "/data/object_lists.nt"
            aGraph = ModelIO.read(RDFMapperTests.Files3.classPath(file).toPath());
        });
        When("we create a new class with object list", () -> {
            aExpected = new RDFMapperTests.ClassWithObjectList();
        });
        And("we add a person named {string} to the collection", (String name) -> {
            personCollection.add(new RDFMapperTests.Person(name));
        });
        And("we add a person named {string} to the set", (String name) -> {
            personSet.add(new RDFMapperTests.Person(name));
        });
        And("we add a person named {string} to the list", (String name) -> {
            personList.add(new RDFMapperTests.Person(name));
        });
        And("we add a person named {string} to the sorted set", (String name) -> {
            personSortedSet.add(new RDFMapperTests.Person(name));
        });
        Then("the created class equals the class on the graph with the tag: {string}", (String tag) -> { // "tag:complexible:pinto:881b2f11232944aeda9ba543e030dcfc"
            aExpected.setCollection(Sets.newLinkedHashSet(personCollection));
            aExpected.setSet(Sets.newLinkedHashSet(personSet));
            aExpected.setList(Lists.newArrayList(personList));
            aExpected.setSortedSet(Sets.newTreeSet(personSortedSet));


            final RDFMapperTests.ClassWithObjectList aResult = RDFMapper.create().readValue(aGraph,
                    RDFMapperTests.ClassWithObjectList.class,
                    SimpleValueFactory.getInstance().createIRI(tag));

            assertEquals(aExpected, aResult);
        });
    }
}
