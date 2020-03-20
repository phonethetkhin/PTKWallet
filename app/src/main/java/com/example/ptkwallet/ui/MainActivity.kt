package com.example.ptkwallet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptkwallet.R
import com.example.ptkwallet.adapters.TransactionAdapter
import com.example.ptkwallet.viewmodels.TransactionViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var vmodel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabAdd.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
        rcvMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcvMain.setHasFixedSize(true)
        val vmodel = ViewModelProviders.of(this).get(TransactionViewModel::class.java)

        vmodel.transactionlivedata.observe(this, Observer {
            it?.let {
                rcvMain.adapter = TransactionAdapter(it)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mitemClear -> {
                val vmodel = ViewModelProviders.of(this).get(TransactionViewModel::class.java)

                vmodel.deleteAllTransaction()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}
