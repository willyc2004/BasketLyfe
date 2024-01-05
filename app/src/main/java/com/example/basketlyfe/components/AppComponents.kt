package com.example.basketlyfe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basketlyfe.R
import com.example.basketlyfe.ui.theme.Prompt

@Composable
fun TextExtraBold(value: String, textColor: Color, modifier: Modifier) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = 30.sp,
            lineHeight = 20.sp,
            fontFamily = Prompt,
            fontWeight = FontWeight.ExtraBold,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextBold(value: String, textColor: Color, modifier: Modifier) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            lineHeight = 20.sp,
            fontFamily = Prompt,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    )
}

@Composable
fun TextNormal(value: String, textColor: Color, modifier: Modifier) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontFamily = Prompt,
            fontWeight = FontWeight.Normal,
            color = textColor,
        )
    )
}

@Composable
fun ImageSmall(image: Painter) {
    Image(
        modifier = Modifier
            .width(111.dp)
            .height(111.dp)
            .padding(bottom = 20.dp),
        painter = image,
        contentDescription = "null"
    )
}


@Composable
fun EmailTextField(
    email: String,
    onEmailChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
) {
    val isValidEmail = isValidEmail(email)

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = email,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { onEmailChanged(it) },
            placeholder = {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = null,
                        modifier = Modifier.size(21.dp),
                    )
                    Text(
                        text = "Email",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Prompt,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Handle done action if needed
                }
            ),
            singleLine = true,
            isError = isError || !isValidEmail,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
            ),
            trailingIcon = {
                if (email.isNotEmpty()) {
                    if (isValidEmail) {
                        Icon(Icons.Default.Check, contentDescription = "Valid Email", tint = Color.Green)
                    } else {
                        Icon(Icons.Default.Error, contentDescription = "Invalid Email", tint = Color.Red)
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (email.isNotEmpty() && !isValidEmail) {
            Text(
                modifier = Modifier
                    .semantics { contentDescription = "InvalidEmailMessage" }
                    .padding(start = 10.dp),
                text = "Invalid email format",
                color = Color.Red,
                fontSize = 12.sp,
                fontFamily = Prompt
            )
        }
    }
}
private fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^\\S+@\\S+\\.\\S+\$")
    return emailRegex.matches(email)
}

@Composable
fun PasswordTextField(
    text: String,
    modifier: Modifier = Modifier,
    semanticContentDescription: String = "",
    labelText: String = "",
    validateStrengthPassword: Boolean = false,
    hasError: Boolean = false,
    onHasStrongPassword: (isStrong: Boolean) -> Unit = {},
    onTextChanged: (text: String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val showPassword = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxWidth()
                .semantics { contentDescription = semanticContentDescription },
            value = text,
            onValueChange = onTextChanged,
            placeholder = {

                Row () {
                    Image(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = null,
                        modifier = Modifier.size(21.dp),
                    )

                    Text(
                        text = labelText,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Prompt,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

            },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            isError = hasError,
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) = if (showPassword.value) {
                    Pair(
                        Icons.Filled.Visibility,
                        Color.Black
                    )
                } else {
                    Pair(Icons.Filled.VisibilityOff, Color.Black)
                }

                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(
                        icon,
                        contentDescription = "Visibility",
                        tint = iconColor
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (validateStrengthPassword && text != "") {
            val strengthPasswordType = strengthChecker(text)
            if (strengthPasswordType == StrengthPasswordTypes.STRONG) {
                onHasStrongPassword(true)
            } else {
                onHasStrongPassword(false)
            }
            Text(
                modifier = Modifier
                    .semantics { contentDescription = "StrengthPasswordMessage" }
                    .padding(start = 10.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontFamily = Prompt
                        )
                    ) {
                        append(stringResource(id = R.string.warning_password_level))

                        when (strengthPasswordType) {
                            StrengthPasswordTypes.STRONG ->
                                withStyle(style = SpanStyle(color = Color.Green)) {
                                    append(" ${stringResource(id = R.string.warning_password_level_strong)}")
                                }

                            StrengthPasswordTypes.WEAK ->
                                withStyle(style = SpanStyle(color = Color.Red)) {
                                    append(" ${stringResource(id = R.string.warning_password_level_weak)}")
                                }
                        }

                    }
                }
            )
        }
    }
}

@Composable
fun ConfirmPasswordTextField(
    text: String,
    confirmText: String,
    modifier: Modifier = Modifier,
    semanticContentDescription: String = "",
    labelText: String = "",
    hasError: Boolean = false,
    onTextChanged: (text: String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val showPassword = remember { mutableStateOf(false) }
    val matchError = remember { mutableStateOf(false) }

    val borderColor = if (matchError.value) Color(0xFFAF2C22) else Color.Black

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        OutlinedTextField(
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxWidth()
                .semantics { contentDescription = semanticContentDescription },
            value = text,
            onValueChange = onTextChanged,
            placeholder = {
                Row () {
                    Image(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = null,
                        modifier = Modifier.size(21.dp),
                    )
                    Text(
                        text = labelText,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Prompt,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            isError = hasError || matchError.value,
            visualTransformation =
            if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) = if (showPassword.value) {
                    Pair(
                        Icons.Filled.Visibility,
                        Color.Black
                    )
                } else {
                    Pair(Icons.Filled.VisibilityOff, Color.Black)
                }

                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(
                        icon,
                        contentDescription = "Visibility",
                        tint = iconColor
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (confirmText != text) {
            Text(
                text = stringResource(id = R.string.error_password_no_match),
                color = Color.Red,
                fontSize = 12.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .semantics { contentDescription = "ConfirmPasswordMessage" }
                    .padding(start = 10.dp),
            )
            matchError.value = true
        } else {
            matchError.value = false
        }
    }
}

private fun strengthChecker(password: String): StrengthPasswordTypes =
    when {
        REGEX_STRONG_PASSWORD.toRegex().containsMatchIn(password) -> StrengthPasswordTypes.STRONG
        else -> StrengthPasswordTypes.WEAK
    }

enum class StrengthPasswordTypes {
    STRONG,
    WEAK
}

private const val REGEX_STRONG_PASSWORD =
    "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,})"

