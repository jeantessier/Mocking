import junit.framework.TestCase;
import static org.easymock.EasyMock.*;
import org.easymock.IMocksControl;

public class UserCacheTest_EasyMock extends TestCase {
    public void testInnocuousValue() {
        int key = 42;

        Storage mockStorage = createNiceMock(Storage.class);
        Logger mockLogger = createMock(Logger.class);
        mockLogger.log(isA(String.class));
        replay(mockStorage, mockLogger);

        UserCache sut = new UserCache(mockStorage, mockLogger);
        sut.getAndLog(key);

        verify(mockStorage, mockLogger);
    }

    public void testSequenceOnTwoMocks() {
        int expectedKey = 42;

        IMocksControl control = createStrictControl();

        Storage mockStorage = control.createMock(Storage.class);
        Logger mockLogger = control.createMock(Logger.class);
        UserRecord mockUser = control.createMock(UserRecord.class);
        expect(mockStorage.get(expectedKey)).andReturn(mockUser);
        mockLogger.log(isA(String.class));
        control.replay();

        UserCache sut = new UserCache(mockStorage, mockLogger);
        sut.getAndLog(expectedKey);

        control.verify();
    }
}
