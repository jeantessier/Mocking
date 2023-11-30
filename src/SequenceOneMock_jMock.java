import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit3.MockObjectTestCase;

public class SequenceOneMock_jMock extends MockObjectTestCase {
    public void testSequence() {
        final SimpleInterface mockSimple = mock(SimpleInterface.class);
        final Sequence simpleSequence = sequence("simple");

        checking(new Expectations() {{
            one (mockSimple).irrelevantMethod();
            inSequence(simpleSequence);
            one (mockSimple).simpleMethod();
            inSequence(simpleSequence);
        }});

        Client sut = new Client(mockSimple);
        sut.callSimpleAndIrrelevant();
    }
}