package qaseapp.api.adapters;

import io.restassured.response.Response;
import qaseapp.api.models.TestCase;

public class CaseAdapter extends BaseAdapter{
    private static final String CASE_API_ENDPOINT = "/case/%s";

    public Response getAllCases(String codeOfProject) {
        return get(String.format(CASE_API_ENDPOINT, codeOfProject));
    }

    public Response create (String codeOfProject, TestCase testCase) {
        return post(String.format(CASE_API_ENDPOINT, codeOfProject), converter.toJson(testCase));
    }

    public Response getASpecificCase (String codeOfProject, int idOfTestcase) {
        return get(String.format(CASE_API_ENDPOINT, codeOfProject + "/" + idOfTestcase));
    }

    public Response delete (String codeOfProject, int idOfTestCase) {
        return delete(String.format(CASE_API_ENDPOINT, codeOfProject + "/" + idOfTestCase));
    }
}
