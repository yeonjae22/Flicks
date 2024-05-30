package com.yeonberry.common.result

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

sealed interface ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>
    data class Error(val exception: Throwable) : ApiResult<Nothing>
}

fun <T> safeFlow(execute: suspend () -> T): Flow<ApiResult<T>> = flow {
    try {
        val result = execute.invoke()
        emit(ApiResult.Success(result))
    } catch (exception: Exception) {
        emit(ApiResult.Error(exception = exception))
    }
}.flowOn(Dispatchers.IO)