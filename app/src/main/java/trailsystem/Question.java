package trailsystem;

import java.util.Collection;

/**
 * Question class which will hold questions and answers
 * that will be asked at a point of interest
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class Question extends PointOfInterest {

    /** Question to be asked */
    private String question;

    /** Collection of choices to be selected*/
    private Collection<String> choices;

    /** Correct answer to the specified question*/
    private String answer;

    /**
     * Set a new question for the point of interest
     * @param question - new question
     */
    public void setQuestion(String question){
        this.question = question;
    }//end setQuestion()

    /**
     * Get the question to be asked
     * @return - question
     */
    public String getQuestion(){
        return question;
    }//end getQuestion()

    /**
     * add a choice to the question, assuming it is not the right
     * answer
     * @param choice - possible answer to the question
     */
    public void addChoice(String choice){
        addChoice(choice, false);
    }//end addChoice

    /**
     * add a choice to the question
     * @param choice - possible answer to the question
     * @param correct - if the choice is correct
     */
    public void addChoice(String choice, boolean correct){
        //check if already an answer
        if(!choices.contains(choice))
            choices.add(choice);

        //check if correct
        if(correct){
            setAnswer(choice);
        }//end if

    }//end addChoice()

    /**
     * Get the collections of possible answers
     * @return - choices to the question
     */
    public Collection<String> getChoices(){
        return choices;
    }//end getChoices()

    /**
     * Set the new answer to the question
     * @param answer - new answer
     */
    public void setAnswer(String answer) {
        if(!this.answer.equals(answer))
            this.answer = answer;
    }//end setAnswer()

}//end Question class
