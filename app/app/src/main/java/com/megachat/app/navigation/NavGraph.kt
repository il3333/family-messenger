package com.megachat.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.megachat.app.ui.screens.ChatScreen
import com.megachat.app.ui.screens.MainScreen
import com.megachat.app.ui.screens.ProfileScreen

object Routes {
    const val MAIN = "main"
    const val CHAT = "chat/{chatId}/{chatName}"
    const val PROFILE = "profile/{memberId}"

    fun chat(chatId: String, chatName: String) = "chat/$chatId/$chatName"
    fun profile(memberId: String) = "profile/$memberId"
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MAIN) {
        composable(Routes.MAIN) {
            MainScreen(
                onChatClick = { chatId, chatName ->
                    navController.navigate(Routes.chat(chatId, chatName))
                },
                onProfileClick = { memberId ->
                    navController.navigate(Routes.profile(memberId))
                }
            )
        }

        composable(
            route = Routes.CHAT,
            arguments = listOf(
                navArgument("chatId") { type = NavType.StringType },
                navArgument("chatName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            val chatName = backStackEntry.arguments?.getString("chatName") ?: ""
            ChatScreen(
                chatId = chatId,
                chatName = chatName,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.PROFILE,
            arguments = listOf(
                navArgument("memberId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val memberId = backStackEntry.arguments?.getString("memberId") ?: ""
            ProfileScreen(
                memberId = memberId,
                onBack = { navController.popBackStack() },
                onSendMessage = { chatId, chatName ->
                    navController.navigate(Routes.chat(chatId, chatName))
                }
            )
        }
    }
}
