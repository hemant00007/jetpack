package com.example.kotlin_jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_jetpack.models.Quotelist
import com.example.kotlin_jetpack.models.Result

@Database(entities =  [Result::class],version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun queteDao(): QuoteDao

//    What is an abstract class in Kotlin?
//    A class which is declared with abstract keyword is known as abstract class. An abstract class
//    cannot be instantiated. Means, we cannot create object of abstract class.
//    The method and properties of abstract class are non-abstract unless they are explicitly declared as abstract.
    companion object{
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context):QuoteDatabase{
            if (INSTANCE ==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context
                    ,QuoteDatabase::class.java,
                    "quoteDB")
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}