package sample.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.objects.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public final class JsonDeserializerSingleton {

    private static JsonDeserializerSingleton instance;
    private Gson gsonDeserializer;

    private JsonDeserializerSingleton()
    {
        this.gsonDeserializer = new Gson();
    }

    public static JsonDeserializerSingleton getInstance() {
        if(instance == null)
            instance = new JsonDeserializerSingleton();
        return instance;
    }

    public ArrayList<Grade> deserializeGrades(String jsonSerializedGrades) {
        Type type = new TypeToken<ArrayList<Grade>>(){}.getType();
        ArrayList<Grade> dsGrades = gsonDeserializer.fromJson(jsonSerializedGrades, type);
        return dsGrades;
    }

    public ArrayList<Pupil> deserializePupils(String jsonSerializedPupils) {
        Type type = new TypeToken<ArrayList<Pupil>>(){}.getType();
        ArrayList<Pupil> dsPupils = gsonDeserializer.fromJson(jsonSerializedPupils, type);
        return dsPupils;
    }

    public ArrayList<SchoolClass> deserializeSchoolClasses(String jsonSerializedClasses) {
        Type type = new TypeToken<ArrayList<SchoolClass>>(){}.getType();
        ArrayList<SchoolClass> dsSchoolClasses = gsonDeserializer.fromJson(jsonSerializedClasses, type);
        return dsSchoolClasses;
    }

    public ArrayList<Subject> deserializeSchoolSubjects(String jsonSerializedSubjects) {
        Type type = new TypeToken<ArrayList<Subject>>(){}.getType();
        ArrayList<Subject> dsSchoolSubjects = gsonDeserializer.fromJson(jsonSerializedSubjects, type);
        return dsSchoolSubjects;
    }

    public ArrayList<Teacher> deserializeTeachers(String jsonSerializedTeachers) {
        Type type = new TypeToken<ArrayList<Teacher>>(){}.getType();
        ArrayList<Teacher> dsSchoolTeachers = gsonDeserializer.fromJson(jsonSerializedTeachers, type);
        return dsSchoolTeachers;
    }


}
