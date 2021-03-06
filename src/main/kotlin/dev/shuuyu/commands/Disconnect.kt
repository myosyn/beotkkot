package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Disconnect : Extension() {
    override val name: String = "Disconnect"

    override suspend fun setup() {
        publicSlashCommand {
            name = "disconnect"
            description = "Disconnects the bot from the voice channel"

            check {
                anyGuild()
            }

            action {
                val targetVoiceChannel = member
            }
        }
    }
}