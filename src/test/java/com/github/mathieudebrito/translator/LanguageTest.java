package com.github.mathieudebrito.translator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LanguageTest {

    @Test
    public void testAll() throws Exception {

        List<Language> allLanguages = Language.all();

        for (Language language : allLanguages) {
            Assert.assertNotEquals(null, Language.fromString(language.toString()));
        }
    }

    @Test
    public void testToList() throws Exception {

    }
}