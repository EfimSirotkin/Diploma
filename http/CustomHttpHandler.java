package sample.http;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import sample.Main;
import sample.json.JsonDeserializerSingleton;
import sample.json.JsonSerializerSingleton;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CustomHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        if ("GET".equals(httpExchange.getRequestMethod())) {

            String handleStatus = null;
            switch (httpExchange.getRequestURI().toString()) {
                case "/get-teachers":
                    handleStatus = GetHandler.handleGetTeachers(httpExchange);
                    break;
                case "/get-pupils":
                    handleStatus = GetHandler.handleGetPupils(httpExchange);
                    break;
                case "/get-schoolclasses":
                    handleStatus = GetHandler.handleGetSchoolClasses(httpExchange);
                    break;
                case "/get-subjects":
                    handleStatus = GetHandler.handleGetSubjects(httpExchange);
                case "/get-grades":
                    handleStatus = GetHandler.handleGetGrades(httpExchange);
                    break;
            }
            System.out.println(handleStatus);
        } else if ("POST".equals(httpExchange.getRequestMethod())) {
            String postStatus = null;
            String serializedObjects = PostHandler.handlePostRequest(httpExchange);
            switch (httpExchange.getRequestURI().toString()) {
                case "/post-teachers":
                    Main.schoolTeachers = JsonDeserializerSingleton.getInstance()
                            .deserializeTeachers(serializedObjects);
                    break;
                case "/post-pupils":
                    Main.pupils = JsonDeserializerSingleton.getInstance()
                            .deserializePupils(serializedObjects);
                    break;
                case "/post-schoolclasses":
                    Main.schoolClasses = JsonDeserializerSingleton.getInstance()
                            .deserializeSchoolClasses(serializedObjects);
                    break;
                case "post-subjects":
                    Main.schoolSubjects = JsonDeserializerSingleton.getInstance()
                            .deserializeSchoolSubjects(serializedObjects);
                    break;
                case "post-grades":
                    Main.grades = JsonDeserializerSingleton.getInstance()
                            .deserializeGrades(serializedObjects);
                    break;

            }
        }

    }


}
