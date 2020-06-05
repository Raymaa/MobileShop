import Vue from 'vue'
import VueRouter from 'vue-router'

const Login = () => import('../components/Login.vue')
const Main = () => import('../components/Main.vue')
const RoleManagement = () => import('../components/admin/RoleManagement.vue')
const EmployeeManagement = () => import('../components/admin/EmployeeManagement.vue')
const GoodsProduct = () => import('../components/goods/GoodsProduct.vue')
const BrandCategroy = () => import('../components/product/BrandCategory.vue')
const StockGoods = () => import('../components/goods/StockGoods.vue')
const PaymentTypes = () => import('../components/product/PaymentTypes.vue')
const ShipCompany = () => import('../components/product/ShipCompany.vue')
const AllOrder = () => import('../components/order/AllOrder.vue')
const ReadyOrder = () => import('../components/order/ReadyOrder.vue')
const FinishOrder = () => import('../components/order/FinishOrder.vue')

Vue.use(VueRouter);

const routes = [
  {
    path: '',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/main',
    component: Main,
    children: [
      {
        path: '',
        redirect: '/main/goods-product'
      },
      {
        path: '/main/role-management',
        component: RoleManagement
      },
      {
        path: '/main/employee-management',
        component: EmployeeManagement
      },
      {
        path: '/main/goods-product',
        component: GoodsProduct
      },
      {
        path: '/main/brand-categroy',
        component: BrandCategroy
      },
      {
        path: '/main/stock-goods',
        component: StockGoods
      },
      {
        path: '/main/payment-types',
        component: PaymentTypes
      },
      {
        path: '/main/ship-company',
        component: ShipCompany
      },
      {
        path: '/main/all-order',
        component: AllOrder
      },
      {
        path: '/main/ready-order',
        component: ReadyOrder
      },
      {
        path: '/main/finish-order',
        component: FinishOrder
      }
    ]
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router;