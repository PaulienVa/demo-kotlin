package com.openvalue.demo.utils


fun <R> given(block: (TestData) -> R): R {
    return block(TestData())
}

inline fun <T,  R> T.`when`(block: T.() -> List<R>) : ListResult<R> {
    return ListResult(block(this))
}

inline fun <T, R> T.then(block: T.() -> R) : R {
    return block(this)
}
