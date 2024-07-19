package com.example.whatsapclone.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.whatsapclone.R
import com.example.whatsapclone.ui.Component.CheckBox
import com.example.whatsapclone.ui.Component.HeadingTextComponent
import com.example.whatsapclone.ui.Component.LoginButton
import com.example.whatsapclone.ui.Component.Logo
import com.example.whatsapclone.ui.Component.MyTextFields
import com.example.whatsapclone.ui.Component.NormalTextComponent
import com.example.whatsapclone.ui.Component.NormalTextComponent2
import com.example.whatsapclone.ui.Component.NormalTextComponent3
import com.example.whatsapclone.ui.theme.White


@Composable
fun LoginScreen(
    navController: NavController
) {
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
                value = stringResource(id = R.string.hey_there)
            )

            HeadingTextComponent(value = stringResource(id = R.string.heading2))

            MyTextFields(
                texts = stringResource(id = R.string.phoneNo),
                paint = painterResource(id = R.drawable.phone)
            )

            CheckBox(
                value = stringResource(id = R.string.checkbox, navController),
                navController
            )

            LoginButton {

            }

            NormalTextComponent3(
                value = stringResource(id = R.string.createAcc)
                , navController)

        }
    }
}
