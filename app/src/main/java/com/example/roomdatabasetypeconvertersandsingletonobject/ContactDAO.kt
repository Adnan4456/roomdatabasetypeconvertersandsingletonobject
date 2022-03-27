package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO  {

    //execute this function on background thread.
    //using coroutines for that
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    //for get methods use LiveData.
    //Room will check the return type is Live data then by default
    //run this task on background thread.
    //No need for suspend function here, if using LiveData.
    @Query("SELECT * from contact")
    fun  getContact(): LiveData<List<Contact>>


}