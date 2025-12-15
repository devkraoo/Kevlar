package kommand.syntax

import kommand.arguments.ArgumentDelegate
import kommand.dsl.KommandDSLElement

abstract class Syntax : KommandDSLElement {
	internal val arguments = mutableListOf<ArgumentDelegate<*>>()
}

fun <S: Syntax> S.executes(executor: SyntaxExecutor<S>): ExecutableSyntax<S> =
	ExecutableSyntax(this, executor)