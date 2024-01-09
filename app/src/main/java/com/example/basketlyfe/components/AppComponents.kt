package com.example.basketlyfe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccessTimeFilled
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
import androidx.navigation.NavHostController
import com.example.basketlyfe.R
import com.example.basketlyfe.model.CompetitionListModel
import com.example.basketlyfe.ui.theme.Prompt


@Composable
fun CompetitionCard(
    competition: CompetitionListModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(top = 18.dp, bottom = 18.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("detail/${competition.id}")
            },
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
//            Spacer(modifier = Modifier.height(18.dp))
            Image(painter = painterResource(id = competition.image),
                contentDescription = null, // Set a meaningful content description
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Adjust the height as needed
                contentScale = ContentScale.Crop
            )

            TextNormal(value = competition.name, textColor = Color.Black, modifier = Modifier.padding(10.dp))

            Row {
                Icon(Icons.Rounded.LocationOn, contentDescription = "Address",
                    modifier = Modifier
                        .padding(PaddingValues(start = 5.dp, bottom = 9.dp)))


                TextNormal(value = competition.address, textColor = Color.Black, modifier = Modifier)
            }

        }
    }
}

@Composable
fun ScheduleCard(
    competition: CompetitionListModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(top = 18.dp, bottom = 18.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("detail/${competition.id}")
            },
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
//            Spacer(modifier = Modifier.height(18.dp))
            Image(painter = painterResource(id = competition.image),
                contentDescription = null, // Set a meaningful content description
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Adjust the height as needed
                contentScale = ContentScale.Crop
            )

            TextNormal(value = "Lapangan", textColor = Color.Black, modifier = Modifier.padding(10.dp))

            Row {
                Icon(Icons.Rounded.AccessTimeFilled, contentDescription = "Clock",
                    modifier = Modifier
                        .padding(PaddingValues(start = 5.dp, bottom = 9.dp)))


                TextNormal(value = "22 December 2023", textColor = Color.Black, modifier = Modifier)
            }

            Row {
                Icon(Icons.Rounded.AccessTimeFilled, contentDescription = "Clock",
                    modifier = Modifier
                        .padding(PaddingValues(start = 5.dp, bottom = 9.dp)))


                TextNormal(value = "14.00-16.00", textColor = Color.Black, modifier = Modifier)
            }

            Row {
                Icon(Icons.Rounded.LocationOn, contentDescription = "Address",
                    modifier = Modifier
                        .padding(PaddingValues(start = 5.dp, bottom = 9.dp)))


                TextNormal(value = competition.address, textColor = Color.Black, modifier = Modifier)
            }

        }
    }
}
@Composable
fun ImageBorder(
    imageResId: Int,
    borderResId: Int,
    size: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(RoundedCornerShape(16.dp)) // Adjust the corner radius as needed
    ) {
//        // Border layer
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .clip(RoundedCornerShape(16.dp))
//                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
//        )

        // Image layer
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .clip(RoundedCornerShape(16.dp)) // Match the corner radius used for the outer Box
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null, // Provide a content description for accessibility
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Border SVG
        Image(
            painter = painterResource(id = borderResId),
            contentDescription = null, // Provide a content description for accessibility
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)) // Match the corner radius used for the outer Box
        )
    }
}

@Composable
fun Reminder(
    title: String,
    date: String,
    start: String,
    end: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6D41A0)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            // Calendar Icon
            Image(
                painter = painterResource(id = R.drawable.reminder),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(vertical = 8.dp)
            )
            Column {
                // Title
                TextLight(value = title, textColor = Color.White, modifier = Modifier, size = 16)

                // Spacing
                Spacer(modifier = Modifier.height(4.dp))

                // Date and Time Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
//                    val formattedDate = "${date.month} ${date.day}"

                    TextLight(
                        value = date,
                        textColor = Color.White,
                        modifier = Modifier,
                        size = 14
                    )
                    Spacer(modifier = Modifier.width(10.dp))

//                    Icon(imageVector = Icons.Outlined, contentDescription = null)
                    Image(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
//                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    TextLight(
                        value = "$start - $end",
                        textColor = Color.White,
                        modifier = Modifier,
                        size = 14
                    )
                }
            }
        }
    }
}

@Composable
fun FAB(onClick: () -> Unit, size: Int) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(size.dp),
            containerColor = Color(0xFFED6C30)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
        }
    }
}
@Composable
fun TextField(value: String, placeHolder: String, onValueChange: (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        placeholder = {
            Text(
                text = placeHolder,
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = Prompt,
                modifier = Modifier.padding(start = 2.dp)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFED6C30), // Orange outline color
            unfocusedBorderColor = Color(0xFFED6C30), // Orange outline color
//            textColor = Color.Black // Black text color
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
    )
}
@Composable
fun Schedule(
    name: String,
    start: String,
    end: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFED6C30)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            // Calendar Icon
            Image(
                painter = painterResource(id = R.drawable.schedule),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(vertical = 8.dp)
            )
            Column {
                // Title
                TextLight(value = "Booked by $name", textColor = Color.White, modifier = Modifier, size = 16)

                // Spacing
                Spacer(modifier = Modifier.height(4.dp))

                // Date and Time Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
//                    val formattedDate = "${date.month} ${date.day}"

//                    Icon(imageVector = Icons.Outlined, contentDescription = null)
                    Image(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
//                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    TextLight(
                        value = "$start - $end",
                        textColor = Color.White,
                        modifier = Modifier,
                        size = 14
                    )
                }
            }
        }
    }
}

@Composable
fun BackIcon(
    imageResId: Int,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = imageResId),
        contentDescription = null, // Content description for accessibility
        modifier = modifier
    )
}

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
fun TextBoldMod(value: String, textColor: Color, modifier: Modifier, size: Int) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = size.sp,
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
fun TextLight(value: String, textColor: Color, modifier: Modifier, size: Int) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = size.sp,
            lineHeight = 20.sp,
            fontFamily = Prompt,
            fontWeight = FontWeight.Light,
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
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Valid Email",
                            tint = Color.Green
                        )
                    } else {
                        Icon(
                            Icons.Default.Error,
                            contentDescription = "Invalid Email",
                            tint = Color.Red
                        )
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
                text = "Format Email tidak Valid",
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

    val strengthPasswordType = strengthChecker(text)

    val borderColor = if (strengthPasswordType == StrengthPasswordTypes.STRONG) {
        Color.Black
    } else {
        Color(0xFFAF2C22)
    }

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

                Row() {
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
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
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
                Row() {
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

