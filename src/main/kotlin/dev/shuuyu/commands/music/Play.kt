package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Play : Extension() {
    override val name: String = "play"

    override suspend fun setup() {
        publicSlashCommand(::PlayArguments) {
            name = "play"
            description = "Plays the specified song."

            check {

            }

            action {
                val song = arguments.link
            }
        }
    }

    inner class PlayArguments : Arguments() {
        val link by string {
            name = "link"
            description = "The link that you want to play"
        }
        val songTitle by string {
            name = "songTitle"
            description = "The song's title"
        }
    }
}