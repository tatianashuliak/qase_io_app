package qaseapp.api.adapters;

import io.restassured.response.Response;
import qaseapp.api.models.Suite;

public class SuiteAdapter extends BaseAdapter {
    private static final String SUITE_API_ENDPOINT = "/suite/%s";

    public Response create (String projectCode, Suite suite) {
     return post(String.format(SUITE_API_ENDPOINT, projectCode), converter.toJson(suite));
    }

    public Response getAllSuites (String projectCode) {
        return get(String.format(SUITE_API_ENDPOINT, projectCode));
    }
}
