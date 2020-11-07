package com.chayoticace.cc17unit4assignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Settings
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<Button>(R.id.button2).setOnClickListener({bluetoothSettings()})
        findViewById<Button>(R.id.button3).setOnClickListener({colosseumLocale()})
        findViewById<Button>(R.id.button4).setOnClickListener({addContact("Alexander Luthor", "LexLuthor@Lex.com", "4231940")})
    }

    private fun bluetoothSettings(){ // opening the bluetooth settings page
        val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    private fun addContact(name: String, email:String, mobileno: String){ //adding a new contact
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.EMAIL, email)
            putExtra(ContactsContract.Intents.Insert.PHONE, mobileno)
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    private fun colosseumLocale(){ //Coordinates for the colosseum
        val gmmIntentUri = Uri.parse("geo:41.890251,12.492373")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }

    }
}