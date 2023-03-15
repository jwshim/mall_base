
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import DeliveryInfoManager from "./components/listers/DeliveryInfoCards"
import DeliveryInfoDetail from "./components/listers/DeliveryInfoDetail"

import ItemStorageManager from "./components/listers/ItemStorageCards"
import ItemStorageDetail from "./components/listers/ItemStorageDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/deliveryInfos',
                name: 'DeliveryInfoManager',
                component: DeliveryInfoManager
            },
            {
                path: '/deliveryInfos/:id',
                name: 'DeliveryInfoDetail',
                component: DeliveryInfoDetail
            },

            {
                path: '/itemStorages',
                name: 'ItemStorageManager',
                component: ItemStorageManager
            },
            {
                path: '/itemStorages/:id',
                name: 'ItemStorageDetail',
                component: ItemStorageDetail
            },





    ]
})
