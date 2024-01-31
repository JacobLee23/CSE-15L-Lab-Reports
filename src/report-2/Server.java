import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


/**
 * 
 */
interface URLHandler {
    /**
     * 
     * @param url
     * @return
     */
    String handleRequest(URI url);
}


/**
 * 
 */
class ServerHTTPHandler implements HttpHandler {
    /**
     * 
     */
    URLHandler handler;

    /**
     * 
     * @param handler
     */
    ServerHTTPHandler(URLHandler handler) {
        this.handler = handler;
    }

    /**
     * 
     */
    public void handle(final HttpExchange exchange) throws IOException {
        try {
            String ret = handler.handleRequest(exchange.getRequestURI());
            exchange.sendResponseHeaders(200, ret.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(ret.getBytes());
            os.close();
        } catch (Exception e) {
            String response = e.toString();
            exchange.sendResponseHeaders(500, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}


/**
 * 
 */
public class Server {
    /**
     * 
     * @param port
     * @param handler
     * @throws IOException
     */
    public static void start(int port, URLHandler handler) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new ServerHTTPHandler(handler));

        server.start();
        System.out.println("Server Started");
    }
}
