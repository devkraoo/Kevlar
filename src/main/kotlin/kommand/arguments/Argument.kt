package kommand.arguments

import kommand.syntax.Syntax
import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

sealed class Argument<T>: PropertyDelegateProvider<Syntax, ArgumentDelegate<T>> {
	override fun provideDelegate(thisRef: Syntax, property: KProperty<*>): ArgumentDelegate<T> =
		object : ArgumentDelegate<T>(property.name) {
			override val config = this@Argument.config
			override fun parse(token: String): T = this@Argument.parse(token)
		}

	abstract val config: Config

	abstract class Config {
		var description: String? = null
	}

	abstract fun parse(token: String): T
}