package sample.http;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import sample.objects.Grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class PostHandler {

    public static String handlePostRequest(HttpExchange httpExchange) throws IOException {
        String message = "OK";
        Headers headers = httpExchange.getResponseHeaders();

        InputStreamReader isr =  new InputStreamReader(httpExchange.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);

        int b;
        StringBuilder buf = new StringBuilder(512);
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        OutputStream os = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200,message.getBytes().length);
        os.write(message.getBytes());

        os.close();
        br.close();
        isr.close();
        return buf.toString();
    }
}
