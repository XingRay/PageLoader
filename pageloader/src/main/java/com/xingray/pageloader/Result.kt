package com.xingray.pageloader

/**
 * 结果
 *
 * @author : leixing
 * @date : 2019/9/27 15:54
 * @version : 1.0.0
 * mail : leixing@baidu.com
 *
 */
data class Result<T>(
    val isSuccess: Boolean,
    val data: T,
    val errorCode: Int,
    val errorMsg: String,
    val throwable: Throwable
)