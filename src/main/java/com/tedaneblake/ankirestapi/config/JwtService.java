package com.tedaneblake.ankirestapi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    // Todo: move this to a config file
    private static final String SECRET_KEY = "2b698ab47d997fe5c02dce2206df76323103fe531db8b86a75bfbc791c8a5b94";

    /**
    * A method to extract username from a JWT token
    * @param jwtToken the JWT token
    * @return String username
    * */
    public String extractUsername(String jwtToken) {
        // :: is a method reference, it is a shorthand for a lambda expression
        // for example, this: extractClaim(jwtToken, claims -> claims.getSubject());
        // is the same as this: extractClaim(jwtToken, Claims::getSubject);
        // why is the subject the username? because we set the subject to be the username when we generate the JWT token
        return extractClaim(jwtToken, Claims::getSubject);
    }

    /**
    *  A method to generate a JWT token without any claims
    * @param userDetails the user details
    * @return String jwtToken
    * */
    public String generateToken(UserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }
    /**
    * A method to generate a JWT token with claims
    * @param claims the claims to be added to the JWT token
    * @param userDetails the user details
    * @return String jwtToken
    *
     */
    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 1 day
        return Jwts
                .builder()
                .setClaims(claims) // set the claims
                .setSubject(userDetails.getUsername()) // set the subject
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // set the expiration date
                .signWith(getSigningKey(), SignatureAlgorithm.HS384) // set the signing key and the algorithm
                .compact(); // build the JWT token
    }
    /**
    * This method will extract all the claims from the JWT token.
    * a claim is a piece of information about the user.
    * For example, the username, the expiration date, the issuer, etc.
    *
    * @param jwtToken the JWT token
    * @return Claims
    */
    public Claims extractAllClaims(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }
    /**
    * This method will return the signing key.
    * The signing key is used to sign the JWT token.
    * The signing key is a secret key that only the server knows.
    *
    * @return Key signingKey
     */
    private Key getSigningKey() {
        byte [] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    /**
    * This method will extract the expiration date from the JWT token.
    * @param jwtToken the JWT token
    * @return Date expirationDate
     */
    public Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }
    /**
    * This method will extract the expiration date from the JWT token.
    * It will return true if the expiration date is before the current date.
    *
    * @param jwtToken the JWT token
    * @return boolean
    * */
    public boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }
    /**
    * This method will check if the username in the JWT token is the same as the username in the UserDetails object.
    * It will also check if the token is expired.
    * @param jwtToken the JWT token
    * @param userDetails the user details
     */
    public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
    }
    /**
    * This method will extract a claim from the JWT token.
    * @param jwtToken the JWT token
    * @param claimsResolver a function that will return the value of the claim
     */
    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver){
      final Claims claims = extractAllClaims(jwtToken);
      // claimsResolver.apply(claims) will return the value of the claim
        return claimsResolver.apply(claims);
    }
}
