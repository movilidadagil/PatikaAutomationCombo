package testscenarios;


import api.FlightTicketRequest;
import com.mashape.unirest.http.exceptions.UnirestException;
import framework.ConfigReader;
import framework.DriverSetup;
import model.Root;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.io.IOException;
import java.util.*;

public class FlightAndBusSearchScenarios {

    static WebDriver driver;
    static Properties properties;
    HomePage homePage;
    FlightTicketRequest flightTicketRequest;
    String keyword = "ada";

    @BeforeClass
    public void setup(){
          properties = ConfigReader.initialize_Properties();
          driver = DriverSetup.initialize_Driver("chrome");
          homePage = new HomePage(driver);
          flightTicketRequest = new FlightTicketRequest();

    }

    @Test(priority = 1, enabled = false)
    public void searchForKeyword() throws InterruptedException {

        homePage.searchForFlightTicket(keyword);

    }
    @Test(priority = 2, enabled = false)
    public void checkListForSearch() throws UnirestException, IOException {
        Map<String, Root> flightMap = new HashMap();
        Map<String, Root> flightMapAPi = new HashMap();

        List< String > flightList = homePage.listForFlightTicketSearchByStream();
        /*flightList.stream().forEach(item->{
            System.out.println(item);
        });*/
        for(int i=2;i<flightList.size();i=i+2){
            Root root = new Root();
            root.setAirport(flightList.get(i-1).split("\n")[1]);
            root.setCity_name(flightList.get(i-2).split(",")[0]);
            root.setCountry_name(flightList.get(i-2).split(",")[1].split("\n")[0]);
            flightMap.put(flightList.get(i).split("\n")[2],
                    root);
        }


        List< String > flightListApi = flightTicketRequest.flightTicketFromList(keyword);
        flightListApi.stream().forEach(item->{
          //  System.out.println(item);
        });

        for(int i=0;i<flightListApi.size();i++){
            Root root = new Root();
            //IZM,Türkiye:Adnan Menderes Havalimanı:İzmir
            root.setAirport(flightListApi.get(i));
            root.setCountry_name(flightListApi.get(i).split(":")[0]);
            root.setAirport(flightListApi.get(i).split(":")[1]);
            root.setCity_name(flightListApi.get(i).split(":")[2]);
            flightMapAPi.put(flightListApi.get(i).split(",")[0],
                    root);
        }
        Assert.assertEquals(flightMap.get("ADT"),flightMapAPi.get("ADT"));

    }

    @Test
    public void verifySoftAssertion(){
        Assertion assertion = new SoftAssert();
        assertion.assertEquals("a","b");
        System.out.println("bu okunur");
        Assert.assertEquals("a","b");
        System.out.println("bu okunmaz");
    }

}
