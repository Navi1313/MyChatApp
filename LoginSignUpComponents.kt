package com.example.whatsapclone.ui.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.whatsapclone.DestinationScreen
import com.example.whatsapclone.R
import com.example.whatsapclone.ui.theme.ComponentShapes
import com.example.whatsapclone.ui.theme.White
import com.example.whatsapclone.MCViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun Logo() {

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,){
        Image(

            painter = painterResource(id = R.drawable.logo_mychat_background),
            contentDescription = "new logo", modifier = Modifier
                .padding(14.dp)
        )
    }
}
@Composable
fun NormalTextComponent(value: String
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            ,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal
        ),
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = TextAlign.Center,
    )
}
@Composable
fun NormalTextComponent2(
    value: String, navController:NavController
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                navController.navigate(DestinationScreen.Login.Route)
            },
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal
        ),
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = TextAlign.Center,
    )
}
@Composable
fun NormalTextComponent3(
    value: String, navController:NavController
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                navController.navigate(DestinationScreen.SignUp.Route)
            },
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal
        ),
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = TextAlign.Center,
    )
}
@Composable
fun HeadingTextComponent(value: String) {

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFields(texts: String, paint: Painter) {

    val textVal = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .clip(ComponentShapes.small)
            .fillMaxWidth()
            .padding(12.dp),
        value = textVal.value,
        label = { Text(text = texts) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textVal.value = it
        },
        leadingIcon = {
            Icon(painter = paint, contentDescription = "")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFields(pass : String, paint: Painter){

    val password = remember { mutableStateOf("") }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(ComponentShapes.small)
            .padding(14.dp),
        value = password.value,
        label = { Text(text = pass) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            password.value =it }
        ,
        leadingIcon = {
            Icon(painter = paint, contentDescription = "")
        },
        trailingIcon ={
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }
            // visual transformation

            else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value){
                stringResource(id = R.string.hide_password)
            }
            else{
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value =  !passwordVisible.value}) {
                Icon(imageVector = iconImage , contentDescription = null)
            }
        },
        visualTransformation = if(passwordVisible.value){
            VisualTransformation.None}
        else{
            PasswordVisualTransformation()
        }
    )
}
@Composable
fun CheckBox(value: String, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value, onCheckedChange = {
                checkedState.value = !checkedState.value
            },

        )
        Text(text = value,
            style = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.tertiary,
                fontStyle = FontStyle.Italic
            ),
            modifier = Modifier
                .clickable {
                    navController.navigate(DestinationScreen.TermsandCondition.Route)
            }
        )
    }
}

@Composable
fun ButtonComponent() {
        Button(modifier = Modifier
            .fillMaxWidth()
            .heightIn(10.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            onClick = {

            }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp)
                    .background(
                        brush = Brush.horizontalGradient(listOf())
                    )
            ) {
        }
    }
}

//@Composable
//fun SignUpButton(navController: NavController, vm : MCViewModel) {
//    val focus = LocalFocusManager.current
//
//    var numberState = remember { mutableStateOf(TextFieldValue()) }
//    var emailState = remember { mutableStateOf(TextFieldValue()) }
//    var passwordState = remember { mutableStateOf(TextFieldValue()) }
//        Button(
//            onClick = {
//                      vm.signup(
//                          numberState.value.text,
//                          emailState.value.text,
//                          passwordState.value.text
//                      )
//                      },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            Text(text = "SignUp",
//                color = White)
//   }
//}

@Composable
fun LoginButton(onClick: () -> Unit) {
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Send OTP",
                color = White)
   }
}

@Composable
fun LoginText(onClick: () -> Unit) {
        Text(
            text = " Click here to Login",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(horizontal = 13.dp),
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                color = MaterialTheme.colorScheme.tertiary
        )
    )
}

@Composable
fun CommonProgressBar() {
    Row(modifier = Modifier
        .alpha(0.5f)
        .background(MaterialTheme.colorScheme.tertiary)
        .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically) {

        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun djfs() {
    Logo()
}