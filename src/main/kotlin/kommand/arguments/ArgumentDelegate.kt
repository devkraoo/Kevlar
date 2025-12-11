package kommand.arguments

import kommand.KommandContext
import kommand.syntax.Syntax
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ArgumentDelegate<T>(val name: String, impl: Argument<T>) : Argument<T> by impl, ReadOnlyProperty<Syntax, ArgumentDelegate<T>> {
	override fun getValue(thisRef: Syntax, property: KProperty<*>): ArgumentDelegate<T> =
		this

	context(context: KommandContext)
	val value: T
		get() = context.get(name)

	context(context: KommandContext)
	val v: T
		get() = value
}