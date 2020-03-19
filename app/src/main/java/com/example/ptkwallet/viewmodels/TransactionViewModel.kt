package com.example.ptkwallet.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ptkwallet.database.TransactionDatabase
import com.example.ptkwallet.entities.TransactionEntity
import com.example.ptkwallet.repositories.TransactionRepo
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    val transactionDao= TransactionDatabase.getTransactionDB(application)!!.transactiondao()
    val repository=TransactionRepo(transactionDao)
    val transactionlivedata=repository.transitionlivedata

    fun insertTransaction(transactionEntity: TransactionEntity)= viewModelScope.launch {
            repository.insertTransaction(transactionEntity)
        }
    fun updateTransaction(transactionEntity: TransactionEntity)=viewModelScope.launch {
        repository.updateTransaction(transactionEntity)
    }
    fun deleteTransaction(transactionEntity: TransactionEntity)=viewModelScope.launch {
        repository.deleteTransaction(transactionEntity)
    }



}