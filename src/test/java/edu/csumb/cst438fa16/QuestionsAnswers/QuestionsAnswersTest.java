package edu.csumb.cst438fa16.QuestionsAnswers;

import edu.csumb.cst438fa16qa.QuestionsAnswers;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;



public class QuestionsAnswersTest {
	
    @Test
    public void testEmptyWord() {
	QuestionsAnswers questionsanswers = new QuestionsAnswers();
	questionsanswers.put("Roses are ", "red");
	assert(questionsanswers.testAnswer("Roses are ", "red") == true);
    }
    
    @Test
    public void testCorrectAnswer(){
    QuestionsAnswers questions = new QuestionsAnswers();
    questions.put("Violets are ", "blue");
    assert(questions.testAnswer("Violets are ", "red") == false);
    }

	
}
 