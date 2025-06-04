package stepDefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        StepDef beforeCheck =new StepDef();
        if(StepDef.placeID==null)
        {
            beforeCheck.addPlacePayloadWith("Arsany", "French", "Egypt");
            beforeCheck.user_calls_with_http_request("AddPlaceAPI", "POST");
            beforeCheck.verifyPlace_IdCreatedMapsToUsing("Arsany", "getPlaceAPI");
        }
    }

}
