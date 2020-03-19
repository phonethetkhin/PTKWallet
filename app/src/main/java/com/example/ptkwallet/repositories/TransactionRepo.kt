package com.example.ptkwallet.repositories

import com.example.ptkwallet.daos.TransactionDao
import com.example.ptkwallet.entities.TransactionEntity

class TransactionRepo(val transactionDao: TransactionDao) {

    val transitionlivedata = transactionDao.getAllTransactions()


    suspend fun insertTransaction(transactionEntity: TransactionEntity) {
        transactionDao.insertTransaction(transactionEntity)
    }

    suspend fun updateTransaction(transactionEntity: TransactionEntity) {
        transactionDao.updateTransaction(transactionEntity)
    }

    suspend fun deleteTransaction(transactionEntity: TransactionEntity) {
        transactionDao.deleteTransactio(transactionEntity)
    }

}