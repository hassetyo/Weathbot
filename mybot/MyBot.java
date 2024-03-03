import org.jibble.pircbot.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;
import java.util.Scanner;

public class MyBot extends PircBot {

    public MyBot() {
        this.setName("weatherMan");
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        Scanner input = new Scanner(System.in);
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }

        String zip = null;

        if (message.contains("weather")) {
            message = message.replace("weather ", "");
            zip = message;

            HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://api.interzoid.com/getweatherzipcode?license=d7b0499e11bda7d0cb465614ecb10dc8&zip=" + zip))
            .header("x-api-key","d7b0499e11bda7d0cb465614ecb10dc8")
            .GET()
            .build();

            HttpClient HttpClient = java.net.http.HttpClient.newHttpClient();

            HttpResponse<String> getResponse = null;
            
            try {
                getResponse = HttpClient.send(getRequest, BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            sendMessage(channel, sender + ": " + getResponse.body());

        }
        else if(!message.equalsIgnoreCase("time"))
        {
            sendMessage(channel, sender + ": heyyy");
        }


    }
}

