package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.shuuyu.checks.inVoiceChannelCheck
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Play : Extension() {
    override val name: String = "play"

    override suspend fun setup() {
        publicHybridCommand(::PlayArguments) {
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