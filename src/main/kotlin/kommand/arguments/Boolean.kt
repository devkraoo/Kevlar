package kommand.arguments

class BooleanArgument : Argument<Boolean>() {

	override fun parse(token: String) =
		token.toBooleanStrict()

}

fun boolean(init: BooleanArgument.() -> Unit) =
	BooleanArgument().apply(init)