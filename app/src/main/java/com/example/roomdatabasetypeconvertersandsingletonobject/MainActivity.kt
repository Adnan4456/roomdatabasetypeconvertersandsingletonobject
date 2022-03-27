package com.example.roomdatabasetypeconvertersandsingletonobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.roomdatabase.Contact
import com.example.roomdatabase.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)

        //we are calling suspend function.from coroutine to run this code in background.
        GlobalScope.launch {
            //insert record into  your database using abstract fun.
            database.contactDao().insertContact(Contact(0  , "Khan" ,"87542422" , Date()))
        }
    }

    fun getdata(v: View){
        database.contactDao().getContact().observe(this,{

            Log.d("MainActivty", it.toString())
        })
    }
}