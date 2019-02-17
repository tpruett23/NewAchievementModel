package achievements;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import achievements.AchievementDescriptor;
import achievements.AchievementFactory;
import achievements.Achievements;
import achievements.CheckAchievements;
import achievements.Distance;
import achievements.DistanceCheck;
import achievements.Speed;
import achievements.SpeedCheck;
import achievements.StepCheck;
import achievements.Steps;
import achievements.Time;
import achievements.TimeCheck;
import achievements.TrailNumCheck;
import achievements.Trails;
import achievements.Validation;

public class ValidXMLHandler extends DefaultHandler {
    String validname;
    String validType;
    /** A global list of achievements **/
    private  static ArrayList<Validation> valid;
    /**
     d
     /**
     * A temp achievement built to get each marker element
     *
     */
    Validation temp;
    /**
     * Achievements instance.
     */
    Validation temp2;
    /**
     * Boolean value to check what level of xml tags we are in.
     */

    boolean types;

    /** The current element being read by the XML parser**/
    String tmpName, tmpDesc, tmpPoints,tmpADPoints;

    /** The current element being read off**/
    private String currentElement;

    //=========================================================================
    /**
     *  Handle XML and store the result in the arrayList.
     */
    //=========================================================================
    public  ValidXMLHandler() {
     valid = new ArrayList<>();


    }//========================================================================

    //=========================================================================
    /**
     * Return the array list achievements.
     * @return
     */
    //=========================================================================
    public static ArrayList<Validation> getValid(){
        return valid;
    }//========================================================================

    /**
     * Gets the second Achievement instance.
     * @return
     */
    public  Validation getTemp2(){
        return this.temp2;
    }//========================================================================

    /**
     * Called when a start element is found
     * @param uri The xml name space uri
     * @param localName The name of the xml tag opening i.e. marker
     * @param qName The fully qualified name of the tag opening i.e. xs:marker.
     * @param attributes Any attributes that happen to be with the tag.
     * @throws SAXException  SAXException Any SaxException, possibly wrapping another exception
     */
    //=========================================================================
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  throws SAXException {

        if(qName.equals("Valid") ) {//When marker found new tag is reached.
            validType = "";
            validname = "";

        }
        else if(qName.equals("name")){
            currentElement = validname;

        }

        else if(qName.equals("type")) {
                currentElement = validType;


        }else
            currentElement = null;

    }//end startElement========================================================

    //=========================================================================
    /**
     * When closing tag is reached.
     * @param uri
     * @param localName The name of the closing tag i.e. lat
     * @param qName The fully qualified name of the closing tag i.e. xs:lat
     * @throws SAXException   SAXException Any SaxException, possibly wrapping another exception
     */
    //=========================================================================
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (temp == null)
            temp = new Validation();

     else if (qName.equals("name")) {//when title is found close
//            temp.setName(currentElement);


        } else if (qName.equals("type")){
//        temp.setType(currentElement);
     }


       if (qName.equals("Valid") && temp != null) {
            valid.add(temp);

            temp = null;//</achievement> is found set to null.
        }

        currentElement = null;


    }//========================================================================


    //=========================================================================
    /**
     * Read the characters in. This may be called two or three times for one element
     * @param ch  An array of characters read.
     * @param start The start position of the character array.
     * @param length The number of characters to use from the array.
     * @throws SAXException Any SaxException, possibly wrapping another exception.
     */
    //=========================================================================
    @Override
    public void characters(char[] ch, int start, int length)  throws SAXException {

        if (currentElement != null) {
            currentElement = currentElement + new String(ch, start, length);
        }

    }//=========================================================================


}
