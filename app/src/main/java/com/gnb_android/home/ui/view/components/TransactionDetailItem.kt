package com.gnb_android.home.ui.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnb_android.R
import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import com.gnb_android.commons.ui.view.components.divider.GnbDivider

@Composable
fun TransactionDetailItem(
    code: String,
    amount: String,
    currency: CurrencyType,
    isLastItem: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(0.2f),
                text = stringResource(id = R.string.transaction_detail_item_title)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(0.4f),
                text = code
            )
            Text(
                modifier = Modifier
                    .weight(0.3f)
                    .padding(end = 4.dp),
                textAlign = TextAlign.End,
                text = stringResource(id = R.string.transaction_detail_item_amount, amount)
            )
            Text(
                modifier = Modifier.weight(0.1f),
                text = currency.name
            )
        }
        if (!isLastItem) {
            GnbDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionDetailItemPreview() {
    TransactionDetailItem(
        code = "T2006",
        amount = "34.57",
        currency = CurrencyType.USD
    )
}