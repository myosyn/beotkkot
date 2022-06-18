package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.extensions.Extension
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Skip : Extension() {
    override val name: String = "skip"

    override suspend fun setup() {
        publicHybridCommand {
            name = "skip"
            description = "Skips the specified amount of songs in the queue."

            check {

            }
        }
    }

    inner class SkipArguments : Arguments() {
        val skipAmount by defaultingInt {
            name = "skipAmount"
            description = "Skips the specified amount of songs."
            defaultValue = 1
        }
    }
}