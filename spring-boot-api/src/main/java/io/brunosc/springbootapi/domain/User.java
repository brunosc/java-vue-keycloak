package io.brunosc.springbootapi.domain;

import org.keycloak.representations.AccessToken;

public final class User {
    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;

    public User(AccessToken accessToken) {
        this.id = accessToken.getSubject();
        this.email = accessToken.getEmail();
        this.firstName = accessToken.getGivenName();
        this.lastName = accessToken.getFamilyName();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
