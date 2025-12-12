package kommand

import kommand.builder.Kommand
import kommand.exceptions.UnknownKommand

class KommandManager {
	private val kommands = HashMap<String, Kommand>()

	fun register(kommand: Kommand) {
		kommands[kommand.name] = kommand

		kommand.aliases.forEach {
			kommands[it] = kommand
		}

	}

	fun find(name: String): Kommand =
		kommands[name] ?: throw UnknownKommand("Command '$name' not found")

	fun execute(input: String) {
		val kommand = CommandParser.parse(input)
		kommand.execute()
	}

}