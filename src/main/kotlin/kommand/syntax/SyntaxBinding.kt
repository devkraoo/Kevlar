package kommand.syntax

import kommand.KommandContext
import kommand.arguments.Arguments

data class SyntaxBinding<A: Arguments>(
	val syntax: Syntax<A>,
	val executor: ArgumentExecutor<A>
) {
	fun execute(context: KommandContext) {
		syntax.execute(executor, context)
	}
}