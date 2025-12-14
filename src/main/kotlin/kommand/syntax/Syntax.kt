package kommand.syntax

import kommand.arguments.Argument

abstract class Syntax {
	internal val arguments = mutableListOf<Argument<*>>()
}

fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>): ExecutableSyntax<S> =
	ExecutableSyntax(this, executor)