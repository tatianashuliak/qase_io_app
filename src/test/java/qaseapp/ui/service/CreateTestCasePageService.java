package qaseapp.ui.service;

import qaseapp.ui.model.Suite;
import qaseapp.ui.model.TestCase;
import qaseapp.ui.page.CreateTestCasePage;
import qaseapp.ui.page.ProjectRepositoryPage;

public class CreateTestCasePageService {

     CreateTestCasePage createTestCasePage = new CreateTestCasePage();

     public ProjectRepositoryPageService createTestCase(TestCase testCase) {
         createTestCasePage.fillInTitleField(testCase.getTitle())
                 .fillInStatusField(testCase.getStatus())
                 .fillInSeverityField(testCase.getSeverity())
                 .fillInPriorityField(testCase.getPriority())
                 .clickSaveCaseButton();
         return new ProjectRepositoryPageService();
     }
}
