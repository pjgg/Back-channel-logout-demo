package org.acme;

import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

@PermitAll
@Path("/back-channel-logout")
public class BackChannelLogout {

    private static final Logger LOG = Logger.getLogger(BackChannelLogout.class);

    @POST
    public void backChannelLogout() {
        LOG.info("backChannelLogout: Logout invoked!");
    }
}
