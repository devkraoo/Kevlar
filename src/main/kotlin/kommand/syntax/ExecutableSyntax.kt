package kommand.syntax

import kommand.KommandContext

class ExecutableSyntax<S: Syntax>(
	private val syntax: S,
	private val executor: SyntaxExecutor<S>
) {
	fun executes(context: KommandContext) {
		with(context) { syntax.executor() }
	}
}