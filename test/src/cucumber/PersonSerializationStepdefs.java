package cucumber;

import com.complexible.pinto.Identifiable;
import com.complexible.pinto.RDFMapper;
import com.complexible.pinto.impl.IdentifiableImpl;
import io.cucumber.java8.En;
import org.openrdf.model.Model;
import org.openrdf.model.Resource;

import java.util.Objects;

import static org.junit.Assert.*;

public class PersonSerializationStepdefs implements En {
    Person aPerson;
    Person aCopy;
    Model aGraph;
    public PersonSerializationStepdefs() {
        Given("User created a person named {string}", (String name) -> {
            aPerson = new Person(name);
        });
        And("User adds the person to a graph", () -> {
            aGraph = RDFMapper.create().writeValue(aPerson);
        });
        When("The person exist", () -> {
            assertNotNull(aPerson.id());
        });
        And("The graph has {int} element", (Integer int1) -> {
            assertEquals(int1.intValue(), aGraph.size());
        });


        And("Added it to a graph", () -> {
            aGraph = RDFMapper.create().writeValue(aPerson);
        });
        When("User copies the person from graph", () -> {
            aCopy = RDFMapper.create().readValue(aGraph, Person.class);
        });
        Then("The original and the copy equals", () -> {
            assertEquals(aPerson.id(), aCopy.id());
        });
    }

    public static final class Person implements Comparable<Person>, Identifiable {
        private String mName;

        private Identifiable mIdentifiable = new IdentifiableImpl();

        public Person() {
        }

        public Person(final String theName) {
            mName = theName;
        }

        @Override
        public String toString() {
            return mName;
        }

        @Override
        public Resource id() {
            return mIdentifiable.id();
        }

        @Override
        public void id(final Resource theResource) {
            mIdentifiable.id(theResource);
        }

        public String getName() {
            return mName;
        }

        public void setName(final String theName) {
            mName = theName;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(mName);
        }

        @Override
        public boolean equals(final Object theObj) {
            if (theObj == this) {
                return true;
            }
            else if (theObj instanceof Person) {
                return Objects.equals(mName, ((Person) theObj).mName);
            }
            else {
                return false;
            }
        }

        @Override
        public int compareTo(final Person thePerson) {
            return mName.compareTo(thePerson.getName());
        }
    }
}