package com.example.userserviceevebatch;

import com.example.userserviceevebatch.security.service.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.UUID;

@SpringBootTest
class UserServiceEveBatchApplicationTests {

    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;
//    @Test
//    void addSampleRegisteredClient() {
//        RegisteredClient.Builder builder = RegisteredClient.withId(UUID.randomUUID().toString());
//        builder.clientId("oidc-client");
//        builder.clientSecret("$2a$12$G2ZP0f0AZdWxCHPVp8Y75ueMJVtjreFE/9uSqBDxqs9QoC9/cLndu");
//        builder.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC);
//        builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
//        builder.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN);
//        builder.redirectUri("https://oauth.pstmn.io/v1/callback");
//        builder.postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback");
//        builder.scope(OidcScopes.OPENID);
//        builder.scope(OidcScopes.PROFILE);
//        builder.scope("ADMIN");
//        builder.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build());// scaler
//        RegisteredClient oidcClient = builder
//                .build();
//
//        jpaRegisteredClientRepository.save(oidcClient);
//    }

}
