package com.example.basketlyfe.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.R
import com.example.basketlyfe.components.ConfirmPasswordTextField
import com.example.basketlyfe.components.EmailTextField
import com.example.basketlyfe.components.ImageSmall
import com.example.basketlyfe.components.PasswordTextField
import com.example.basketlyfe.components.TextBold
import com.example.basketlyfe.components.TextExtraBold
import com.example.basketlyfe.components.TextNormal
import com.example.basketlyfe.ui.ListScreen
import com.example.basketlyfe.ui.theme.Prompt

@Composable
fun Daftar(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var konfirmasi by remember { mutableStateOf("") }
    var hasStrongPassword by remember { mutableStateOf(false) }

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextExtraBold(
                value = "Daftar",
                textColor = Color(0xFFED6C30),
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            )

            ImageSmall(image = painterResource(id = R.drawable.logo))

            TextBold(
                value = "Email", textColor = Color(0xFFED6C30),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp)
                    .padding(top = 4.dp, bottom = 8.dp),
            )

            EmailTextField(
                email = email,
                onEmailChanged = { newEmail -> email = newEmail },
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            TextBold(
                value = "Password", textColor = Color(0xFFED6C30),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp)
                    .padding(top = 6.dp),
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

            TextBold(
                value = "Konfirmasi Password", textColor = Color(0xFFED6C30),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp)
                    .padding(top = 14.dp),
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

                TextNormal(
                    value = "Sudah punya akun?", textColor = Color(0xFF252525),
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .padding(top = 4.dp),
                )

                TextNormal(
                    value = "Masuk Sekarang", textColor = Color(0xFFED6C30),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .padding(top = 4.dp)
                        .clickable { navController.navigate(ListScreen.Masuk.name) },
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
                TextBold(
                    value = "Daftar",
                    textColor = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp),
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DaftarPreview() {
    val navController = rememberNavController()
    Daftar(navController = navController)
}