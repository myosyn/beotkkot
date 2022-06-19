package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.core.entity.User
import dev.shuuyu.Config.BOT_OWNER

suspend fun isBotDeveloper(user: User) {
    val user = env(BOT_OWNER)

}