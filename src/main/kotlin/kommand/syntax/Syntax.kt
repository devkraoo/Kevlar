package kommand.syntax

abstract class Syntax

fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>): ExecutableSyntax<S> =
	ExecutableSyntax(this, executor)