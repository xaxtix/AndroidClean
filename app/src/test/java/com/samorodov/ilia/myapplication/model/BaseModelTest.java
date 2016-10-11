package com.samorodov.ilia.myapplication.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samorodov.ilia.myapplication.BaseTest;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.junit.Assert.*;

public abstract class BaseModelTest<Model> extends BaseTest {

    Model model;

    public Model getModel() {
        return model;
    }

    protected abstract String getFileName();

    @Before
    public void setUp() throws Exception {
        super.setUp();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        model = (Model) gson.fromJson(readString(getFileName()),getGenericType());

    }

    @Test
    public void modelParseTest(){
        assertNotNull(model);
    }

    private Type getGenericType() {
        return (Type) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public String readString(String fileName) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
