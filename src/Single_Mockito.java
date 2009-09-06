import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class Single_Mockito extends TestCase {
    public void testSome() {
        SomeInterface mockSome = mock(SomeInterface.class);
        // Provide stub behavior for the mock here

        // Setup SUT with mock and exercise here

        verify(mockSome);
    }
}
