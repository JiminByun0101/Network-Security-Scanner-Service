
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ScanRequestManager from "./components/listers/ScanRequestCards"
import ScanRequestDetail from "./components/listers/ScanRequestDetail"

import OpenSourceIntegrationManager from "./components/listers/OpenSourceIntegrationCards"
import OpenSourceIntegrationDetail from "./components/listers/OpenSourceIntegrationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/scanRequests',
                name: 'ScanRequestManager',
                component: ScanRequestManager
            },
            {
                path: '/scanRequests/:id',
                name: 'ScanRequestDetail',
                component: ScanRequestDetail
            },

            {
                path: '/openSourceIntegrations',
                name: 'OpenSourceIntegrationManager',
                component: OpenSourceIntegrationManager
            },
            {
                path: '/openSourceIntegrations/:id',
                name: 'OpenSourceIntegrationDetail',
                component: OpenSourceIntegrationDetail
            },



    ]
})
