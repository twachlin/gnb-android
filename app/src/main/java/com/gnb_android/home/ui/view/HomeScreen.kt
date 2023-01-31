package com.gnb_android.home.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnb_android.R
import com.gnb_android.commons.ui.view.components.header.GnbHeader

@Composable
fun HomeScreen() {
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
                LazyColumn {
                    // Todo: Add list of selectable items code
                }
            }
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}