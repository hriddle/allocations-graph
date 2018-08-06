package com.example.allocations

import java.util.Optional

const val UNKNOWN = "UNKNOWN"

fun <T> Optional<T>.toNullable(): T? = this.orElse(null)