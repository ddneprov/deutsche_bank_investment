package org.test.api;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StockController {

    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public static String getDetail() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/get-detail?symbol=NBEV&region=US")
                .get()
                .addHeader("x-rapidapi-key", "4231fec097msh8127e7bce64d8eap14f621jsn65254bbe7bbf")
                .addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        return response.toString();
    }
}
