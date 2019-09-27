package com.xingray.pageloader

/**
 * 加载流程
 *
 * @author : leixing
 * @date : 2019/9/27 16:00
 * @version : 1.0.0
 * mail : leixing@baidu.com
 *
 */
enum class LoadProcess {
    /**
     * 第一次加载
     */
    LOAD,

    /**
     * 刷新数据
     */
    REFRESH,

    /**
     * 加载更多
     */
    LOAD_MORE
}