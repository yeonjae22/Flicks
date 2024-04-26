package com.yeonberry.flicks.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

fun <T> safeFlow(execute: suspend () -> T): Flow<ApiResult<T>> = flow {
    try {
        val result = execute.invoke()
        emit(ApiResult.Success(result))
    } catch (exception: HttpException) {
        emit(ApiResult.Error(code = exception.code(), message = exception.message()))
    } catch (exception: Exception) {
        emit(ApiResult.Exception(exception = exception))
    }
}.flowOn(Dispatchers.IO)