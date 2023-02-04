package com.gnb_android.transactiondetails.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gnb_android.R
import com.gnb_android.commons.ui.view.components.header.GnbHeader
import com.gnb_android.commons.ui.viewmodel.states.BusinessError
import com.gnb_android.commons.ui.viewmodel.states.Empty
import com.gnb_android.commons.ui.viewmodel.states.Loading
import com.gnb_android.commons.ui.viewmodel.states.Success
import com.gnb_android.home.data.repository.transactions.model.TransactionDetail
import com.gnb_android.transactiondetails.ui.view.components.TransactionDetailItem
import com.gnb_android.transactiondetails.ui.view.components.TransactionsTotalAmount
import com.gnb_android.transactiondetails.ui.viewmodel.TransactionDetailsViewModel

@Composable
fun TransactionDetailsScreen(
    viewModel: TransactionDetailsViewModel,
    transactionsList: List<TransactionDetail>
) {

    val currencyState = viewModel.currencyObservable.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GnbHeader(text = R.string.transaction_details_screen_header_text)

        when (val response = currencyState.value) {
            is Loading -> {
                CircularProgressIndicator()
            }
            is Success -> {
                val totalAmount =
                    viewModel.getTransactionsTotalAmount(response.body, transactionsList)

                TransactionsTotalAmount(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    amount = totalAmount
                )
            }
            is BusinessError, is Empty -> {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.transaction_details_screen_currency_error)
                )
            }
            null -> {
                // Do nothing
            }
        }

        TransactionDetailSuccessContent(
            modifier = Modifier.padding(16.dp),
            list = transactionsList
        )
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getCurrencyRates()
    }
}

@Composable
fun TransactionDetailSuccessContent(
    list: List<TransactionDetail>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(list) { index, item ->
            TransactionDetailItem(
                code = item.sku,
                amount = item.amount.toString(),
                currency = item.currency,
                isLastItem = index == list.size - 1
            )
        }
    }
}