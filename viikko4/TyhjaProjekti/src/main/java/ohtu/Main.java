package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014603574";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        System.out.println(bodyText2);
        Course course = mapper.fromJson(bodyText2, Course.class);
        
        
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println("Kurssi: " + course);
        for (Submission submission : subs) {
            System.out.println(submission);
        }

    }
}
