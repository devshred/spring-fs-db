package org.devshred.firebird

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Disabled("disabled since Firebird is not running on every platform")
class FirebirdApplicationTest {
    @Test
    fun contextLoads() {
    }
}