package com.example.carloancal


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCal.setOnClickListener{
            calLoan()
        }
    }

    private fun calLoan(){

        val carPrice = editCarPrice.text.toString().toInt()
        val downPayment = editDownPayment.text.toString().toInt()
        val interestRate = editInterestRate.text.toString().toFloat()
        val loanPeriod = editLoanPeriod.text.toString().toInt()

        val carLoan = carPrice-downPayment
        val interest = carLoan*interestRate*loanPeriod
        val monthRepay = (carLoan+interest)/loanPeriod/12

        val intent = Intent(this, Result::class.java)
        intent.putExtra(CAR_LOAN, carLoan)
        intent.putExtra(INTEREST, interest)
        intent.putExtra(MONTHLY_PAYMENT, monthRepay)

        startActivity(intent)
    }

    companion object {
        const val CAR_LOAN = "loan"
        const val INTEREST = "interest"
        const val MONTHLY_PAYMENT = "payment"
    }

    fun clear(view : View){
        editCarPrice.setText("")
        editDownPayment.setText("")
        editInterestRate.setText("")
        editLoanPeriod.setText("")
    }
}


