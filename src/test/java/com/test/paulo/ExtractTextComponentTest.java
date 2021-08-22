package com.test.paulo;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.Charset;

public class ExtractTextComponentTest {

    @Test
    public void testGo() throws IOException {
        ExtractTextComponent component = new ExtractTextComponent();
        Assert.assertEquals(FileUtils.readFileToString(new ClassPathResource("25003_884730.txt").getFile(), Charset.defaultCharset()), component.extractText("25003_884730.pdf"));
    }

}
