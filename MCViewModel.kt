package com.example.whatsapclone

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.whatsapclone.Data.Events
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MCViewModel @Inject constructor
    (
    private val auth : FirebaseAuth
    , ) : ViewModel(){

                init {}

    var inProgress = mutableStateOf(false)
    private val eventMutableOf = mutableStateOf<Events<String>?>(null)

    fun signup(number: String, email: String, password: String){

        auth.createUserWithEmailAndPassword(email, password)
            . addOnCompleteListener{

            if(it.isSuccessful) {
                Log.d("TAG", " Successful Login")
            }
            else{

            }
        }
    }

    fun handleException(exception: Exception?=null, customMessage : String=""){
        Log.e("WhatsAppClone" , "live chat exception" ,exception )
        exception?.printStackTrace()
        val Errormsg = exception?.localizedMessage?:""
        val message = if(customMessage.isEmpty()) Errormsg else customMessage

        eventMutableOf.value = Events(message)
        inProgress.value = false
    }
}

