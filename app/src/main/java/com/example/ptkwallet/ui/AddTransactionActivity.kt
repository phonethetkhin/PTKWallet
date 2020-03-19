package com.example.ptkwallet.ui

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ptkwallet.R
import kotlinx.android.synthetic.main.activity_add_transaction.*
import java.text.SimpleDateFormat
import java.util.*


class AddTransactionActivity : AppCompatActivity() {
lateinit var method:String
    lateinit var type:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)
       when(spnTransactionMethod.selectedItem) {
           "Cash" -> method = "Cash"
           "Card" -> method = "Card"
       }
        type = if(rdoExpense.isChecked) {
            "Expense"
        } else{
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
                    val sf = SimpleDateFormat("MMM")


                    val selectedDate = simpledateformat.format(Calendar.DAY_OF_WEEK)

                    txtDate.setText(selectedDate+"-"+
                        dayOfMonth.toString() + "-" + sf.format(monthOfYear) + "-" + year
                    )
                }, mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }


        }


}
