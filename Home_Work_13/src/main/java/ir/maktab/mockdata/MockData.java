package ir.maktab.mockdata;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.maktab.model.Person;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Person> getPeople() {
        try {
            InputStream inputStream = Resources.getResource("people.json").openStream();
            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            return new Gson().fromJson(json, listType);
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
