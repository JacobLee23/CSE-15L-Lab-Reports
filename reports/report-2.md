# Lab Report 2

---

# Chat Server

```java
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;


class Handler implements URLHandler {

    ArrayList<String> messages = new ArrayList<String>();

    public String handleRequest(URI url) {
        switch (url.getPath()) {
            case "/":
                return String.format(
                    "Message Count: %d", this.messages.size()
                );
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


class ChatServer {

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
```

*ChatServer.java*


## Compile/Run

```bash
$ cd src/report-2/
$ javac ChatServer.java Server.java
$ java ChatServer 8050
Server Started
```

## Message 1

* **Message**: *You look very kickable*
* **User**: Brenton Dunn
* **URL**: `http://127.0.0.1:8050/add-message?s=You%20look%20very%20kickable&user=Brenton%20Dunn`

![Message 1](CSE-15L-Lab-Reports/assets/report-2/message-1.png)


## Message 2

* **Message**: *Rocks can be a hobby. Throwing rocks is a fun past time. Especially at people.*
* **User**: Joelle Chien
* **URL**: `http://127.0.0.1:8050/add-message?s=Rocks%20can%20be%20a%20hobby.%20Throwing%20rocks%20is%20a%20fun%20past%20time.%20Especially%20at%20people.&user=Joelle%20Chien`

![Message 2](CSE-15L-Lab-Reports/assets/report-2/message-2.png)

---

---

# Relevant XKCD

![Relevant XKCD](https://imgs.xkcd.com/comics/im_an_idiot.png)
