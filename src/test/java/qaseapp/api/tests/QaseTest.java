package qaseapp.api.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import qaseapp.api.adapters.CaseAdapter;
import qaseapp.api.adapters.ProjectAdapter;
import qaseapp.api.adapters.SuiteAdapter;
import qaseapp.api.models.Project;
import qaseapp.api.models.Suite;
import qaseapp.api.models.TestCase;

import static java.net.HttpURLConnection.HTTP_OK;

public class QaseTest {
    @Test
    public void getProjectTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .title("AQA22")
                .code("aqa22")
                .build();
        String codeOfProject = new ProjectAdapter().create(project).body().path("result.code");
        Assert.assertTrue(codeOfProject.equalsIgnoreCase(project.getCode()));
    }

    @Test
    public void createSuiteTest() {
        String projectCode = "AQA22";
        Suite suite = Suite.builder()
                .title("Smoke")
                .description("This is the smoke tests")
                .build();
        int resultId = new SuiteAdapter().create(projectCode, suite).body().path("result.id");
        Assert.assertTrue(resultId != 0);
    }

    @Test
    public void getAllCasesTest() {
        int statusCode = new CaseAdapter().getAllCases("AQA22").statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createCaseTest() {
        TestCase testCase = TestCase.builder()
                .title("Test case 1")
                .build();
       int resultId = new CaseAdapter().create("AQA22", testCase).body().path("result.id");
       Assert.assertTrue(resultId != 0);
    }

    @Test
    public void getASpecificCaseTest() {
        int statusCode = new CaseAdapter().getASpecificCase("AQA22", 1).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void deleteTestCase() {
        int idOfDeletedCase = new CaseAdapter().delete("AQA22", 4).body().path("result.id");
        Assert.assertTrue(idOfDeletedCase !=0);
    }

    @Test
    public void getAllTestSuitesTest() {
        int statusCode = new SuiteAdapter().getAllSuites("AQA22").statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

}
