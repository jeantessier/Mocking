import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit3.MockObjectTestCase;

public class SequenceTwoMocks_jMock extends MockObjectTestCase {
    public void testSequence() {
        final SimpleInterface mockSimple = mock(SimpleInterface.class);
        final SomeOtherInterface mockSomeOther = mock(SomeOtherInterface.class);
        final Sequence crossSequence = sequence("cross");

        checking(new Expectations() {{
            one (mockSomeOther).someOtherMethod();
            inSequence(crossSequence);
            one (mockSimple).simpleMethod();
            inSequence(crossSequence);
        }});

        Client sut = new Client(mockSimple, mockSomeOther);
        sut.callSimpleAndSomeOther();
    }
}
