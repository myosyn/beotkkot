package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.extensions.Extension
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Play : Extension() {
    override val name: String = "play"

    override suspend fun setup() {
        publicHybridCommand(::PlayArguments) {
            name = "play"
            description = "Plays the specified song."

            check {

            }
        }
    }

    inner class PlayArguments : Arguments() {

    }
}