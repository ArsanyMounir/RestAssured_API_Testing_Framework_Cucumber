package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name , String language , String address){
        AddPlace payload = new AddPlace();
        payload.setAccuracy(50);
        payload.setAddress(address);
        payload.setLanguage(language);
        payload.setName(name);
        payload.setWebsite("http://google.com");
        payload.setPhone_number("(+91) 983 893 3937");


        List<String> typesList = new ArrayList<String>();
        typesList.add("shoe park");
        typesList.add("shop");
        typesList.add("park");
        payload.setTypes(typesList);

        Location loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        payload.setLocation(loc);
        return payload;
    }
    public String deletePlacePayload(String placeID)
    {
        return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
    }
}
