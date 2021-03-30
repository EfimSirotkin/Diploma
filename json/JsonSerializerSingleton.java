package sample.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.objects.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonSerializerSingleton {

    private static JsonSerializerSingleton instance;
    private Gson gsonSerializer;

    private JsonSerializerSingleton()
    {
        this.gsonSerializer = new Gson();
    }

    public static JsonSerializerSingleton getInstance() {
        if(instance == null)
            instance = new JsonSerializerSingleton();
        return instance;
    }


    public String serializeGrades(ArrayList<Grade> grades) {
        String sGrades = gsonSerializer.toJson(grades);
        return sGrades;
    }

    public String serializePupils(ArrayList<Pupil> pupils) {
        String sPupils = gsonSerializer.toJson(pupils);
        return sPupils;
    }

    public String serializeSchoolClasses(ArrayList<SchoolClass> classes) {
        String sSchoolClasses = gsonSerializer.toJson(classes);
        return sSchoolClasses;
    }

    public String serializeSchoolSubjects(ArrayList<Subject> subjects) {
        String sSchoolSubjects = gsonSerializer.toJson(subjects);
        return sSchoolSubjects;
    }

    public String serializeTeachers(ArrayList<Teacher> teachers)
    {
        String sTeachers = gsonSerializer.toJson(teachers);
        return sTeachers;
    }


}
