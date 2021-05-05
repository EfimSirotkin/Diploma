package sample.http;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import sample.Main;
import sample.json.JsonSerializerSingleton;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetHandler {

    public static String handleGetTeachers(HttpExchange httpExchange) throws IOException {
        JsonSerializerSingleton jsonSerializerSingleton = JsonSerializerSingleton.getInstance();
        String serializedTeachers = jsonSerializerSingleton.serializeTeachers(Main.schoolTeachers);
        System.out.println(serializedTeachers);
        byte bytes[] = serializedTeachers.getBytes(StandardCharsets.UTF_8);
        String newSerialized = new String(bytes, StandardCharsets.UTF_8);

        return handleGetRequest(httpExchange, newSerialized);
    }

    public static String handleGetPupils(HttpExchange httpExchange) throws IOException {
        JsonSerializerSingleton jsonSerializerSingleton = JsonSerializerSingleton.getInstance();
        String serializePupils = jsonSerializerSingleton.serializePupils(Main.pupils);

        return handleGetRequest(httpExchange, serializePupils);
    }

    public static String handleGetGrades(HttpExchange httpExchange) throws IOException {
        JsonSerializerSingleton jsonSerializerSingleton = JsonSerializerSingleton.getInstance();
        String serializedGrades = jsonSerializerSingleton.serializeGrades(Main.grades);
        System.out.println(serializedGrades);

        return handleGetRequest(httpExchange, serializedGrades);
    }

    public static String handleGetSchoolClasses(HttpExchange httpExchange) throws IOException {
        JsonSerializerSingleton jsonSerializerSingleton = JsonSerializerSingleton.getInstance();
        String serializedSchoolClasses = jsonSerializerSingleton.serializeSchoolClasses(Main.schoolClasses);
        System.out.println(serializedSchoolClasses);

        return handleGetRequest(httpExchange, serializedSchoolClasses);
    }

    public static String handleGetSubjects(HttpExchange httpExchange) throws IOException {
        JsonSerializerSingleton jsonSerializerSingleton = JsonSerializerSingleton.getInstance();
        String serializedSchoolSubjects = jsonSerializerSingleton.serializeSchoolSubjects(Main.schoolSubjects);
        System.out.println(serializedSchoolSubjects);

        return handleGetRequest(httpExchange, serializedSchoolSubjects);
    }

    private static String handleGetRequest(HttpExchange httpExchange, String serializedObjects) throws IOException {
        int length = serializedObjects.length();
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Content-Type", "application/json; charset = utf-8");
        httpExchange.sendResponseHeaders(200, serializedObjects.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(serializedObjects.getBytes());
        os.close();
        return "Ok";
    }

}
