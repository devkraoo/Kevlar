package kommand.arguments.types

import kommand.arguments.Argument
import kommand.arguments.ArgumentDefinition

class BooleanArgument(override val config: Config) : ArgumentDefinition<Boolean>() {
	class Config : Argument.Config() {
		var greedy = false
	}

	override fun parse(token: String): Boolean =
		TODO()
}

fun boolean(init: BooleanArgument.Config.() -> Unit) =
	BooleanArgument((BooleanArgument.Config()).apply(init))