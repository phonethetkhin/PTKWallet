package com.example.ptkwallet.ui

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.ptkwallet.R
import com.example.ptkwallet.entities.TransactionEntity
import com.example.ptkwallet.viewmodels.TransactionViewModel
import kotlinx.android.synthetic.main.activity_add_transaction.*
import java.text.SimpleDateFormat
import java.util.*


class AddTransactionActivity : AppCompatActivity() {
    lateinit var method: String
    lateinit var type: String
     var selectedDates=("..-..-....")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)
        when (spnTransactionMethod.selectedItem) {
            "Cash" -> method = "Cash"
            "Card" -> method = "Card"
        }
        type = if (rdoExpense.isChecked) {
            "Expense"
        } else {
            "Income"
        }
        imbDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val mYear = calendar[Calendar.YEAR]
            val mMonth = calendar[Calendar.MONTH]
            val mDay = calendar[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                this,
                OnDateSetListener { v, year, monthOfYear, dayOfMonth ->
                    val simpledateformat =
                        SimpleDateFormat("EEEE")
                    val sf = SimpleDateFormat("MMMM")


                    val selectedDate = simpledateformat.format(dayOfMonth)
                    selectedDates = (selectedDate + "-" +
                            dayOfMonth.toString() + "-" + sf.format(monthOfYear) + "-" + year
                            )

                    txtDate.setText(selectedDates)
                }, mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }
        btnAdd.setOnClickListener {
            if (!(tetTransactionAmount.text!!.isEmpty() && tetTransactionCategory.text!!.isEmpty() && tetTransactionNotes.text!!.isEmpty())) {
                val transactionEntity = TransactionEntity(
                    0,
                    method,
                    type,
                    tetTransactionCategory.text.toString(),
                    tetTransactionAmount.text.toString().toDouble(),
                    tetTransactionNotes.text.toString(),
                    selectedDates
                )
                val vmodel = ViewModelProviders.of(this).get(TransactionViewModel::class.java)
                vmodel.insertTransaction(transactionEntity)

                 Toast.makeText(this,"Save Successful",Toast.LENGTH_LONG).show()
                finish()


            } else {
                Toast.makeText(this, "Please Fill All Information", Toast.LENGTH_LONG).show()
            }
        }
    }


}
