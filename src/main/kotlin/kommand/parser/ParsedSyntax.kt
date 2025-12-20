package kommand.parser

import kommand.KommandContext
import kommand.arguments.Arguments
import kommand.syntax.SyntaxBinding

class ParsedSyntax<A: Arguments>(
	private val binding: SyntaxBinding<A>,
	private val context: KommandContext,
) {
	fun execute() {
		val (syntax, executor) = binding
		syntax.execute(executor, context)
	}
}