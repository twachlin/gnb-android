package com.gnb_android.home.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.home.data.datasource.transactions.TransactionsRemoteDataSource
import com.gnb_android.home.data.repository.transactions.TransactionsRepository
import com.gnb_android.home.ui.viewmodel.HomeViewModel
import com.gnb_android.ui.theme.GnbandroidTheme

class MainActivity : ComponentActivity() {

    val viewModel by lazy {
        HomeViewModel(
            CurrencyRepository(CurrencyRemoteDataSource()),
            TransactionsRepository(TransactionsRemoteDataSource())
        )
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
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}