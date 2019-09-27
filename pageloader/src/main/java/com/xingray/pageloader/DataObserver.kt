package com.xingray.pageloader

/**
 * 数据观察者
 *
 * @author : leixing
 * @date : 2019/9/27 15:44
 * @version : 1.0.0
 * mail : leixing@baidu.com
 *
 */
interface DataObserver<T> {
    fun onChanged(list: List<T>)

    fun onInsert(position: Int, list: List<T>)
}