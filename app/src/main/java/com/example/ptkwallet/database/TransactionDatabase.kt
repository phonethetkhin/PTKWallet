package com.example.ptkwallet.database

import android.content.Context
import android.os.Environment
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ptkwallet.daos.TransactionDao
import com.example.ptkwallet.entities.TransactionEntity
import java.io.File

@Database(entities = [TransactionEntity::class],version = 1,exportSchema = false)
abstract class TransactionDatabase : RoomDatabase(){

abstract fun transactiondao():TransactionDao

companion object
{
    @Volatile
    var INSTANCE:TransactionDatabase?=null
    fun getTransactionDB(context: Context) : TransactionDatabase?
    {
        if(INSTANCE==null)
        {
            synchronized(this)
            {

                INSTANCE= Room.databaseBuilder(context,TransactionDatabase::class.java,"ptk.db")

                    .build()

            }
        }
        return INSTANCE
    }
    fun destoryTransactionDB()
    {
        INSTANCE=null
    }


    }
}