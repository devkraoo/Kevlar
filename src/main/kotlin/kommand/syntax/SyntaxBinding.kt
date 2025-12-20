package kommand.syntax

import kommand.arguments.Arguments

data class SyntaxBinding<A: Arguments>(
	val syntax: Syntax<A>,
	val executor: ArgumentExecutor<A>
)