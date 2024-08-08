package nextstep.signup.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 42.dp),
            text = stringResource(R.string.signup_title),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SignupTextField(
    text: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        placeholder = { Text(text = placeHolder) },
        onValueChange = onValueChange,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    SignupTheme {
        SignupScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupTextFieldPreview() {
    SignupTheme {
        SignupTextField(
            text = "이지훈",
            placeHolder = "이름",
            onValueChange = {}
        )
    }
}