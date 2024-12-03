package com.ankol.warframe.wm.api

import cn.hutool.http.HttpUtil
import com.ankol.warframe.tools.JacksonUtil
import com.ankol.warframe.wm.ItemOrder
import com.ankol.warframe.wm.WmResWrapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

object WmApi {
    private const val WARFRAME_MARKET_API = "https://api.warframe.market/v1"

    /**
     * 获取道具订单信息
     */
    fun getItemOrders(urlName: String) {
        val resJson = HttpUtil.createGet("$WARFRAME_MARKET_API/items/$urlName/orders")
            .setFollowRedirectsCookie(true)
            .setFollowRedirects(true)
            .execute()
            .body()
        val wrapper = JacksonUtil.fromJson(resJson, jacksonTypeRef<WmResWrapper<ItemOrder>>())
        println("WARFRAME_MARKET_API = $wrapper")
    }
}

fun main() {
    WmApi.getItemOrders("mirage_prime_systems")
}