import org.jmock.integration.junit3.MockObjectTestCase;
import org.jmock.Expectations;

public class Simple_jMock extends MockObjectTestCase {
    public void testSimple() {
        final int expectedValue = 42;

        final SimpleInterface mockSimple = mock(SimpleInterface.class);

        checking(new Expectations() {{
            one (mockSimple).simpleMethod();
            will(returnValue(expectedValue));
        }});

        Client sut = new Client(mockSimple);
        int actualValue = sut.callSimple();
        assertEquals(expectedValue, actualValue);
    }
}
