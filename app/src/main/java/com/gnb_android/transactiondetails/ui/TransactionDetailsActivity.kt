package com.gnb_android.transactiondetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.home.data.repository.transactions.model.TransactionDetail
import com.gnb_android.transactiondetails.ui.view.TransactionDetailsScreen
import com.gnb_android.transactiondetails.ui.viewmodel.TransactionDetailsViewModel
import com.gnb_android.ui.theme.GnbandroidTheme

class TransactionDetailsActivity : ComponentActivity() {

    companion object {
        private const val TRANSACTIONS = "TRANSACTIONS"

        fun getIntent(
            context: Context,
            transactions: List<TransactionDetail>
        ): Intent = Intent(context, TransactionDetailsActivity::class.java).apply {
            putExtra(TRANSACTIONS, transactions as java.io.Serializable)
        }
    }

    private val viewModel by lazy {
        TransactionDetailsViewModel(CurrencyRepository(CurrencyRemoteDataSource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GnbandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TransactionDetailsScreen(
                        viewModel = viewModel,
                        transactionsList = this.intent.getSerializableExtra(TRANSACTIONS) as List<TransactionDetail>
                    )
                }
            }
        }
    }
}