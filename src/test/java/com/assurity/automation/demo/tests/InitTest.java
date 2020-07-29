package com.assurity.automation.demo.tests;

import com.assurity.automation.engine.FrameworkContext;
import com.assurity.automation.engine.context.TestContext;
import com.assurity.automation.engine.dataprovider.TestNgDataProvider;
import com.assurity.automation.utilities.FrameworkBaseTest;
import com.assurity.automation.utilities.rest.GenericRestClient;
import org.testng.annotations.Test;

import java.net.URISyntaxException;


public class InitTest extends FrameworkBaseTest {
    GenericRestClient genericRestClient;
    @Test
    public void initTest() throws URISyntaxException {
        TestContext context = new TestContext();
        String endpoint = context.getDefaultEndpoint();
        genericRestClient = new GenericRestClient(endpoint);
    }

    @Test
    public void sampleTestCase() throws Exception {
        //TODO: Add your test method here
    }

    @Test(dataProvider = "assurity.testng.dataprovider", dataProviderClass = TestNgDataProvider.class)
    public void firstDataDrivenTestMethod(Object name, Object id) throws Exception {
        //TODO: Your data driven test method comes here
    }

}
