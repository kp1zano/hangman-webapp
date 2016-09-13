package edu.csumb.cst438fa16.QuestionsAnswers.rest;

import edu.csumb.cst438fa16qa.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("")
public class QuestionsAnswersResource {
	
	QuestionsAnswers questions = new QuestionsAnswers();
	
	public QuestionsAnswersResource(){
		questions.put("Roses are ", "red");
		questions.put("Violets are ", "blue");
		questions.put("Oranges are ", "orange");
	}
	
	 @GET
	    @Path("/randomquestion")
	 	public String randQuestions(){
		 
		 return questions.getRandomQuestion();
	 }
		
	
	 
	 @GET
	    @Path("/testanswer")
	 	public Response testQuestion(@QueryParam("question") String q,
	 								 @QueryParam("answer") String a){
		 
		 boolean correct = questions.testAnswer(q, a);
		 
		 if(correct){
			 return Response.ok(a + " is the correct answer to " + q).build();
			 
		 }
			 return Response.status(Response.Status.BAD_REQUEST).entity(a + " is not the correct answer to " + q).build();
		 
	 }
}