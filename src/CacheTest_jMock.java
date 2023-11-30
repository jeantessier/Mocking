import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit3.MockObjectTestCase;

import java.util.Map;

public class CacheTest_jMock extends MockObjectTestCase {
    public void testMethodWithReturnValue() {
        final int expectedValue = 42;

        final Map mockStorage = mock(Map.class);
        
        checking(new Expectations() {{
            one (mockStorage).size();
            will(returnValue(expectedValue));
        }});

        Cache sut = new Cache(mockStorage);
        int actualValue = sut.size();
        assertSame(expectedValue, actualValue);
    }

    public void testMethodWithReturnValueThrowsAnException() {
        final Exception expectedException = new RuntimeException();

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).size();
            will(throwException(expectedException));
        }});

        Cache sut = new Cache(mockStorage);
        try {
            sut.size();
            fail("Should have thrown the exception");
        } catch (RuntimeException actualException) {
            assertSame(expectedException, actualException);
        }
    }

    public void testVoidMethod() {
        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).clear();
        }});

        Cache sut = new Cache(mockStorage);
        sut.clear();
    }

    public void testVoidMethodThrowsAnException() {
        final Exception expectedException = new RuntimeException();

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).clear();
            will(throwException(expectedException));
        }});

        Cache sut = new Cache(mockStorage);
        try {
            sut.clear();
            fail("Should have thrown the exception");
        } catch (RuntimeException actualException) {
            assertSame(expectedException, actualException);
        }
    }

    public void testMethodWithParameter() {
        final int key = 42;
        final String expectedValue = "forty-two";

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).get(key);
            will(returnValue(expectedValue));
        }});

        Cache sut = new Cache(mockStorage);
        Object actualValue = sut.get(key);
        assertSame(expectedValue, actualValue);
    }

    public void testExactParams() {
        final int expectedKey = 42;
        final String expectedValue = "forty-two";

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).put(expectedKey, expectedValue);
            will(returnValue(true));
        }});

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);
    }

    public void testFuzzyParams() {
        final int expectedKey = 42;
        final String expectedValue = "forty-two";

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).put(with(greaterThan(40)), with(containsString("two")));
            will(returnValue(true));
        }});

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);
    }

    public void testIgnoreReturnValue() {
        final int expectedKey = 42;
        final String expectedValue = "forty-two";

        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).put(expectedKey, expectedValue);
        }});

        Cache sut = new Cache(mockStorage);
        sut.add(expectedKey, expectedValue);
    }

    public void testIgnoreMethodCall() {
        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            one (mockStorage).clear();
            ignoring (mockStorage).size();
            will(returnValue(42));
        }});

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();
    }

    public void testIgnoreObject() {
        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            ignoring (mockStorage);
        }});

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();
    }

    public void testMultipleCalls() {
        final Map mockStorage = mock(Map.class);

        checking(new Expectations() {{
            exactly(2).of (mockStorage).size();
            will(returnValue(42));
            one (mockStorage).clear();
        }});

        Cache sut = new Cache(mockStorage);
        sut.conditionalLogAndClear();
    }

    public void testSequenceOnOneMock() {
        final Map mockStorage = mock(Map.class);
        final Sequence clearSequence = sequence("clear");

        checking(new Expectations() {{
            one (mockStorage).size();
            will(returnValue(42));
            inSequence(clearSequence);
            one (mockStorage).clear();
            inSequence(clearSequence);
        }});

        Cache sut = new Cache(mockStorage);
        sut.logAndClear();
    }
}
