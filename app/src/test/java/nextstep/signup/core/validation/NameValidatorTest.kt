@file:Suppress("NonAsciiCharacters")

package nextstep.signup.core.validation

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class NameValidatorTest {

    private val validator = NameValidator()

    @Test
    fun `유효한 이름은 통과해야 한다`() {
        val result = validator.validate("John")
        assertTrue(result.isValid)
    }

    @Test
    fun `이름이 너무 짧으면 실패해야 한다`() {
        val result = validator.validate("J")
        assertFalse(result.isValid)
        assertEquals("이름은 2~5자여야 합니다.", result.message)
    }

    @Test
    fun `이름이 너무 길면 실패해야 한다`() {
        val result = validator.validate("JohnDoe")
        assertFalse(result.isValid)
        assertEquals("이름은 2~5자여야 합니다.", result.message)
    }

    @Test
    fun `이름에 숫자가 포함되면 실패해야 한다`() {
        val result = validator.validate("John1")
        assertFalse(result.isValid)
        assertEquals("이름에는 숫자나 기호가 포함될 수 없습니다.", result.message)
    }
}