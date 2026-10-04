import com.artistle.bloom.identifiers.EmailAddress
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull

class EmailAddressTest {

    @Test
    fun `trims spaces and lowercases`() {
        assertEquals("user@example.com", EmailAddress.parseOrNull("  User@Example.COM ")?.value)
    }

    @Test
    fun `preserves dots and plus in the local part`() {
        assertEquals("first.last+tag@example.com", EmailAddress.parseOrNull("first.last+tag@example.com")?.value)
    }

    @Test
    fun `converts a Cyrillic domain to punycode`() {
        assertEquals("user@xn--d1acpjx3f.xn--p1ai", EmailAddress.parseOrNull("user@яндекс.рф")?.value)
    }

    @Test
    fun `a domain with a Cyrillic letter does not match the Latin one`() {
        val latin = EmailAddress.parseOrNull("user@example.com")
        val withCyrillicA = EmailAddress.parseOrNull("user@exаmple.com") // the second letter is Cyrillic
        assertNotEquals(latin, withCyrillicA)
    }

    @Test
    fun `masks the address in toString`() {
        assertEquals("u***@example.com", EmailAddress.parseOrNull("user@example.com").toString())
    }

    @Test
    fun `rejects a too long local part`() {
        assertNull(EmailAddress.parseOrNull("a".repeat(65) + "@example.com"))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "",
            "user",
            "@example.com",
            "user@",
            "a@b@example.com",
            "user@localhost",
            ".user@example.com",
            "user.@example.com",
            "us..er@example.com",
            "user@-example.com",
            "user@exa_mple.com",
            "user@example.com.",
            "юзер@example.com",
        ],
    )
    fun `rejects invalid addresses`(raw: String) {
        assertNull(EmailAddress.parseOrNull(raw))
    }
}