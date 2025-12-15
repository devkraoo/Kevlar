package kommand.parser

import kommand.KommandContext
import kommand.syntax.SyntaxBinding

class ParsedKommand(
	private val syntax: SyntaxBinding<*>,
	private val context: KommandContext
) {
	fun execute() {
		syntax.execute(context)
	}
}