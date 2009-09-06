import org.jmock.integration.junit3.MockObjectTestCase;
import org.jmock.lib.legacy.ClassImposteriser;

public class Class_jMock extends MockObjectTestCase {
    protected void setUp() throws Exception {
        super.setUp();

        setImposteriser(ClassImposteriser.INSTANCE);
    }

    public void testSome() {
        SomeClass mockSome = mock(SomeClass.class);
        // Program the mocks here

        // Setup SUT with mocks and exercise here
    }
}