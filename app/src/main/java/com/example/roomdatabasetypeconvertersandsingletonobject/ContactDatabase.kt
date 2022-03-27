package com.example.roomdatabase

import android.content.Context
import androidx.room.*
import com.example.roomdatabasetypeconvertersandsingletonobject.Convertors

//database have more than one entity.Therefore we use list
@Database(entities = [Contact::class] , version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase(){

    //link interface ConatctDao with this database.using function
    abstract fun contactDao(): ContactDAO // return type is interface ContactDAO.

    //If you have more than one DAO .Then use more functions to link with database.

    companion object{
        //Volatile will update all threads if there is any update in INSTANCE variable.
        @Volatile
        private var INSTANCE : ContactDatabase? =null

        fun getDatabase(context: Context):ContactDatabase{

            if (INSTANCE == null){
                //synchronized will create only one object of databasein application.
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext ,
                        ContactDatabase::class.java,
                        "contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}