package kommand.parser

import kommand.manager.KommandManager

object KommandParser {

	fun parse(input: String): ParseAttempt {
		val tokens = input.trim().split(Regex("\\s+"))

		val kommand = KommandManager.find(tokens[0].removePrefix("/"))
		return kommand.parse(tokens.drop(1))
	}

}