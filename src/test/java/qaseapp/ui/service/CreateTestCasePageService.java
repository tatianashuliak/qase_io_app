package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.model.Suite;
import qaseapp.ui.model.TestCase;
import qaseapp.ui.page.CreateTestCasePage;
import qaseapp.ui.page.ProjectRepositoryPage;

public class CreateTestCasePageService {
     @Step("User create new test case")
     public ProjectRepositoryPageService createTestCase(TestCase testCase) {
         CreateTestCasePage createTestCasePage = new CreateTestCasePage();
         createTestCasePage.fillInTitleField(testCase.getTitle())
                 .fillInStatusField(testCase.getStatus())
                 .fillInSeverityField(testCase.getSeverity())
                 .fillInPriorityField(testCase.getPriority())
                 .clickSaveCaseButton();
         return new ProjectRepositoryPageService();
     }
}
