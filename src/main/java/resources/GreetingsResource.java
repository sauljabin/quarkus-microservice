package resources;

import entity.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("/greetings")
public class GreetingsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message hello() throws UnknownHostException {
        return Message.builder().message("Hello World!!!, I am " + InetAddress.getLocalHost().getHostName()).build();
    }
}