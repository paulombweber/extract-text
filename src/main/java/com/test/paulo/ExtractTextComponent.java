package com.test.paulo;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ToTextContentHandler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class ExtractTextComponent {

    public String extractText(String file) {
        try (InputStream stream = new ClassPathResource(file).getInputStream()) {
            AutoDetectParser parser = new AutoDetectParser();
            Metadata metadata = new Metadata();
            ContentHandler handler = new ToTextContentHandler();
            parser.parse(stream, handler, metadata);
            return handler.toString().replaceAll("\n", "\r\n");
        } catch (IOException | TikaException | SAXException e) {
            e.printStackTrace();
            throw new RuntimeException("Error extracting text from file", e);
        }
    }
}