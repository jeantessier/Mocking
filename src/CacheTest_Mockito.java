import junit.framework.TestCase;
import static org.mockito.AdditionalMatchers.*;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

import java.util.Map;

public class CacheTest_Mockito extends TestCase {
    public void testMethodWithReturnValue() {
        int expectedValue = 42;

        Map mockStorage = mock(Map.class);
        stub(mockStorage.size()).toReturn(expectedValue);

        Cache sut = new Cache(mockStorage);
        int actualValue = sut.size();
        assertSame(expectedValue, actualValue);

        verify(mockStorage).size();
    }

    public void testMethodWithReturnValueThrowsAnException() {
        Exception expectedException = new RuntimeException();

        Map mockStorage = mock(Map.class);
        stub(mockStorage.size()).toThrow(expectedException);

        Cache sut = new Cache(mockStorage);
        try {
            sut.size();
            fail("Should have thrown the exception");
        } catch (RuntimeException actualException) {
            assertSame(expectedException, actualException);
        }

        verify(mockStorage).size();
    }

    public void testVoidMethod() {
        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.clear();

        verify(mockStorage).clear();
    }

    public void testVoidMethodThrowsAnException() {
        Exception expectedException = new RuntimeException();

        Map mockStorage = mock(Map.class);
        stubVoid(mockStorage).toThrow(expectedException).on().clear();

        Cache sut = new Cache(mockStorage);
        try {
            sut.clear();
            fail("Should have thrown the exception");
        } catch (RuntimeException actualException) {
            assertSame(expectedException, actualException);
        }

        verify(mockStorage).clear();
    }

    public void testMethodWithParameter() {
        int key = 42;
        String expectedValue = "forty-two";

        Map mockStorage = mock(Map.class);
        stub(mockStorage.get(key)).toReturn(expectedValue);

        Cache sut = new Cache(mockStorage);
        Object actualValue = sut.get(key);
        assertSame(expectedValue, actualValue);

        verify(mockStorage).get(key);
    }

    public void testExactParams() {
        int expectedKey = 42;
        String expectedValue = "forty-two";

        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);

        verify(mockStorage).put(expectedKey, expectedValue);
    }

    public void testFuzzyParams() {
        int expectedKey = 42;
        String expectedValue = "forty-two";

        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);

        verify(mockStorage).put(geq(40), contains("two"));
    }

    public void testIgnoreReturnValue() {
        int expectedKey = 42;
        String expectedValue = "forty-two";

        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);

        verify(mockStorage).put(expectedKey, expectedValue);
    }

    public void testIgnoreMethodCall() {
        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();

        verify(mockStorage).clear();
    }

    public void testIgnoreObject() {
        Map mockStorage = mock(Map.class);

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();
    }

    public void testMultipleCalls() {
        Map mockStorage = mock(Map.class);
        stub(mockStorage.size()).toReturn(42);

        Cache sut = new Cache(mockStorage);
        sut.conditionalLogAndClear();

        verify(mockStorage, times(2)).size();
        verify(mockStorage).clear();
    }

    public void testSequenceOnOneMock() {
        Map mockStorage = mock(Map.class);
        stub(mockStorage.size()).toReturn(42);
        InOrder inOrder = inOrder(mockStorage);

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();

        inOrder.verify(mockStorage).size();
        inOrder.verify(mockStorage).clear();
    }
}