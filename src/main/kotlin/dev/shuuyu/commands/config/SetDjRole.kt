package dev.shuuyu.commands.config

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class SetDjRole : Extension() {
    override val name: String = "setdjrole"

    override suspend fun setup() {
        publicHybridCommand(::SetDjRoleArguments) {
            name = "djrole"
            description = "Sets the DJ role"

            check {
                hasPermission(Permission.Administrator)
            }

            action {
                val role = arguments.targetRole


            }
        }
    }

    inner class SetDjRoleArguments : Arguments() {
        val targetRole by role {
            name = "targetRole"
            description = "The role you want to have the permissions of DJ"
        }
    }
}