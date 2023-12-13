package com.example.basketlyfe.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.R
import com.example.basketlyfe.ui.ListScreen
import com.example.basketlyfe.ui.theme.Prompt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Daftar(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var konfirmasi by remember { mutableStateOf("") }
    var hasStrongPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Daftar",
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 20.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight(800),
                color = Color(0xFFED6C30),
                textAlign = TextAlign.Center,
            )
        )

        Image(
            modifier = Modifier
                .width(111.dp)
                .height(111.dp)
                .padding(bottom = 20.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "image description"
        )

        Text(
            text = "Email",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
                .padding(top = 4.dp, bottom = 8.dp),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight(700),
                color = Color(0xFFED6C30)
            )
        )

        EmailTextField(
            email = email,
            onEmailChanged = { newEmail -> email = newEmail },
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Password",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
                .padding(top = 6.dp),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight(700),
                color = Color(0xFFED6C30)
            )
        )

        PasswordTextField(
            text = password,
            onTextChanged = { newPassword ->
                password = newPassword
            },
            validateStrengthPassword = true,
            hasError = hasStrongPassword.not(),
            onHasStrongPassword = { isStrong ->
                hasStrongPassword = isStrong
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            semanticContentDescription = "Masukkan Password",
            labelText = "Masukkan Password"
        )

        Text(
            text = "Konfirmasi Password",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
                .padding(top = 14.dp),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight(700),
                color = Color(0xFFED6C30)
            )
        )

        ConfirmPasswordTextField(
            text = konfirmasi,
            confirmText = password,
            onTextChanged = { newPassword ->
                konfirmasi = newPassword
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            semanticContentDescription = "Konfirmasi Password",
            labelText = "Konfirmasi Password"
        )



        Row(modifier = Modifier.align(Alignment.Start)) {
            Text(
                text = "Sudah punya akun?",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .padding(top = 4.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = Prompt,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF252525)
                )
            )

            Text(
                text = "Masuk Sekarang",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .padding(top = 4.dp)
                    .clickable { navController.navigate(ListScreen.Masuk.name) },
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = Prompt,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFED6C30),
                )
            )
        }

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color(0xFFED6C30)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
        )
        {
            Text(
                text = "Daftar",
                modifier = Modifier.padding(vertical = 8.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontFamily = Prompt,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
        }
        val text = buildAnnotatedString {
            append("Dengan masuk atau mendaftar, kamu menyetujui ")
            withStyle(style = SpanStyle(color = Color(0xFFED6C30))) {
                append("Ketentuan layanan")
            }
            append(" dan ")
            withStyle(style = SpanStyle(color = Color(0xFFED6C30))) {
                append("Kebijakan privasi.")
            }

        }

        Text(
            text = text,
            modifier = Modifier.padding(top = 16.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Prompt,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF252525),
                textAlign = TextAlign.Center,
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                textColor = Color.Black,
                cursorColor = Color.Black,
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


@OptIn(ExperimentalMaterial3Api::class)
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
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                textColor = Color.Black,
                cursorColor = Color.Black,
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

@OptIn(ExperimentalMaterial3Api::class)
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
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                textColor = Color.Black,
                cursorColor = Color.Black,
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DaftarPreview() {
    val navController = rememberNavController()
    Daftar(navController = navController)
}