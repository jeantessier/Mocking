import org.jmock.Expectations;
import org.jmock.integration.junit3.MockObjectTestCase;

public class Innocuous_jMock extends MockObjectTestCase {
    public void testSimple() {
        final int expectedValue = 0;

        final SimpleInterface mockSimple = mock(SimpleInterface.class);

        checking(new Expectations() {{
            one (mockSimple).simpleMethod();
        }});

        Client sut = new Client(mockSimple);
        int actualValue = sut.callSimple();
        assertEquals(expectedValue, actualValue);
    }
}
