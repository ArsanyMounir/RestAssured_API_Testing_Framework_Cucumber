package resources;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification requestSpec;
    public RequestSpecification requestSpecification() throws IOException {
        if(requestSpec==null){

            PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
            requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
                    .addQueryParam("key","qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            return requestSpec;
        }
        return requestSpec;
    }
    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fIS = new FileInputStream("D:\\ITI\\Courses\\Udemy Cert\\API Restassured\\API Automation Testing Framework\\APIAutomationFramework\\src\\test\\java\\resources\\global.properties");
        prop.load(fIS);
        return prop.getProperty(key);

    }


}
