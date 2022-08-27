package com.meetingroom.book.utils.jwt

import com.meetingroom.book.utils.jwt.payload.UserInfoPayload
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class JwtUtilsTest : FunSpec({
    test("generate - 같은 정보로 만들면 토큰이 동일") {
        val payload = UserInfoPayload(email = "example@ex-em.com")
        val token1 = JwtUtils.generate(payload)
        val token2 = JwtUtils.generate(payload)

        token1 shouldBe token2
    }

    test("generate - 다른 정보로 만들면 토큰이 동일") {
        val token1 = JwtUtils.generate(UserInfoPayload(email = "example@ex-em.com"))
        val token2 = JwtUtils.generate(UserInfoPayload(email = "example@ex-em.com"))

        token1 shouldNotBe token2
    }

    test("generate -> getClaims 변환 테스트") {
        val payload = UserInfoPayload(email = "example@ex-em.com")
        val token = JwtUtils.generate(payload)
        val claims = JwtUtils.getClaims<UserInfoPayload>(token)

        payload shouldBe claims
    }
})
