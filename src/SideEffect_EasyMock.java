import junit.framework.TestCase;
import static org.easymock.EasyMock.*;
import org.easymock.IAnswer;

import java.util.List;

public class SideEffect_EasyMock extends TestCase {
    public void testSideEffect() {
        Populator mockPopulator = createMock(Populator.class);
        mockPopulator.populate(isA(List.class));
        expectLastCall().andAnswer(addToListParameter(0, new Object()));
        replay(mockPopulator);

        Client sut = new Client(mockPopulator);
        int actualValue = sut.callPopulateAndReturnSize();
        assertTrue(actualValue > 0);

        verify(mockPopulator);
    }

    private IAnswer addToListParameter(final int i, final Object object) {
        return new IAnswer() {
            public Object answer() throws Throwable {
                ((List) getCurrentArguments()[i]).add(object);
                return null;
            }
        };
    }
}
