package com.meetingroom.book.utils.jwt

import com.meetingroom.book.utils.json.JsonUtils
import com.meetingroom.book.utils.jwt.payload.JwtPayload
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm.HS256
import java.util.*
import kotlin.text.Charsets.UTF_8


object JwtUtils {
    val secretKey = "TzOQalfoLmChBJSLwJm2NUvgnvLpsyNr".toByteArray(UTF_8)

    val HEADER = mapOf<String, Any>(
        "typ" to "JWT",
        "alg" to "HS256",
    )

    inline fun <reified T: JwtPayload> generate(payload: T) = Jwts.builder()
        .setHeader(HEADER)
        .setClaims(JsonUtils.convert<T, Map<String,Any>>(payload))
        .setIssuedAt(Date())
        .signWith(HS256, secretKey)
        .compact()

    inline fun <reified R: JwtPayload> getClaims(token: String): R = JsonUtils.convert(Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .body
        .toMap())
}