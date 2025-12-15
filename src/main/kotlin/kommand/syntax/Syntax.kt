package kommand.syntax

import kommand.arguments.ArgumentDelegate
import kommand.KommandDSLElement

abstract class Syntax : KommandDSLElement {
	internal val arguments = mutableListOf<ArgumentDelegate<*>>()
}