package dev.shuuyu

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.shuuyu.constants.Config.ENV
import dev.shuuyu.commands.Disconnect
import dev.shuuyu.commands.Help
import dev.shuuyu.commands.Ping

suspend fun main() {
    val bot = ExtensibleBot(env(ENV)) {
        applicationCommands { enabled = true }

        extensions {
            add(::Ping)
            add(::Help)
            add(::Disconnect)
        }

        presence {

        }
    }
    bot.start()
}
