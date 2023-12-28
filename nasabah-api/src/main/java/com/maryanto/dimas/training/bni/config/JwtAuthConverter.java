package com.maryanto.dimas.training.bni.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractRoles(jwt).stream()
        ).collect(Collectors.toList());

        return new JwtAuthenticationToken(jwt, authorities, getPrincipal(jwt));
    }

    public String getPrincipal(Jwt jwt){
        String principalName = JwtClaimNames.SUB;
        return jwt.getClaim(principalName);
    }

    public Collection<? extends GrantedAuthority> extractRoles(Jwt jwt){
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()){
            return new ArrayList<>();
        }

        Collection<GrantedAuthority> roles = ((List<String>) realmAccess.get("roles"))
                .stream().map(role -> "ROLE_" + role)
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());

        return roles;
    }
}
