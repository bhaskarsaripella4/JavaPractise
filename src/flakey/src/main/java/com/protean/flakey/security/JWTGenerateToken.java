package com.protean.flakey.security;

import io.jsonwebtoken.*;

import javax.crypto.spec.*;
import javax.xml.bind.*;
import java.security.*;
import java.util.*;

public class JWTGenerateToken {
    // think how to make this singleton.
    String token;

    public JWTGenerateToken(String studyId, String eventId, String timeStamp, String userId){
        this.token = this.generateToken(studyId, eventId, timeStamp, userId);
    }

    public String generateToken(String studyId, String eventId, String timeStamp, String userId){
        String token = null;
        //JWT signature algorithm used in SDSS application to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        final String SECRET_KEY = userId;
        // Sign JWT with apiKey
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        System.out.println("Value of apiKeySecretBytes "+ apiKeySecretBytes);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //JWT claims
        JwtBuilder builder = Jwts.builder().setId(studyId).setIssuedAt(now).setSubject(eventId).setIssuer(userId)
                .signWith(signatureAlgorithm, signingKey);

        long expMillis = nowMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);

        // builds the token and serializes it to a compact, URL safe strig
        token = builder.compact();
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }

    public static void main(String[] args) {
        JWTGenerateToken token = new JWTGenerateToken("some_studyId","1234", "2023-09-21T14:07:57.1732Z","saripelv");
        System.out.println(token.getToken());
    }
}
