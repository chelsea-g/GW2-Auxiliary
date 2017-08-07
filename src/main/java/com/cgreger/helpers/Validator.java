package com.cgreger.helpers;

import com.cgreger.persistence.GW2ServiceClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.validator.*;
import org.apache.log4j.Logger;


import javax.ws.rs.ForbiddenException;
import java.io.IOException;

/**
 *
 */
public class Validator {

    private GW2ServiceClient gw2ServiceClient = new GW2ServiceClient();
    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = Logger.getLogger(this.getClass());

    /**
     *
     * @param email
     * @return
     */
    public boolean validateEmail(String email) {

        Boolean isValid = false;
        email = email.trim();

        if (email == null || "".equals(email)){

            isValid = false;

        } else {

            EmailValidator emailValidator = EmailValidator.getInstance();
            isValid = emailValidator.isValid(email);

        }

        log.info("VALID EMAIL: " + isValid);
        return isValid;

    }

    /**
     *
     * @param password
     * @param repeatPassword
     * @return
     */
    public boolean validatePassword(String password, String repeatPassword) {

        Boolean isValid = false;

        if (password.equals(repeatPassword) && password.length() >= 8) {

            isValid = true;

        }

        log.info("VALID PASSWORD: " + isValid);
        return isValid;

    }

    /**
     *
     * @param apiKey
     * @return
     */
    public boolean validateAPIKey(String apiKey) {

        Boolean isValid = false;

        try {

            String response = gw2ServiceClient.request("https://api.guildwars2.com/v2/tokeninfo?access_token=" + apiKey);

            try {

                JsonNode permissions = mapper.readValue(response, JsonNode.class).get("permissions");
                int neededPermissions = 0;
                log.info(permissions);

                //TODO: Find better way to do this...
                for (JsonNode permission : permissions) {

                    if (permission.toString().equals("\"account\"")) {

                        neededPermissions++;

                    } else if (permission.toString().equals("\"characters\"")) {

                        neededPermissions++;

                    } else if (permission.toString().equals("\"inventories\"")) {

                        neededPermissions++;

                    }

                }

                if (neededPermissions == 3) {

                    isValid = true;

                }

            } catch (IOException e) {

                isValid = false;

            }

        } catch (ForbiddenException fe) {

            //Bad apiKey
            isValid = false;

        }

        log.info("VALID API KEY: " + isValid);
        return isValid;

    }

}
