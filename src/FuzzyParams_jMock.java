import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.integration.junit3.MockObjectTestCase;

public class FuzzyParams_jMock extends MockObjectTestCase {
    public void testTwoParams() {
        final int intValue = 42;
        final String textValue = "forty-two";

        final SimpleInterface mockSimple = mock(SimpleInterface.class);

        checking(new Expectations() {{
            one (mockSimple).twoParamMethod(with(greaterThan(40)), with(containsString("two")));
        }});

        Client sut = new Client(mockSimple);
        sut.callTwoParams(intValue, textValue);
    }
}
