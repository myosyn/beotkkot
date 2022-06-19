package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import com.kotlindiscord.kord.extensions.checks.userFor
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.core.entity.User
import dev.kord.core.event.Event
import dev.shuuyu.Config.BOT_OWNER

suspend fun <T : Event> CheckContext<T>.VerifyBotDeveloper(user: User) {
    if (!passed) {
        return
    }

    val member = userFor(event)
}