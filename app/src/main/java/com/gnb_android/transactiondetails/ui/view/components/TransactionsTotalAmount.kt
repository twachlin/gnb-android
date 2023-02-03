package com.gnb_android.transactiondetails.ui.view.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gnb_android.R
import java.math.BigDecimal

@Composable
fun TransactionsTotalAmount(
    amount: BigDecimal,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) {
        Text(text = stringResource(id = R.string.transactions_total_amount_text))
        Text(text = stringResource(id = R.string.transaction_detail_item_amount, amount))
    }
}

@Preview
@Composable
fun TransactionsTotalAmountPreview() {
    TransactionsTotalAmount(amount = BigDecimal("43.50"))
}