package sample.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CustomHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String handleStatus = null;

        if("GET".equals(httpExchange.getRequestMethod()) && httpExchange.getRequestURI().toString().equals("get-first")) {
            System.out.println(handleStatus = handleGetRequest(httpExchange));
        }

        System.out.println("The message to the client sent successfully");
    }

    private String handleGetRequest(HttpExchange httpExchange) throws IOException {
        String s = "Hello world";
        httpExchange.sendResponseHeaders(200, s.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(s.getBytes());
        os.close();
        return "Ok";
    }
}
