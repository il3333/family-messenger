package com.megachat.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.megachat.app.data.MockData
import com.megachat.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    chatId: String,
    chatName: String,
    onBack: () -> Unit
) {
    val messages = remember { MockData.familyMessages }
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        chatName,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Peach
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Cream)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(messages) { message ->
                    val isMine = message.authorId == "1"
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),
                        horizontalAlignment = if (isMine) Alignment.End else Alignment.Start
                    ) {
                        if (!isMine) {
                            Text(
                                message.authorName,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Medium,
                                color = Color(message.avatarColor),
                                modifier = Modifier.padding(start = 8.dp, bottom = 2.dp)
                            )
                        }
                        Surface(
                            shape = RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = if (isMine) 16.dp else 4.dp,
                                bottomEnd = if (isMine) 4.dp else 16.dp
                            ),
                            color = if (isMine) PeachVibrant else White,
                            shadowElevation = 1.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(
                                    horizontal = 14.dp,
                                    vertical = 8.dp
                                )
                            ) {
                                Text(
                                    message.text,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = TextPrimary
                                )
                                Text(
                                    message.time,
                                    style = MaterialTheme.typography.labelSmall,
                                    modifier = Modifier.align(Alignment.End)
                                )
                            }
                        }
                    }
                }
            }

            // Поле ввода сообщения
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = White,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
                        placeholder = { Text("Написать сообщение...") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(24.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PeachVibrant,
                            unfocusedBorderColor = WarmGrayLight
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    FilledIconButton(
                        onClick = { },
                        shape = CircleShape,
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = PeachVibrant
                        )
                    ) {
                        Text("➤", fontSize = 18.sp)
                    }
                }
            }
        }
    }
}
