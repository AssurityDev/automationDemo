package com.assurity.automation.demo.tests;

import com.assurity.automation.engine.FrameworkContext;
import com.assurity.automation.engine.context.TestContext;
import com.assurity.automation.engine.dataprovider.TestNgDataProvider;
import com.assurity.automation.utilities.FrameworkBaseTest;
import com.assurity.automation.utilities.rest.GenericRestClient;
import com.assurity.automation.demo.service.model.Employee;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class EmployeeServiceTest extends FrameworkBaseTest {
    GenericRestClient genericRestClient;
    @BeforeTest
    public void initTest() throws URISyntaxException {
        TestContext context = new TestContext();
        String endpoint = context.getDefaultEndpoint();
        genericRestClient = new GenericRestClient(endpoint);
    }

    @Test
    public void addEmployeeTestcase()
    {
        Employee employee = new Employee();
        employee.setId(1234);
        employee.setEmail("dkasunw@gmail.com");
        employee.setFirstName("user");
        employee.setLastName("demo");
        genericRestClient.doPost("/employees/adduser/",employee);
        Assert.notNull(getResponse(), "List is empty, Employee not added");
    }

    @Test(dataProvider = "assurity.testng.dataprovider", dataProviderClass = TestNgDataProvider.class)
    public void addEmployeeDataProviderTestcase(Object name, Object id)
    {
        System.out.println("++++++++++++++++++++++++++++"+ name);
        System.out.println("++++++++++++++++++++++++++++"+ id);
        Employee employee = new Employee();
        employee.setId(Integer.valueOf(String.valueOf(id)));
        employee.setEmail("dkasunw@gmail.com");
        employee.setFirstName(String.valueOf(name));
        employee.setLastName("demo");
        genericRestClient.doPost("/employees/adduser/",employee);

    }
    @Test
    public void getEmployeeTestcase()
    {
        Object response  = genericRestClient.doGetRequest( "/employees/getuser/");
        response.toString();
        Assert.notNull(response, "List is empty, Employee not added");
    }

    private Object getResponse()
    {
        Object response  = genericRestClient.doGetRequest( "/employees/getuser/");
        return response;
    }
}
