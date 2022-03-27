package com.example.roomdatabasetypeconvertersandsingletonobject

import androidx.room.TypeConverter
import java.util.*

class Convertors {

    @TypeConverter
    fun FromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun  FromLongToDate(value: Long):Date{
        return Date(value)
    }
}