import junit.framework.TestCase;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

public class ClassExplicit1_jMock extends TestCase {
    private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    public void testSome() {
        SomeClass mockSome = context.mock(SomeClass.class);
        // Program the mocks here

        // Setup SUT with mocks and exercise here
    }
}
