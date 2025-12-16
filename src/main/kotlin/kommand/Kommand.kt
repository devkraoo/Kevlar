package kommand

import kommand.syntax.SyntaxBinding

data class Kommand(
	val name: String,
	val description: String,
	val aliases: List<String>,
	val bindings: List<SyntaxBinding<*>>
)