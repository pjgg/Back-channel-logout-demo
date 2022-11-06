package org.acme;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.oidc.runtime.DefaultTokenIntrospectionUserInfoCache;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

@PermitAll
@Path("/code-flow")
public class LogoutFlow {
    @Inject
    SecurityIdentity identity;

    @Inject
    DefaultTokenIntrospectionUserInfoCache tokenCache;

    @GET
    @Authenticated
    public String access() {
        return "Demo nov 2022: Hello " + identity.getPrincipal().getName() + ", cache size: " + tokenCache.getCacheSize();
    }

    @GET
    @Path("/post-logout")
    public String postLogout() {
        return "PostLogout invoked";
    }
}
