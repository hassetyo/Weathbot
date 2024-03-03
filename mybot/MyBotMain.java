import org.jibble.pircbot.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class MyBotMain extends PircBot{
    
    public static void main(String[] args) throws Exception {
        // Now start our bot up.
        MyBot bot = new MyBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.libera.chat");

        // Join the #pircbot channel.
        bot.joinChannel("#hassetyoseph");

        bot.sendMessage("#hassetyoseph", "Enter any message and I'll respond");

        
        
    }
    
}

//javac -cp .:pircbot.jar MyBotMain.java
//java -cp .:pircbot.jar MyBotMain
