package kommand.syntax

class ExecutableSyntax<S: Syntax>(
	private val syntax: S,
	private val executor: SyntaxExecutor<S>
) {
	fun executes() {
		syntax.executor()
	}
}