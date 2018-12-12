package achievements;

import android.content.Context;
import android.widget.ListView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import achievements.Achievements;

/**
 * Created by Andrew on 4/15/2015.
 */
public class AchievementXMLHandler extends DefaultHandler {
    /** A global list of achievements **/
    private  static ArrayList<Achievements> achievements1;
    /**
     * Achievement factory instance.
     */
    AchievementFactory af = new AchievementFactory();
    /**
     * A temp achievement built to get each marker element
     *
     */
   Achievements temp;
    /**
     * Achievements instance.
     */
   Achievements temp2 = new Achievements();
    /**
     * Boolean value to check what level of xml tags we are in.
     */
   boolean types  =  false;

    /** The current element being read by the XML parser**/
    String tmpName, tmpDesc, tmpPoints,tmpADPoints;

    /** The current element being read off**/
    private String currentElement;

    //=========================================================================
    /**
     *  Handle XML and store the result in the arrayList.
     */
    //=========================================================================
    public AchievementXMLHandler() {
        achievements1 = new ArrayList<>();

    }//========================================================================

    //=========================================================================
    /**
     * Return the array list achievements.
     * @return
     */
    //=========================================================================
    public static ArrayList<Achievements> getAchievements(){
        return achievements1;
    }//========================================================================

    /**
     * Gets the second Achievement instance.
     * @return
     */
    public  Achievements getTemp2(){
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

        if(qName.equals("achievement") ) {//When marker found new tag is reached.
            temp = new Achievements();
            //Re-initialize for next item
            tmpName = "";
            tmpDesc = "";
            tmpPoints = "";
            tmpADPoints = "";
            types = false;
        }
        else if(qName.equals("name")){
            currentElement = tmpName;

        }

        else if(qName.equals("description")) {
            currentElement = tmpDesc;

        }else if(qName.equals("points")) {
            currentElement = tmpPoints;

        }else if(qName.equals("type")){
                types = true;

        }else if(qName.equals("time")){
            currentElement = tmpADPoints;

        }else if(qName.equals("distance")){
            currentElement = tmpADPoints;

        }else if(qName.equals("trails")){
            currentElement = tmpADPoints;

        }else if(qName.equals("steps")){
            currentElement = tmpADPoints;

        }else if(qName.equals("speed")){
            currentElement = tmpADPoints;

        }else if(qName.equals("challenges")){
            currentElement = tmpADPoints;

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
        AchievementFactory af = new AchievementFactory();

            if (temp == null)
                temp = new Achievements();

            /** set value */
            if (qName.equals("name")) {//when title is found close
                temp.setName(currentElement);


            } else if (qName.equals("description")) {
                temp.setDescription(currentElement);


            } else if (qName.equals("points")) {
                temp.setPoints(Integer.parseInt(currentElement));


            }else if(types == true) {

                if (qName.equals("time")) {
                    AchievementDescriptor TimeAch = new Time("Time Achievement", temp.getPoints(), Integer.parseInt(currentElement), temp.getDescription(), 0);
                    temp.setDescriptor(TimeAch);
                    af.addCompleted(temp,TimeAch);
                    temp2.getAllAchievements().add(TimeAch);

                } else if (qName.equals("distance")) {
                    AchievementDescriptor distanceAch = new Distance("Distance Achievement", temp.getPoints(), Double.parseDouble("900"), temp.getDescription());
                    temp.setDescriptor(distanceAch);
                    temp2.getAllAchievements().add(distanceAch);
                   // af.addCompleted(temp,distanceAch);

                } else if (qName.equals("trails")) {
                    AchievementDescriptor trailAch = new Trails("Trail Achievement", temp.getPoints(), temp.getDescription(), Integer.parseInt(currentElement));
                    temp.setDescriptor(trailAch);
                    temp2.getAllAchievements().add(trailAch);
                    af.addCompleted(temp,trailAch);

                } else if (qName.equals("step")) {
                    AchievementDescriptor stepAch = new Steps("Step Achievement", temp.getPoints(),temp.getDescription(),200);
                    temp.setDescriptor(stepAch);
                    temp2.getAllAchievements().add(stepAch);
                    af.addCompleted(temp,stepAch);

                } else if (qName.equals("speed")) {
                    AchievementDescriptor speedAch = new Speed("Speed Achievement", temp.getPoints(), Integer.parseInt(currentElement), temp.getDescription());
                    temp.setDescriptor(speedAch);
                    temp2.getAllAchievements().add(speedAch);
                    af.addCompleted(temp,speedAch);

                } else if (qName.equals("challenges")) {
                    AchievementDescriptor challAch = new Challenges("Challenge Achievement", temp.getPoints(), Integer.parseInt(currentElement), temp.getDescription());
                    temp.setDescriptor(challAch);
                    temp2.getAllAchievements().add(challAch);
                    af.addCompleted(temp,challAch);

                }
            }


            if (qName.equals("achievement") && temp != null) {
                System.out.println(temp);
                achievements1.add(temp);
                temp = null;//</achievement> is found set to null.
                System.out.println(achievements1);
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
