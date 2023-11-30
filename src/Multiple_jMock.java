import junit.framework.TestCase;
import org.jmock.Mockery;

public class Multiple_jMock extends TestCase {
    private Mockery context;

    protected void setUp() throws Exception {
        super.setUp();

        context = new Mockery();
    }

    protected void runTest() throws Throwable {
        super.runTest();
        context.assertIsSatisfied();
    }
    
    public void testSome() {
        SomeInterface mockSome = context.mock(SomeInterface.class);
        SomeOtherInterface mockSomeOther = context.mock(SomeOtherInterface.class);
        // Program the mocks here

        // Setup SUT with mocks and exercise here
    }
}
