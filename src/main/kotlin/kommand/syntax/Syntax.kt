package kommand.syntax

import kommand.arguments.ArgumentDelegate

abstract class Syntax {
	internal val arguments = mutableListOf<ArgumentDelegate<*>>()
}

fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>): ExecutableSyntax<S> =
	ExecutableSyntax(this, executor)