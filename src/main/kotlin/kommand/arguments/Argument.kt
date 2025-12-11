package kommand.arguments

import kommand.syntax.Syntax
import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

sealed interface Argument<T>: PropertyDelegateProvider<Syntax, ArgumentDelegate<T>> {
	override fun provideDelegate(thisRef: Syntax, property: KProperty<*>): ArgumentDelegate<T> =
		ArgumentDelegate(property.name, this)

	val config: Config

	abstract class Config {
		var description: String? = null
	}

	fun parse(token: String): T
}