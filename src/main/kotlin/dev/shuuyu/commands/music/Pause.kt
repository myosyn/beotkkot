package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Pause : Extension() {
    override val name: String = "pause"

    override suspend fun setup() {
        publicSlashCommand {
            name = "pause"
            description = "Pauses the song that is playing"

            check {
                anyGuild()
            }

            action {
                
            }
        }
    }
}