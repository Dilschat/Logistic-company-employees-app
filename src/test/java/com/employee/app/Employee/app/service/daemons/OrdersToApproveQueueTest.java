package com.employee.app.Employee.app.service.daemons;

import com.employee.app.Employee.app.model.Order;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class OrdersToApproveQueueTest {

//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().bindAddress("127.0.0.1").port(5000));
//    @Before
//    public void setWireMockServer(){
//        stubFor(get(urlEqualTo("/orders_to_approve")).willReturn(aResponse()
//                .withStatus(200)
//                .withHeader("Content-Type", "application/json")
//                .withBody(
//                        "                        \"id\":" +
//                        "                            \"1\"," +
//                        "                        \"timestamp\":" +
//                        "                           \"20181122'T'121212\"," +
//                        "                        \"delivery_type\":" +
//                        "                           \"usual\"," +
//                        "" +
//                        "" +
//                        "                        \"sender_firstname\":" +
//                        "                           \"sender name\"," +
//                        "                        \"sender_lastname\":" +
//                        "                           \"sender lastname\"," +
//                        "                        \"sender_country\":" +
//                        "                           \"England\"," +
//                        "                        \"sender_region\":" +
//                        "                           \"Yorkshir\"," +
//                        "                        \"sender_city\":" +
//                        "                           \"London\"," +
//                        "                         \"sender_street\":" +
//                        "                           \"Baker\"," +
//                        "                        \"sender_building_number\":" +
//                        "                           \"21\"," +
//                        "                         \"sender_additional_info\":" +
//                        "                           \"I love pizza with pineapple\"," +
//                        "                        \"sender_number\":" +
//                        "                           \"8888888888\"," +
//                        "" +
//                        "                        \"receiver_firstname\":" +
//                        "                           \"definitely  not a Dilshat\"," +
//                        "                        \"receiver_lastname\":" +
//                        "                           \"Salikhov\"," +
//                        "                        \"receiver_country\":" +
//                        "                           \"Russia\"," +
//                        "                        \"receiver_region\":" +
//                        "                           \"Tatarstan\"," +
//                        "                        \"receiver_city\":" +
//                        "                           \"Innopolis\"," +
//                        "                        \"receiver_street\":" +
//                        "                           \"Universitetskaya\"," +
//                        "                        \"receiver_building_number\":" +
//                        "                           \"2\"," +
//                        "                        \"receiver_additional_info\":" +
//                        "                           \"I hate pizza with pineapple\"," +
//                        "                        \"receiver_number\":" +
//                        "                           \"11111111111\"," +
//                        "" +
//                        "                        \"package_height\":" +
//                        "                            \"20 cm\"," +
//                        "                        \"package_length\":" +
//                        "                           \"20 cm\"," +
//                        "                        \"package_width\":" +
//                        "                           \"4 cm\"," +
//                        "                        \"package_weight\":" +
//                        "                           \"0.4 kg\"," +
//                        "" +
//                        "                        \"error\": \"none\"")));


 //   }
    /*
    @Test
    public void getOrder() throws InterruptedException, IOException {
        System.out.println(1);
        OrdersToApproveManager.run();
        System.out.println(2);
        OrdersToApproveQueue queue = OrdersToApproveQueue.getInstance();
        System.out.println(3);
        Order order = queue.getOrder();
        Assert.assertTrue(order.getId().equals("1"));
    }*/
    private String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
        InputStream inputStream = httpResponse.getEntity().getContent();
        return convertInputStreamToString(inputStream);
    }
    private String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }

    @Test
    public void putOrder() {

    }
}