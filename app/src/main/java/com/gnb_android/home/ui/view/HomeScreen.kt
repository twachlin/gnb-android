package com.gnb_android.home.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnb_android.R
import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.commons.ui.view.components.header.GnbHeader
import com.gnb_android.commons.ui.viewmodel.states.BusinessError
import com.gnb_android.commons.ui.viewmodel.states.Empty
import com.gnb_android.commons.ui.viewmodel.states.Loading
import com.gnb_android.commons.ui.viewmodel.states.Success
import com.gnb_android.home.data.datasource.transactions.TransactionsRemoteDataSource
import com.gnb_android.home.data.repository.transactions.TransactionsRepository
import com.gnb_android.home.data.repository.transactions.model.TransactionsBySku
import com.gnb_android.home.ui.view.components.TransactionTitleItem
import com.gnb_android.home.ui.viewmodel.HomeViewModel
import com.gnb_android.transactiondetails.ui.TransactionDetailsActivity

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {

    val transactionsState = viewModel.transactionsObservable.observeAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            GnbHeader(text = R.string.home_header_text)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.home_screen_content_subtitle))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (val state = transactionsState.value) {
                        is Loading -> {
                            CircularProgressIndicator(modifier = Modifier.padding(32.dp))
                        }
                        Empty -> {
                            Text(text = "Empty content")
                        }
                        is Success -> {
                            val transactionsBySku: List<TransactionsBySku> = state.body
                            LazyColumn {
                                itemsIndexed(transactionsBySku) { index, item ->
                                    TransactionTitleItem(
                                        text = item.sku,
                                        onClick = {
                                            context.startActivity(
                                                TransactionDetailsActivity.getIntent(
                                                    context, item.transactionDetail
                                                )
                                            )
                                        },
                                        isLastItem = (index == transactionsBySku.size - 1)
                                    )
                                }
                            }
                        }
                        BusinessError -> {
                            Text(text = "Business error content")
                        }
                        null -> {
                            // Do nothing
                        }
                    }
                }
            }
        }
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.getTransactions()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        HomeViewModel(
            CurrencyRepository(CurrencyRemoteDataSource()),
            TransactionsRepository(TransactionsRemoteDataSource())
        )
    )
}