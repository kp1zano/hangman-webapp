 package edu.csumb.cst438fa16.hangman.rest;
 
 import edu.csumb.cst438fa16.hangman.Hangman;
 import java.util.ArrayList;
 import java.util.List;
 import javax.servlet.ServletContext;
 import javax.ws.rs.GET;
 import javax.ws.rs.Path;
 import javax.ws.rs.QueryParam;
 import javax.ws.rs.core.Context;
 import javax.ws.rs.core.Response;

@Path("")
public class HangmanResource {
    static final String HANGMAN_WORD_DEFAULT = "cat";
    static final String HANGMAN_WORD_PROPERTY_KEY = "hangman.word";
}

private static Hangman getHangman() {
        String word = System.getProperty(HANGMAN_WORD_PROPERTY_KEY,HANGMAN_WORD_DEFAULT);
        return new Hangman(word);
    }

 @Context ServletContext context;
@GET
    @Path("/start")
    public String start() {
             context.log("start called");
                 String pattern = getHangman().start();
                 context.log("start returns OK: " + pattern);
                 return pattern;
             }
