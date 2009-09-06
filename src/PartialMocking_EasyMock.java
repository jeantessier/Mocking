import junit.framework.TestCase;
import static org.easymock.classextension.EasyMock.*;

import java.lang.reflect.Method;
import java.util.Map;

public class PartialMocking_EasyMock extends TestCase {
    public void testPartialMocking() throws Exception {
        Map mockStorage = createMock(Map.class);
        mockStorage.clear();
        expect(mockStorage.size()).andStubReturn(42);

        Cache sut = createMock(Cache.class, new Method[] {Cache.class.getMethod("log", String.class)});
        sut.log(isA(String.class));

        replay(mockStorage, sut);

        sut.setUnderlyingStorage(mockStorage);
        sut.logAndClear();

        verify(mockStorage);
    }
}
