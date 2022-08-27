package com.meetingroom.book.utils.json

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class JsonUtilsTest : FunSpec({

    test("convert") {
        val source = TestClass()

        val expected: Map<String, Any> = JsonUtils.convert(source)

        expected["a"] shouldBe source.a
        expected["b"] shouldBe source.b
        expected["c"] shouldBe source.c.toString()
    }

    test("convert - 재 변환시 데이터 동일한지 확인") {
        val source = TestClass()

        val postConverted: Map<String, Any> = JsonUtils.convert(source)
        val expected: TestClass = JsonUtils.convert(postConverted)

        expected shouldBe source
    }
})

private data class TestClass(
    val a: String = "a",
    val b: Long = 10L,
    val c: LocalDateTime = LocalDateTime.now(),
)
