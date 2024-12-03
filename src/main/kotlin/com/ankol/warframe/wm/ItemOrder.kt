package com.ankol.warframe.wm

data class ItemOrder(
    val orders: Collection<Order>,
) {
    data class Order(
        val creation_date: String?,
        val id: String?,
        val last_update: String?,
        /**
         * 订单类型
         */
        val order_type: String?,
        val platform: String?,
        /**
         * 价格
         */
        val platinum: Int,
        /**
         * 数量
         */
        val quantity: Int,
        val region: String?,
        val user: User?,
        val visible: Boolean?
    )

    data class User(
        /**
         * 用户在wm的id
         */
        val id: String,
        val avatar: String?,
        val ingame_name: String?,
        val last_seen: String?,
        val locale: String?,
        val region: String?,
        val reputation: Int?,
        /**
         * 用户在wm的状态
         */
        val status: String
    )
}

