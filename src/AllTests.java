import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        TestSuite result = new TestSuite();

        result.addTestSuite(Single_EasyMock.class);
        result.addTestSuite(Single_Mockito.class);
        result.addTestSuite(Multiple_jMock.class);
        result.addTestSuite(Multiple_EasyMock.class);
        result.addTestSuite(Inherited_jMock.class);
        result.addTestSuite(Inherited_EasyMock.class);
        result.addTestSuite(Class_jMock.class);
        result.addTestSuite(ClassExplicit1_jMock.class);
        result.addTestSuite(ClassExplicit2_jMock.class);
        result.addTestSuite(Class_EasyMock.class);
        result.addTestSuite(CacheTest_jMock.class);
        result.addTestSuite(CacheTest_EasyMock.class);
        result.addTestSuite(CacheTest_Mockito.class);
        result.addTestSuite(UserCacheTest_jMock.class);
        result.addTestSuite(UserCacheTest_EasyMock.class);
        result.addTestSuite(UserCacheTest_Mockito.class);
        result.addTestSuite(Simple_jMock.class);
        result.addTestSuite(Simple_EasyMock.class);
        result.addTestSuite(MultipleCalls_jMock.class);
        result.addTestSuite(MultipleCalls_EasyMock.class);
        result.addTestSuite(IgnoringMethod_jMock.class);
        result.addTestSuite(IgnoringMethod_EasyMock.class);
        result.addTestSuite(Innocuous_jMock.class);
        result.addTestSuite(Innocuous_EasyMock.class);
        result.addTestSuite(IgnoringObject_jMock.class);
        result.addTestSuite(IgnoringObject_EasyMock.class);
        result.addTestSuite(ExactParams_jMock.class);
        result.addTestSuite(ExactParams_EasyMock.class);
        result.addTestSuite(FuzzyParams_jMock.class);
        result.addTestSuite(FuzzyParams_EasyMock.class);
        result.addTestSuite(SequenceOneMock_jMock.class);
        result.addTestSuite(SequenceOneMock_EasyMock.class);
        result.addTestSuite(SequenceTwoMocks_jMock.class);
        result.addTestSuite(SequenceTwoMocks_EasyMock.class);
        result.addTestSuite(SideEffect_jMock.class);
        result.addTestSuite(SideEffect_EasyMock.class);
        result.addTestSuite(VoidAndReturnType_jMock.class);
        result.addTestSuite(VoidAndReturnType_EasyMock.class);

        return result;
    }
}
