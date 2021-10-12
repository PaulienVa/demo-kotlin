package com.openvalue.demo.utils

import org.junit.jupiter.api.Assertions

data class ListResult<T>(val list: List<T>) {
    infix fun hasSize(size: Int) {
        Assertions.assertTrue(list.size == 1)
    }

    infix fun contains(expected: T) {
        Assertions.assertTrue(list.contains(expected))
    }
}
