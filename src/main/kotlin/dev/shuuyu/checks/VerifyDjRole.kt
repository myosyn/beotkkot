package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.checks.guildFor
import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import dev.kord.core.event.Event

suspend fun <T : Event> CheckContext<T>.VerifyDjRole(extensibleBot: ExtensibleBot) {
    if (!passed) {
        return
    }

    val guild = guildFor(event)
}