package kommand.syntax

import kommand.KommandContext

data class ExecutableSyntax<S: Syntax>(
	val scope: S,
	val executor: SyntaxExecutor<S>
) {
	fun execute(context: KommandContext) {
		with(context) { scope.executor() }
	}
}