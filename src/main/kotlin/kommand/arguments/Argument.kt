package kommand.arguments

import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

sealed interface Argument<T>: PropertyDelegateProvider<Arguments, ArgumentDelegate<T>> {
	override fun provideDelegate(thisRef: Arguments, property: KProperty<*>): ArgumentDelegate<T> {
		val argumentDelegate = ArgumentDelegate(property.name, this)
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