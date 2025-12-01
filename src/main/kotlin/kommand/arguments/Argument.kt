package kommand.arguments

import kommand.syntax.Syntax
import kotlin.reflect.KProperty

abstract class Argument<T> {
	var default: T? = null

	operator fun provideDelegate(thisRef: Syntax, property: KProperty<*>) =
		DelegatedArgument<T>(property.name)

	abstract fun parse(token: String): T
}
