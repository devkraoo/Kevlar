package kommand.builder

data class Kommand(
	val name: String,
	val description: String,
	val aliases: List<String>
)
