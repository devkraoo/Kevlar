package kommand.parser

import kommand.Kommand
import kommand.syntax.parser.SyntaxAttempt
import kommand.syntax.parser.parse

fun Kommand.parse(tokens: List<String>): ParseAttempt {

	for (binding in bindings) {
		when (val attempt = binding.syntax.parse(tokens)) {
			is SyntaxAttempt.Valid -> return ParseAttempt.Valid(ParsedCommand(binding, attempt.context))
			is SyntaxAttempt.Invalid -> continue
		}
	}

	return ParseAttempt.Invalid("Invalid Arguments")
}