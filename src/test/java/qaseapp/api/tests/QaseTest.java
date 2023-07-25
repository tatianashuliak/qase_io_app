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
    @Test(priority = 2)
    public void checkIsProjectExistsTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "Project doesn't found");
    }

    @Test(priority = 1)
    public void checkCreatingProjectTest() {
        Project project = Project.builder()
                .title("AQA22")
                .code("aqa22")
                .build();
        String codeOfProject = new ProjectAdapter().create(project).body().path("result.code");
        Assert.assertTrue(codeOfProject.equalsIgnoreCase(project.getCode()), "Project isn't created");
    }

    @Test(priority = 2)
    public void checkCreatingSuiteTest() {
        String projectCode = "AQA22";
        Suite suite = Suite.builder()
                .title("Smoke")
                .description("This is the smoke tests")
                .build();
        int resultId = new SuiteAdapter().create(projectCode, suite).body().path("result.id");
        Assert.assertTrue(resultId != 0, "Test suite isn't created");
    }

    @Test(priority = 3)
    public void checkNumberOfAllCasesTest() {
        int statusCode = new CaseAdapter().getAllCases("AQA22").statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "Number of projects isn't correct");
    }

    @Test(priority = 2)
    public void checkCreatingCaseTest() {
        TestCase testCase = TestCase.builder()
                .title("Test case 1")
                .build();
       int resultId = new CaseAdapter().create("AQA22", testCase).body().path("result.id");
       Assert.assertTrue(resultId != 0, "Test case isn't created");
    }

    @Test(priority = 3)
    public void checkIsASpecificCaseExistsTest() {
        int statusCode = new CaseAdapter().getASpecificCase("AQA22", 1).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "Test case wasn't found");
    }

    @Test(priority = 4)
    public void CheckDeletingTestCase() {
        int idOfDeletedCase = new CaseAdapter().delete("AQA22", 1).body().path("result.id");
        Assert.assertTrue(idOfDeletedCase !=0, "Test case isn't deleted");
    }

    @Test(priority = 3)
    public void CheckNumberOfAllTestSuitesTest() {
        int statusCode = new SuiteAdapter().getAllSuites("AQA22").statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "Number of test suites isn't correct");
    }
}
