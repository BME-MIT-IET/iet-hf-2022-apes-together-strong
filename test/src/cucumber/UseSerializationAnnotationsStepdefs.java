package cucumber;

import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.RDFMapperTests;
import io.cucumber.java8.En;
import org.openrdf.model.Model;
import org.openrdf.model.util.Models;

import static org.junit.Assert.assertTrue;

public class UseSerializationAnnotationsStepdefs implements En {
    RDFMapperTests.Company aCompany;
    Model aGraph;
    public UseSerializationAnnotationsStepdefs() {
        Given("a company named {string}", (String companyName) -> { // "Clark & Parsia"
            aCompany = new RDFMapperTests.Company();
            aCompany.setName(companyName);
        });
        And("has a {string}", (String URL) -> { // "http://clarkparsia.com"
            aCompany.setWebsite(URL);
        });
        When("the user creates a graph with the company", () -> {
            aGraph = RDFMapper.create().writeValue(aCompany);
        });
        Then("the content of the graph equals the content of {string}", (String file) -> { // "/data/company.nt"
            assertTrue(Models.isomorphic(ModelIO.read(RDFMapperTests.Files3.classPath(file).toPath()),
                    aGraph));
        });
    }
}
