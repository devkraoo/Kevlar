package kommand.arguments

import kommand.KommandContext
import kommand.exceptions.KommandArgumentException
import kommand.syntax.Syntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegatedArgument<T>(val name: String): ReadOnlyProperty<Syntax, DelegatedArgument<T>> {
	fun with(context: KommandContext): T =
		context.get(name) ?:
		throw KommandArgumentException("Argument $name is missing!")

	override fun getValue(thisRef: Syntax, property: KProperty<*>) =
		this
}