package com.uznewmax.core.mapper

/**
 * Created by Alisher Kazakbaev on 12.06.2022.
 */
fun interface SingleMapper<T, R> {
    operator fun invoke(value: T): R
}