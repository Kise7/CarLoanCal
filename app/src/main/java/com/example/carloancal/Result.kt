package com.example.carloancal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val loan = intent.getIntExtra(MainActivity.CAR_LOAN, 0)
        val interest = intent.getFloatExtra(MainActivity.INTEREST, 0F)
        val monthPay = intent.getFloatExtra(MainActivity.MONTHLY_PAYMENT, 0F)

        textCarLoan.text = getString(R.string.CarLoan)+" ${loan}"
        textInterest.text = getString(R.string.Interest)+" ${interest}"
        textMonthlyPayment.text = getString(R.string.MonthlyRepayment)+" ${monthPay}"
    }

    public fun closeActivity(view : View){
        textCarLoan.setText("")
        textInterest.setText("")
        textMonthlyPayment.setText("")

        finish()
    }
}
