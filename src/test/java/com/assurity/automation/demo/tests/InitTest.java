package com.assurity.automation.demo.tests;

import com.assurity.automation.engine.FrameworkContext;
import com.assurity.automation.utilities.FrameworkBaseTest;
import com.assurity.automation.utilities.rest.GenericRestClient;
import org.testng.annotations.Test;

import java.net.URISyntaxException;


public class InitTest extends FrameworkBaseTest {
    @Test
    public void initTest() throws URISyntaxException {
        FrameworkContext context = new FrameworkContext();
        context.build();
        String endpoint = context.getEndpoint();
         GenericRestClient genericRestClient = new GenericRestClient(endpoint);
      //   Object response  = genericRestClient.doGetRequest();



    }

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {


    }

}
