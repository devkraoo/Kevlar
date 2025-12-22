package kommand.parser

import kommand.syntax.parser.ParsedSyntax

sealed interface SyntaxAttempt {
	data class Valid(
		val parsed: ParsedSyntax<*>
	) : SyntaxAttempt

	data class Invalid(
		val reason: String
	) : SyntaxAttempt
}