package kommand.syntax

import kommand.KommandContext

typealias ArgumentExecutor<A> = context(KommandContext) A.() -> Unit