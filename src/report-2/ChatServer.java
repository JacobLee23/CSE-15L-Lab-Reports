import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * 
 */
class Handler implements URLHandler {
    /**
     * 
     */
    ArrayList<String> messages = new ArrayList<String>();
    
    /**
     * 
     */
    public String handleRequest(URI url) {
        switch (url.getPath()) {
            case "/add-message":
                HashMap<String, String> parameters = new HashMap<>();
                for (String token: url.getQuery().split("&")) {
                    String[] parameter = token.split("=");
                    parameters.put(parameter[0], parameter[1]);
                }
                messages.add(
                    String.format(
                        "%s: %s", parameters.get("user"), parameters.get("s")
                    )
                );
                return String.join("\n", this.messages);
            default:
                return "404 Not Found";
        }
    }
}


/**
 * 
 */
class ChatServer {
    /**
     * Usage:
     * 
     * ```
     * $ javac ChatServer.java
     * $ java ChatServer <port>
     * ```
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println(
                String.format("Expected 1 parameter, got %d", args.length)
            );
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
