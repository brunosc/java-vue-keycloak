package io.brunosc.springbootapi.controller;

import io.brunosc.springbootapi.domain.User;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping
    ResponseEntity<User> getUser(Principal principal) {
        return ResponseEntity.ok(mapUser(principal));
    }

    private User mapUser(Principal principal) {
        KeycloakAuthenticationToken keycloakPrincipal = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakPrincipal.getAccount().getKeycloakSecurityContext().getToken();
        return new User(accessToken);
    }

}
