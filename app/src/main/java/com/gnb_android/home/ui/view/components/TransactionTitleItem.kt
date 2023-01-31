package com.gnb_android.home.ui.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnb_android.commons.ui.view.components.divider.GnbDivider

@Composable
fun TransactionTitleItem(
    text: String,
    onClick: () -> Unit,
    isLastItem: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.height(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = text
            )
        }
        if (!isLastItem) {
            GnbDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionTitleItemPreview() {
    TransactionTitleItem(text = "T2006", onClick = {})
}