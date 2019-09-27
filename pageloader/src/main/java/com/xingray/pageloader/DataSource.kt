package com.xingray.pageloader

/**
 * 数据源
 *
 * @author : leixing
 * @date : 2019/9/27 15:33
 * @version : 1.0.0
 * mail : leixing@baidu.com
 *
 */
interface DataSource<T> {
    /**
     * 分页加载数据
     * @param pageIndex 页码
     * @param pageSize 页大小
     */
    fun load(pageIndex: Int, pageSize: Int): Result<List<T>>
}