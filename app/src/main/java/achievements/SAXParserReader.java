package achievements;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.app.FragmentActivity;
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
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import achievements.AchievementXMLHandler;
import achievements.Achievements;


public class SAXParserReader extends FragmentActivity{



    private static String filename = "achxmltester.xml";

    ArrayList<Achievements> achievements = new ArrayList<>();



    Context context;

    public SAXParserReader(Context context){
        onCreate(context);
    }//end constructor

    public void onCreate(Context context){
        this.context = context;


    }//end onCreate




    public void parseXML() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlreader = saxParser.getXMLReader();


            AchievementXMLHandler handler = new AchievementXMLHandler();
            xmlreader.setContentHandler(handler);



           InputStream inStream = context.getResources().openRawResource(R.raw.achxmltester);
            InputSource inStream2 = new InputSource(inStream);
            xmlreader.parse(inStream2);

        } catch (ParserConfigurationException e) {
            Toast.makeText(this, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (SAXException e) {
            Toast.makeText(this, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toXML() {
        return "<achievement>\n" +
                "\t<name>" + Achievements.getName()+ "</name>" +
                "\t<points>" + Achievements.getPoints() + "</points>" +
                "\t<description>" + Achievements.getDescription() + "</description>" +
                "</achievement>";
    }


    /**
     * Save the objects as XML data to Internal Storage.
     */
    public void save() {

        String xml_data = toXML();

        //Create a file if its not already on disk
        File file = new File(this.getFilesDir(), filename);


        //String string = "";

        FileOutputStream outputStream;//declare FOS

        try {  //to do this
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(xml_data.getBytes());
            outputStream.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {//else if failed trying do this
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


        public void load() {

            //Create a file if its not already on disk
            File extDir = new File(this.getFilesDir(), filename);

            //Read text from file
            StringBuilder text = new StringBuilder();



            try {

                BufferedReader br = new BufferedReader(new FileReader(extDir));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }//end while

                br.close();//Close the buffer
            }//end try
            catch (FileNotFoundException e) {//If file not found on disk here.
                Toast.makeText(this, "There was no data to load", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            } catch (IOException e)//If io Exception here
            {
                Toast.makeText(this, "Error loading file", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }//end catch


            //Set the data from the file content and conver it to a String
            String data = new String(text);

            //Safety first Parse data if available.
            if (data.length() > 0) {
                parseXML();
            } else
                Toast.makeText(this, "There is no data to display", Toast.LENGTH_LONG).show();
        }//end LOAD


    }



