
package edu.csumb.cst438fa16.QuestionsAnswers.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class QuestionsAnswersResourceTest extends JerseyTest {
	
	@Override
    protected Application configure() {
        return new ResourceConfig(QuestionsAnswersResource.class);
    }
	
	@Test
    public void testRandomQuestions() {
        WebTarget webTarget = target("randomquestion");
        String thestart = webTarget.request().get(String.class);
        assertThat(thestart, anyOf(is("Roses are "), is("Violets are "), is("Oranges are ")));
    }
	
	@Test
	public void testBlank(){
		WebTarget webTarget = target("testanswer").queryParam("answer", " ")
												  .queryParam("question", "Roses are ");
		
		Response response = webTarget.request().get();
		assertThat(response.getStatus(),equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
		
	}
}