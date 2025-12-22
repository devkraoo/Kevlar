package kommand.syntax.parser

import kommand.KommandContext

sealed interface SyntaxAttempt {
	data class Valid(
		val context: KommandContext
	) : SyntaxAttempt

	data class Invalid(
		val reason: String
	) : SyntaxAttempt
}