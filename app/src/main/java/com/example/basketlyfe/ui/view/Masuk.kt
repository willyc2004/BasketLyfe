package com.example.basketlyfe.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.basketlyfe.R
import com.example.basketlyfe.ui.ListScreen
import com.example.basketlyfe.ui.theme.Prompt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Masuk(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var hasStrongPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Masuk",
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

        Row(modifier = Modifier.align(Alignment.Start)) {
            Text(
                text = "Belum punya akun?",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .padding(top = 4.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = Prompt,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF252525),
                )
            )

            Text(
                text = "Daftar Sekarang",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .padding(top = 4.dp)
                    .clickable { navController.navigate(ListScreen.Daftar.name)},
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
                .padding(top = 140.dp),
        )
        {
            Text(
                text = "Masuk",
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
            modifier = Modifier.padding(top=16.dp),
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



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MasukPreview() {
//    Masuk()
//}