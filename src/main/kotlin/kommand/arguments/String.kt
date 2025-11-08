package kommand.arguments

class StringArgument : Argument<String>() {

	override fun parse(token: String) =
		token

}

fun string(init: StringArgument.() -> Unit) =
	StringArgument().apply(init)