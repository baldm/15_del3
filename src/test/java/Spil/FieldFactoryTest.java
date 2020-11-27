package Spil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldFactoryTest {
    Language lang = new Language("English.properties");
    String expectedFields;
    Field[] FactoryFields;
    @Test
    void FieldFactory() {
        FieldFactory fieldFactory = new FieldFactory(lang);
        expectedFields = "START";
        FactoryFields = fieldFactory.getAllFields();
        assertEquals(expectedFields,FactoryFields[0].getFieldName());


    }
}