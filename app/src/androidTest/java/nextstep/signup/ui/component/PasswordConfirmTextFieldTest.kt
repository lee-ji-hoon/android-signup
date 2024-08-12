package nextstep.signup.ui.component

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.signup.R
import nextstep.signup.core.validation.PasswordMatchValidationResult
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordConfirmTextFieldTest {

    private val passwordConfirmFieldValue = mutableStateOf("")
    private val passwordMatchValidationResult = mutableStateOf(PasswordMatchValidationResult.VALID)
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordConfirmTextField(
                passwordConfirmValue = passwordConfirmFieldValue.value,
                onPasswordConfirmChange = { passwordConfirmFieldValue.value = it },
                passwordMatchValidationResult = passwordMatchValidationResult.value
            )
        }
    }

    @Test
    fun 입력이_없다면_아무런에러가_노출되면안된다() {
        passwordConfirmFieldValue.value = ""
        passwordMatchValidationResult.value = PasswordMatchValidationResult.VALID

        composeTestRule
            .onNodeWithText(context.getString(R.string.signup_password_mismatch_error))
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호가_일치할_때_에러가_없다() {
        passwordConfirmFieldValue.value = "CorrectPassword123"
        passwordMatchValidationResult.value = PasswordMatchValidationResult.VALID

        composeTestRule
            .onNodeWithText(context.getString(R.string.signup_password_mismatch_error))
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호가_일치해야_한다() {
        passwordConfirmFieldValue.value = "CorrectPassword123"
        passwordMatchValidationResult.value = PasswordMatchValidationResult.MISMATCH

        composeTestRule
            .onNodeWithText(context.getString(R.string.signup_password_mismatch_error))
            .assertExists()
    }

    @Test
    fun 비밀번호가_일치했다가_변경이되면_에러가_노출이되어야한다() {
        passwordConfirmFieldValue.value = "CorrectPassword123"
        passwordMatchValidationResult.value = PasswordMatchValidationResult.VALID

        composeTestRule
            .onNodeWithText(context.getString(R.string.signup_password_mismatch_error))
            .assertDoesNotExist()

        passwordMatchValidationResult.value = PasswordMatchValidationResult.MISMATCH

        composeTestRule
            .onNodeWithText(context.getString(R.string.signup_password_mismatch_error))
            .assertExists()
    }
}