package org.acme;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.oidc.runtime.DefaultTokenIntrospectionUserInfoCache;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.logging.Logger;

@PermitAll
@Path("/code-flow")
public class LogoutFlow {
    private static final Logger LOG = Logger.getLogger(LogoutFlow.class);

    @Inject
    SecurityIdentity identity;

    @Inject
    DefaultTokenIntrospectionUserInfoCache tokenCache;

    @Inject
    Template web;

    @Inject
    Template logout;

    @GET
    @Authenticated
    public TemplateInstance access() {
        LOG.debug("Webapp Demo nov 2022: Hello " + identity.getPrincipal().getName() + ", cache size: " + tokenCache.getCacheSize());
        String name = identity.getPrincipal().getName();
        return web.data("name", name);
    }

    @GET
    @Path("/post-logout")
    public TemplateInstance postLogout() {
        return logout.data("result", "All sessions was removed!");
    }
}
