package com.ankol.warframe.wm.api

import cn.hutool.http.HttpResponse
import cn.hutool.http.HttpUtil
import com.ankol.warframe.tools.JacksonUtil
import com.ankol.warframe.tools.logger
import com.ankol.warframe.wm.ItemOrder
import com.ankol.warframe.wm.entity.WmResWrapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

object WmApi {
    private const val WARFRAME_MARKET_API = "https://api.warframe.market/v1"

    private val log = logger()

    /**
     * 获取道具订单信息
     * @param urlName 物品url名称
     */
    @Throws(RuntimeException::class)
    fun getItemOrders(urlName: String): WmResWrapper<ItemOrder> {
        val response = doGet("$WARFRAME_MARKET_API/items/$urlName/orders")
        if (response.isOk) {
            return JacksonUtil.fromJson(response.body(), jacksonTypeRef<WmResWrapper<ItemOrder>>())
        }
        throw RuntimeException("Can't get item orders")
    }

    private fun doGet(url: String): HttpResponse {
        return HttpUtil.createGet(url)
            .setFollowRedirects(true)
            .setFollowRedirectsCookie(true)
            .executeAsync()
    }
}