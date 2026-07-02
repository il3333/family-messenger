package com.megachat.app.data

data class FamilyMember(
    val id: String,
    val name: String,
    val avatarColor: Long,
    val isOnline: Boolean
)

data class Message(
    val id: String,
    val authorId: String,
    val authorName: String,
    val text: String,
    val time: String,
    val avatarColor: Long
)

data class Chat(
    val id: String,
    val name: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val unreadCount: Int,
    val isGroup: Boolean,
    val avatarColor: Long
)

object MockData {
    val familyMembers = listOf(
        FamilyMember("1", "Папа", 0xFFFFCC80, true),
        FamilyMember("2", "Мама", 0xFFE1BEE7, true),
        FamilyMember("3", "Саша", 0xFFC8E6C9, true),
        FamilyMember("4", "Аня", 0xFFFFF9C4, false),
        FamilyMember("5", "Бабушка", 0xFFF8BBD0, false)
    )

    val chats = listOf(
        Chat("family", "Общий чат", "Мама: Как дела?", "14:30", 3, true, 0xFFFFCC80),
        Chat("dm_1", "Мама", "Спокойной ночи!", "Вчера", 1, false, 0xFFE1BEE7),
        Chat("dm_2", "Саша", "Скинь уроки", "Вчера", 0, false, 0xFFC8E6C9),
        Chat("dm_3", "Аня", "Я на танцах 🩰", "Пн", 2, false, 0xFFFFF9C4)
    )

    val familyMessages = listOf(
        Message("m1", "1", "Папа", "Привет всем! Как прошёл день?", "14:00", 0xFFFFCC80),
        Message("m2", "2", "Мама", "Отлично! Гуляли в парке 🌳", "14:05", 0xFFE1BEE7),
        Message("m3", "3", "Саша", "У меня пятёрка по математике! 🎉", "14:10", 0xFFC8E6C9),
        Message("m4", "1", "Папа", "Молодец, Саша! Горжусь тобой 👏", "14:15", 0xFFFFCC80),
        Message("m5", "4", "Аня", "А у меня концерт в субботу!", "14:20", 0xFFFFF9C4),
        Message("m6", "2", "Мама", "Обязательно придём! Во сколько?", "14:25", 0xFFE1BEE7),
        Message("m7", "4", "Аня", "В 16:00 в ДК 🩰", "14:28", 0xFFFFF9C4),
        Message("m8", "2", "Мама", "Как дела?", "14:30", 0xFFE1BEE7)
    )
}
