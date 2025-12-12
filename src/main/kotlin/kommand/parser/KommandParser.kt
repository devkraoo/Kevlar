package kommand.parser

import kommand.KommandManager
import kommand.syntax.ExecutableSyntax

object KommandParser {

	fun parse(input: String): ExecutableSyntax<*> {
		val tokens = tokenize(input)

		val kommand = KommandManager.find(tokens[0].removePrefix("/"))
		val args = tokens.drop(1)

		return kommand.parse(args)
	}

	private fun tokenize(input: String): List<String> {
		return input.trim().split(Regex("\\s+"))
	}

}