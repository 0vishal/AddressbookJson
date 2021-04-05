package Json;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class AddressbookJsonTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4000;
    }

    public AddressbookJson[] getContactList() {
        Response response = RestAssured.get("/AddressBook");
        System.out.println("Contact entries in Json Server: \n" + response.asString());
        AddressbookJson[] jsonServerAddressBookData = new Gson().fromJson(response.asString(), AddressbookJson[].class);
        return jsonServerAddressBookData;

    }

    public Response addContactInJsonServer(AddressbookJson restAssuredContactData) {
        String Contact = new Gson().toJson(restAssuredContactData);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(Contact);
        return requestSpecification.post("/AddressBook");

    }


    @Test
    public void RetrieveServerData() {
        AddressbookJson[] restAssureContactData = getContactList();
        System.out.println(restAssureContactData);
        Assertions.assertEquals(1, restAssureContactData.length);
    }

    @Test
    public void addMultipleContact() {
        AddressbookJson[] restAssureContactData = getContactList();
        AddressbookJson jsonServerAddressBookData1 = new AddressbookJson(2, "Sarvesh", "shetye", "Rambag", "Pune", "Maharashtra", "sarvesh@gmai.com", 83345367, "Addressbook2", "Family");
        Response response = addContactInJsonServer(jsonServerAddressBookData1);
        int statusCode = response.statusCode();
        Assertions.assertEquals(201, statusCode);
        Assertions.assertEquals(2, restAssureContactData.length);
    }

    @Test
    public void updateContact() throws SQLException {
        AddressbookJson[] restAssureContactData = getContactList();
        String ContactJson = new Gson().toJson(restAssureContactData);
        Assertions.assertEquals(4, restAssureContactData.length);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body("{\"FirstName\":\"Vishal\",\"Address\":\"Kamrajnagar\"}");
        Response response = requestSpecification.put("/AddressBook/update/1");

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
    }


}


