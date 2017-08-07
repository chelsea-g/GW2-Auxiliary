package com.cgreger.persistence;

import org.apache.log4j.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * A Service Client to easily
 * request data from the Guildwars 2 API
 *
 * @author Chelsea Greger
 */
public class GW2ServiceClient {

    private Logger log = Logger.getLogger(this.getClass());
    private Client client;
    private WebTarget target;
    private String response = null;


    public GW2ServiceClient() { }

    /**
     * Sends the given request to the Guildwars 2 API.
     * If the response throws a NotFoundException, the API
     * is not currently running.
     *
     * @param requestUrl the complete request url
     * @return           the json response from the API
     */
    public String request(String requestUrl) {

        try {

            client = ClientBuilder.newClient();
            this.target = client.target(requestUrl);
            response = this.target.request(MediaType.APPLICATION_JSON).get(String.class);

        } catch (NotFoundException nfe) {

            log.error("API is currently down: " + nfe);

        }

        return response;

    }



}
