package com.zh;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<String,Object>();
        claims.put("id",1);
        claims.put("username","zh");

        String token= JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))
                .sign(Algorithm.HMAC256("zh"));

        System.out.println(token);
    }


    @Test
    public void testParse(){

        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InpoIn0sImV4cCI6MTczNDY0MTc3NH0." +
                "lug0_zxolDP1rl03EZzdkBmr5M3gOLhNzOwYUpdjXlo";

        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("zh")).build();

        DecodedJWT decodedJWT=jwtVerifier.verify(token);

        Map<String, Claim> claims=decodedJWT.getClaims();

        System.out.println(claims.get("user"));
    }

}
