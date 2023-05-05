package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("ex1.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
            assert stream != null;
            NameLastname nameLastname = gson.fromJson(new String(stream.readAllBytes()), NameLastname.class);
            System.out.println(nameLastname);
            System.out.println(("==============================="));
            String toJson = gson.toJson(nameLastname);
            System.out.println(toJson);

        }
    }
}