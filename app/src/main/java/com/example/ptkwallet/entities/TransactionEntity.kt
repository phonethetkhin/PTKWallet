package com.example.ptkwallet.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
        val transactionId:Int,
    @ColumnInfo(name = "trasaction_method")
        val transactionMethod:String,
    @ColumnInfo(name = "transaction_type")
        val transactionType:String,
        @ColumnInfo(name = "transaction_category")
        val transactionCategory:String,
                @ColumnInfo(name = "transaction_amount")
                val transactionAmount:Double,
    @ColumnInfo(name = "transaction_notes")
    val transactionNotes:String,
    @ColumnInfo(name = "transaction_date")
    val transactionDate:String
)
