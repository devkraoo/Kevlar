package kommand.arguments

import kommand.syntax.Syntax
import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

sealed interface Argument<T>: PropertyDelegateProvider<Syntax, ArgumentDelegate<T>> {
	override fun provideDelegate(thisRef: Syntax, property: KProperty<*>): ArgumentDelegate<T> {
		val argumentDelegate = ArgumentDelegate(property.name, this)
		thisRef.arguments.add(argumentDelegate)

		return argumentDelegate
	}

	val config: Config<T>

	abstract class Config<T> {
		var description: String? = null
		var optional: Boolean = false
		var default: T? = null
	}

	fun parse(token: String): T
}