package com.example.basketlyfe.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.ui.theme.Prompt
import com.example.basketlyfe.viewmodel.DaftarViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Daftar(
    viewModel: DaftarViewModel,
    navController: NavController,
    dataStore: DataStoreManager
) {
    Scaffold {
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
                    value = "Name", textColor = Color(0xFFED6C30),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 10.dp)
                        .padding(top = 4.dp, bottom = 8.dp),
                )

                TextField(
                    value = viewModel.name,
                    onValueChange = viewModel::onNameChanged,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )

                TextBold(
                    value = "Email", textColor = Color(0xFFED6C30),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 10.dp)
                        .padding(top = 4.dp, bottom = 8.dp),
                )

                EmailTextField(
                    email = viewModel.email,
                    onEmailChanged = viewModel::onEmailChanged,
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
                    text = viewModel.password,
                    onTextChanged = viewModel::onPasswordChanged,
                    validateStrengthPassword = true,
//                hasError = hasStrongPassword.not(),
                    onHasStrongPassword = { isStrong ->
                        viewModel.updateHasStrongPassword(isStrong)
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
                    text = viewModel.konfirmasi,
                    confirmText = viewModel.password,
                    onTextChanged = viewModel::onKonfirmasiChanged,
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
                            .clickable { viewModel.onMasukClicked() },
                    )
                }

                Button(
                    onClick = {
                        viewModel.registerUser(
                            name = viewModel.name,
                            email = viewModel.email,
                            password = viewModel.password,
                            dataStore = dataStore,
                            navController = navController
                        )
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
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DaftarPreview() {
    val viewModel: DaftarViewModel = viewModel()
    val navController = rememberNavController()
    val dataStore = DataStoreManager(LocalContext.current)
    Daftar(viewModel, navController, dataStore)
}