package kommand.arguments

import kommand.exceptions.KommandArgumentException
import kommand.syntax.Syntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class Argument<T>: ReadOnlyProperty<Syntax, T> {
	var default: T? = null

	override fun getValue(thisRef: Syntax, property: KProperty<*>): T =
		default ?: throw KommandArgumentException("Argument ${property.name} is missing!")

	abstract fun parse(token: String): T
}