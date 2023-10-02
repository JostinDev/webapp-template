package com.template.appgateway.security;

import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;

public class Auth0CustomAuthorizationRequestResolver extends DefaultServerOAuth2AuthorizationRequestResolver {
    public Auth0CustomAuthorizationRequestResolver(String audience, ReactiveClientRegistrationRepository reactiveClientRegistrationRepository) {
        super(reactiveClientRegistrationRepository);

        this.setAuthorizationRequestCustomizer(
                customizer -> customizer.additionalParameters (
                        params -> params.put("audience", audience)
                )

        );
    }
}

