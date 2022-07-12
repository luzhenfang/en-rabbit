package com.lu.en_rabbit.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lu.en_rabbit.common.WordCard
import com.lu.en_rabbit.ui.theme.util.MusicUtils
import java.util.stream.Collectors

@Composable
fun SinglePage() {
    val context = LocalContext.current
    val wordList = ArrayList<Pair<String, String>>()
    wordList.add(Pair("元音", "长元音"))
    wordList.add(Pair("元音", "短元音"))
    wordList.add(Pair("元音", "双元音"))

    Column {
        for (e in wordList) {
            WordCard(
                e,
                MusicUtils.getMusicListByName(
                    context.assets,
                    "${e.first}/${e.second}"
                ).stream().map { s -> s.replace(".mp3", "").replace("-", ":") }
                    .collect(Collectors.toList()),
            )
        }

    }

}