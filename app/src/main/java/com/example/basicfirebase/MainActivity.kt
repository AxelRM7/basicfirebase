package com.example.basicfirebase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Firebase.database
        val myRef = database.reference

        //myRef.child("Cartas").child("1").setValue(Card("1","Rojo","Corazones"))
        //myRef.child("Cartas").child("2").setValue(Card("2","Negro","Trebol"))
        //myRef.child("Cartas").child("3").setValue(Card("3","Rojo","Diamantes"))

        myRef.child("Usuarios").child("1").setValue(User("Alejandro Garcia","M",22, "Queréndaro"))
        myRef.child("Usuarios").child("2").setValue(User("Andrea Andrade","F",22, "Querendaro"))
        myRef.child("Usuarios").child("3").setValue(User("Yamir Garcia","M",22, "Morelia"))

        myRef.child("Usuarios").child("3").get().addOnSuccessListener { response ->
            Log.d("Response", response.value.toString())
        }.addOnFailureListener {
            Log.d("Response","Error")
        }




    }
}