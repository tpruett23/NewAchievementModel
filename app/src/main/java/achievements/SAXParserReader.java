package achievements;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import achievements.AchievementXMLHandler;
import achievements.Achievements;

/**
 * The class parses through an XML document.
 * @author Andrew Scott & Tori Pruett
 * @version 1.0
 */
public class SAXParserReader extends FragmentActivity {

    /**
     * Instance of the SaxParserReader.
     */
    private static SAXParserReader instance;

    /**
     * The name of the XML file we are reading.
     */
    private static String filename;

    /**
     * The arraylist to hold all the achievements.
     */

    ArrayList<Achievements> achievements = new ArrayList<>();
    /**
     * Achievement instance to get needed data.
     */
    Achievements ach = new Achievements();
    /**
     * Context for the class.
     */
    Context context;
    /**
     * Constructor for the SaxParserReader.
     * @param context
     */
    public SAXParserReader(Context context){
        onCreate(context);
    }//end constructor

    /**
     * Contructor
     */
    public SAXParserReader(){

    }

    public void onCreate(Context context){
        this.context = context;
        this.instance = this;
        filename = "achxmltester";

    }//end onCreate

    /**
     * Opens the XML file and calls the methods to parse it.
     */
    public void parseXML() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlreader = saxParser.getXMLReader();


            AchievementXMLHandler handler = new AchievementXMLHandler();
            xmlreader.setContentHandler(handler);

           InputStream inStream = this.context.getResources().openRawResource(R.raw.achxmltester);
            InputSource inStream2 = new InputSource(inStream);
            xmlreader.parse(inStream2);

        } catch (ParserConfigurationException e) {
            Toast.makeText(this.context, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (SAXException e) {
            Toast.makeText(this.context, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method turns the object into an xml file.
     * @return The XML String.
     */
    public String toXML() {
        return "<achievement>\n" +
                "\t<name>" + ach.getName()+ "</name>\n" +
                "\t<points>" + ach.getPoints() + "</points>\n" +
                "\t<description>" + ach.getDescription() + "</description>\n" +
                "\t<type>" + ach.getDescriptorA()+ "</type>\n" +
                "</achievement>";


       /* return "<achievement>\n" +
                "\t<name>" + "name"+ "</name>" +
                "\t<points>" + "points" + "</points>" +
                "\t<description>" + "des" + "</description>" +
                "\t<type>" + "type" + "</type>" +
                "</achievement>";
                */
    }


    /**
     * Save the objects as XML data to Internal Storage.
     */
    public void save() {

        String xml_data  = toXML();

        //Create a file if its not already on disk
        File filesDIR = this.context.getFilesDir();
        File file = new File(this.context.getFilesDir(), filename);

        FileOutputStream outputStream;//declare FOS

        try {

            outputStream = this.context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(xml_data.getBytes());
            outputStream.close();

            Toast.makeText(this.context, "Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this.context, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this.context, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {//else if failed trying do this
            Toast.makeText(this.context, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Loads the achievements from internal storage.
     */
        public void load() {
            File extDir = new File(context.getFilesDir(), filename);
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(extDir));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
            }//end try
            catch (FileNotFoundException e) {//If file not found on disk here.
                Toast.makeText(this.context, "There was no data to load", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            } catch (IOException e)//If io Exception here
            {
                Toast.makeText(this.context, "Error loading file", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }//end catch
            //Set the data from the file content and convert it to a String
            String data = new String(text);

            //Safety first Parse data if available.
            if (data.length() > 0) {
                parseXML();
            } else
                Toast.makeText(this.context, "There is no data to display", Toast.LENGTH_LONG).show();
        }//end LOAD


    }



