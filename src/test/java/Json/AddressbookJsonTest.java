package Json;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    }


