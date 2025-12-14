package kommand.builder

import kommand.syntax.ExecutableSyntax

data class Kommand(
	val name: String,
	val description: String,
	val aliases: List<String>,
	val syntaxes: List<ExecutableSyntax<*>>
)