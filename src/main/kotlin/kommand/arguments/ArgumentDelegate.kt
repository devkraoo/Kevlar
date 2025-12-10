package kommand.arguments

import kommand.KommandContext
import kommand.syntax.Syntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class ArgumentDelegate<T>(val name: String) : Argument<T>(), ReadOnlyProperty<Syntax, ArgumentDelegate<T>> {
	override fun getValue(thisRef: Syntax, property: KProperty<*>): ArgumentDelegate<T> =
		this

	context(context: KommandContext)
	val value: T
		get() = context.get(name)

	context(context: KommandContext)
	val v: T
		get() = value
}