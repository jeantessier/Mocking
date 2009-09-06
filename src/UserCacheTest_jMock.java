import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit3.MockObjectTestCase;

public class UserCacheTest_jMock extends MockObjectTestCase {
    public void testInnocuousValue() {
        final int key = 42;

        final Storage mockStorage = mock(Storage.class);
        final Logger mockLogger = mock(Logger.class);

        checking(new Expectations() {{
            one (mockStorage).get(key);
            one (mockLogger).log(with(any(String.class)));
        }});

        UserCache sut = new UserCache(mockStorage, mockLogger);
        sut.getAndLog(key);
    }

    public void testSequenceOnTwoMocks() {
        final int key = 42;

        final Storage mockStorage = mock(Storage.class);
        final Logger mockLogger = mock(Logger.class);
        final Sequence getSequence = sequence("get");

        checking(new Expectations() {{
            one (mockStorage).get(key);
            inSequence(getSequence);
            one (mockLogger).log(with(any(String.class)));
            inSequence(getSequence);
        }});

        UserCache sut = new UserCache(mockStorage, mockLogger);
        sut.getAndLog(key);
    }
}
