package com.example.whatsapclone.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whatsapclone.DestinationScreen
import com.example.whatsapclone.MCViewModel
import com.example.whatsapclone.R
import com.example.whatsapclone.ui.Component.CheckBox
import com.example.whatsapclone.ui.Component.CommonProgressBar
import com.example.whatsapclone.ui.Component.HeadingTextComponent
import com.example.whatsapclone.ui.Component.Logo
import com.example.whatsapclone.ui.Component.MyTextFields
import com.example.whatsapclone.ui.Component.NormalTextComponent
import com.example.whatsapclone.ui.Component.NormalTextComponent2
import com.example.whatsapclone.ui.Component.PasswordFields
import com.example.whatsapclone.ui.theme.White


@Composable
fun SignUpScreen(
    navController: NavController,
    vm: MCViewModel
) {
    val focus = LocalFocusManager.current

    val numberState = remember { mutableStateOf(TextFieldValue()) }
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Logo()

            NormalTextComponent(
                value = stringResource(id = R.string.hey_there),
            )

            HeadingTextComponent(value = stringResource(id = R.string.createAcc))


            MyTextFields(
                texts = stringResource(id = R.string.phoneNo),
                paint = painterResource(id = R.drawable.phone)
            )

            MyTextFields(
                texts = stringResource(id = R.string.email),
                paint = painterResource(id = R.drawable.email)
            )
            PasswordFields(
                pass = stringResource(id = R.string.password),
                paint = painterResource(id = R.drawable.lock)
            )
            CheckBox(value = stringResource(id = R.string.checkbox),navController)

                Button(
                    onClick = {
                        navController.navigate(DestinationScreen.HomeScreen.Route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = "SignUp",
                        color = White
                    )
                }



            NormalTextComponent2(
                value = stringResource(id = R.string.alreadyhaveacc), navController
            )

            if(vm.inProgress.value){
                CommonProgressBar()
            }
        }
    }
}
