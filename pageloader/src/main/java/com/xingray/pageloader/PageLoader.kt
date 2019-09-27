package com.xingray.pageloader

/**
 * 分页加载器
 *
 * @author : leixing
 * @date : 2019/9/27 15:29
 * @version : 1.0.0
 * mail : leixing@baidu.com
 *
 */
class PageLoader<T>(
    private val startPageIndex: Int,
    private val pageSize: Int,
    private val dataSource: DataSource<T>
) {

    val list: MutableList<T> by lazy { mutableListOf<T>() }
    val observers: MutableList<DataObserver<T>> by lazy { mutableListOf<DataObserver<T>>() }

    private var pageIndex = startPageIndex

    fun load() {
        pageIndex = startPageIndex
        list.clear()
        notifyListChanged(list)
        onLoadStart(LoadProcess.LOAD)
        val result = dataSource.load(pageIndex, pageSize)
        onLoadFinish(LoadProcess.LOAD)
        if (!result.isSuccess) {
            onLoadFailed(LoadProcess.LOAD)
            return
        }
        pageIndex++
        val data = result.data
        list.addAll(data)
        notifyListInsert(0, data)
    }

    fun refresh() {
        val index = startPageIndex
        onLoadStart(LoadProcess.REFRESH)
        val result = dataSource.load(index, pageSize)
        onLoadFinish(LoadProcess.REFRESH)
        if (!result.isSuccess) {
            onLoadFailed(LoadProcess.REFRESH)
            return
        }
        pageIndex = index + 1
        val data = result.data
        list.clear()
        list.addAll(data)
        notifyListChanged(list)
    }

    fun loadMore() {
        onLoadStart(LoadProcess.LOAD_MORE)
        val result = dataSource.load(pageIndex, pageSize)
        onLoadFinish(LoadProcess.LOAD_MORE)
        if(!result.isSuccess){
            onLoadFailed(LoadProcess.LOAD_MORE)
            return
        }
        pageIndex++
        val data = result.data
        val position = list.size
        list.addAll(data)
        notifyListInsert(position, data)
    }

    private fun notifyListChanged(list: List<T>) {

    }

    private fun notifyListInsert(position: Int, list: List<T>) {

    }

    private fun onLoadStart(process: LoadProcess) {

    }

    private fun onLoadFinish(process: LoadProcess) {

    }

    private fun onLoadFailed(process: LoadProcess) {

    }
}