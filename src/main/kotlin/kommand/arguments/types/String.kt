package kommand.arguments.types

import kommand.arguments.Argument
import kommand.arguments.ArgumentDefinition

class StringArgument(override val config: Config) : ArgumentDefinition<String>() {
	class Config : Argument.Config() {
		var greedy = false
	}

	override fun parse(token: String): String =
		TODO()
}

fun string(init: StringArgument.Config.() -> Unit) =
	StringArgument((StringArgument.Config()).apply(init))