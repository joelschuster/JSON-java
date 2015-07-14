package com.quietpond.json;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by joels on 7/13/15.
 */
public class TestXmlToJson {


    public static int PRETTY_PRINT_INDENT_FACTOR = 2;
    public static String TEST_XML_STRING =
            "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) throws IOException {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(readFile("src/test/resources/empi/wsdl/EMPI_18080_2.wsdl", StandardCharsets.UTF_8));
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);

            JSONObject xmlJSONObj2 = XML.toJSONObject(readFile("src/test/resources/empi/xsd/mdm.xsd", StandardCharsets.UTF_8));
            String jsonPrettyPrintString2 = xmlJSONObj2.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString2);

        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }


    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
