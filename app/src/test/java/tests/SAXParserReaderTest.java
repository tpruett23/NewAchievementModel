package tests;

import android.app.Application;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Xml;

import org.junit.Before;
import org.junit.Test;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileOutputStream;

public class SAXParserReaderTest extends Application {

    String filename = filename = "file.txt";
    Context context;

    /**
     * Set up tests
     */
    @Before
    public void setUp(){
        context = getApplicationContext();
    }

    @Test
    public void save(){
        try {
            FileOutputStream fos = null;
            fos = openFileOutput(filename, Context.MODE_APPEND);
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(fos, "UTF-8");
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

            serializer.startTag(null, "root");
            for(int j = 0; j < 3; j++){
                serializer.startTag(null,  "record");
                serializer.text("data");
                serializer.endTag(null, "record");
            }
            serializer.endDocument();

            serializer.flush();

            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
