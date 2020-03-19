package com.example.ptkwallet.daos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.ptkwallet.entities.TransactionEntity

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transactionEntity: TransactionEntity)

    @Delete()
    suspend fun deleteTransactio(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM tbl_transaction")
     fun getAllTransactions() : LiveData<List<TransactionEntity>>
}