package cucumber;

import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.RDFMapperTests;
import io.cucumber.java8.En;
import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClassWithPrimitivesStepdefs implements En {
    Model aGraph;
    RDFMapperTests.ClassWithPrimitiveLists aResult;
    List<Integer> primitives = new ArrayList<>();
    public ClassWithPrimitivesStepdefs() {
        Given("User created a graph from {string}", (String filePath) -> { // /data/primitive_rdf_lists.nt
            aGraph = ModelIO.read(RDFMapperTests.Files3.classPath(filePath).toPath());
        });
        When("the user loads a {string}", (String tag) -> { // tag:complexible:pinto:9017b0ab9335e4d090290a0dffc81826
            aResult = RDFMapper.create().readValue(aGraph,
                    RDFMapperTests.ClassWithPrimitiveLists.class,
                    SimpleValueFactory.getInstance().createIRI(tag));
        });
        Then("we expect the loaded class to have a {int}", (Integer primitive) -> {
            primitives.add(primitive);
        });
        And("has {int}", (Integer primitive) -> {
            primitives.add(primitive);
        });
        And("they equal", () -> {
            RDFMapperTests.ClassWithPrimitiveLists aExpected = new RDFMapperTests.ClassWithPrimitiveLists();
            aExpected.setInts(primitives);
            assertEquals(aExpected, aResult);
        });
    }
}
