package lab.aikibo;

import com.jaunt.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        UserAgent userAgent = new UserAgent();

        try {
            userAgent.visit("http://www.bkn.go.id/profil-pns");
        } catch(ResponseException e) {e.printStackTrace(); }

        try {
            userAgent.sendPOST("http://www.bkn.go.id/profil-pns", "nip=198404092010011025");

            Elements elements1 = userAgent.doc.findEvery("<span>");
            for(Element data : elements1) {
                if(data.getAt("class").equals("value")) {
                    System.out.println(data.innerHTML().substring(2));
                }
            }
        } catch(NotFound e) {  }
          catch (SearchException e) { e.printStackTrace(); }
          catch(ResponseException e) { e.printStackTrace(); }
    }
}
