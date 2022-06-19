package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class PrecenseEdit : Extension() {
    override val name: String = "precenseedit"

    override suspend fun setup() {
        publicHybridCommand(::PresenceEditArguments) {
            name = "presence"
            description = "Changes the bot's presence"

            check {

            }
        }
    }

    inner class PresenceEditArguments : Arguments() {
        val presence by string {
            name = "presense"
            description = "The thing you want the presence to say"
        }
    }
}