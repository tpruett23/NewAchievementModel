package achievements;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import achievements.Achievements;

/**
 * Created by Andrew on 4/15/2015.
 */
public class AchievementXMLHandler extends DefaultHandler {

    /**A global list of map markers**/
    private  static ArrayList<Achievements> achievements;

    /**A temp map marker built to get each marker element**/
   Achievements temp;

    /**The current element being read by the XML parser**/
    String tmpName, tmpDesc, tmpPoints;

    /**The current element being read off**/
    private String currentElement;


    //=========================================================================
    /**
     *  Handle XML and store the result in the arrayList.
     */
    //=========================================================================
    public AchievementXMLHandler() {
        achievements = new ArrayList<Achievements>();

    }//========================================================================

    //=========================================================================
    /**
     * Return the array list of completed map markers.
     * @return
     */
    //=========================================================================
    public static ArrayList<Achievements> getAchievements(){
        return achievements;
    }//========================================================================

    //=========================================================================
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

        if( qName.equals("achievement")) {//When marker found new tag is reached.
            temp = new Achievements();
            //Re-initialize for next item
            tmpName = "";
            tmpDesc = "";
            tmpPoints = "";
        }
        else if(qName.equals("name")){
            currentElement = tmpName;
        }
        else if(qName.equals("description")) {
            currentElement = tmpDesc;
        }
        else if(qName.equals("points")) {
            currentElement = tmpPoints;
        }else
            currentElement = "100";

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

        //Create  new Person. If tmp is null we must be at a new record because
        //when </person is found it is set to null.
        if (temp == null)
             temp = new Achievements();

        /** set value */
        if(qName.equals("name")){//when title is found close
            temp.setName(currentElement);
        }
        else if(qName.equals("description")){
            temp.setDescription(currentElement);

        }
        else if(qName.equals("points")){
            temp.setPoints(Integer.parseInt(currentElement));
        }

        if( qName.equals("achievement") && temp != null) {//When person is found  again the person is complete
            achievements.add(temp);
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

}//end class####################################################################
