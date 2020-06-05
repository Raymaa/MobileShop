<template>
  <div class="layout">
    <Layout>
      <Header>
        <Menu mode="horizontal" theme="dark" active-name="1">
          <div class="layout-logo"></div>
          <div class="layout-nav">
            <MenuItem name="1">
              <Icon type="md-hand"></Icon>
              欢迎你，{{userName}}
            </MenuItem>
            <MenuItem name="2">
              <Icon type="md-contact"></Icon>个人中心
            </MenuItem>
            <MenuItem name="3">
              <Icon type="md-exit"></Icon>
              <router-link to="/login">退出</router-link>
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <Layout>
        <Sider hide-trigger :style="{background: '#fff'}">
          <Menu active-name="1-1" theme="dark" width="auto" :open-names="['1']">
            <Submenu name="1">
              <template slot="title">
                <Icon type="ios-navigate"></Icon>商品管理
              </template>
              <MenuItem class="menuItem" name="1-1">
                <div @click="changeTree(1, 1)">
                  <router-link class="menuItemLink" to="/main/goods-product">商品发布</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="1-2">
                <div @click="changeTree(1, 2)">
                  <router-link class="menuItemLink" to="/main/stock-goods">库存商品</router-link>
                </div>
              </MenuItem>
            </Submenu>
            <Submenu name="2">
              <template slot="title">
                <Icon type="ios-keypad"></Icon>商品设置
              </template>
              <MenuItem class="menuItem" name="2-1">
                <div @click="changeTree(2, 1)">
                  <router-link class="menuItemLink" to="/main/brand-categroy">品牌设置</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="2-2">
                <div @click="changeTree(2, 2)">
                  <router-link class="menuItemLink" to="/main/payment-types">支付类型设置</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="2-3">
                <div @click="changeTree(2, 3)">
                  <router-link class="menuItemLink" to="/main/ship-company">货运公司设置</router-link>
                </div>
              </MenuItem>
            </Submenu>
            <Submenu name="3">
              <template slot="title">
                <Icon type="md-copy"></Icon>订单管理
              </template>
              <MenuItem class="menuItem" name="3-1">
                <div @click="changeTree(3, 1)">
                  <router-link class="menuItemLink" to="/main/all-order">全部订单</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="3-2">
                <div @click="changeTree(3, 2)">
                  <router-link class="menuItemLink" to="/main/ready-order">待发货订单</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="3-3">
                <div @click="changeTree(3, 3)">
                  <router-link class="menuItemLink" to="/main/finish-order">完成订单</router-link>
                </div>
              </MenuItem>
            </Submenu>
            <Submenu name="4">
              <template slot="title">
                <Icon type="md-contacts"></Icon>管理员管理
              </template>
              <MenuItem class="menuItem" name="4-1">
                <div @click="changeTree(4, 1)">
                  <router-link class="menuItemLink" to="/main/role-management">角色管理</router-link>
                </div>
              </MenuItem>
              <MenuItem class="menuItem" name="4-2">
                <div @click="changeTree(4, 2)">
                  <router-link class="menuItemLink" to="/main/employee-management">员工管理</router-link>
                </div>
              </MenuItem>
            </Submenu>
          </Menu>
        </Sider>
        <Layout :style="{padding: '0 24px 24px'}">
          <Breadcrumb :style="{margin: '24px 0'}">
            <BreadcrumbItem>主页</BreadcrumbItem>
            <BreadcrumbItem>{{son}}</BreadcrumbItem>
            <BreadcrumbItem>{{grandson}}</BreadcrumbItem>
          </Breadcrumb>
          <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
            <router-view></router-view>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  </div>
</template>

<script>
export default {
  name: "Main",
  data() {
    return {
      userName: "",
      son: "商品管理",
      grandson: "商品发布"
    };
  },
  components: {},
  created: function() {
    this.setUserName();
  },
  methods: {
    setUserName() {
      this.userName = sessionStorage.getItem("username");
    },
    changeTree(son, grandson) {
      if (son == 1) {
        this.son = "商品管理";
        if (grandson == 1) {
          this.grandson = "商品发布";
        } else if (grandson == 2) {
          this.grandson = "库存商品";
        }
      } else if (son == 2) {
        this.son = "商品设置";
        if (grandson == 1) {
          this.grandson = "品牌设置";
        } else if (grandson == 2) {
          this.grandson = "支付类型设置";
        } else if (grandson == 3) {
          this.grandson = "货运公司设置";
        }
      } else if (son == 3) {
        this.son = "订单管理";
        if (grandson == 1) {
          this.grandson = "全部订单";
        } else if (grandson == 2) {
          this.grandson = "待发货订单";
        } else if (grandson == 3) {
          this.grandson = "完成订单";
        }
      } else if (son == 4) {
        this.son = "管理员管理";
        if (grandson == 1) {
          this.grandson = "角色管理";
        } else if (grandson == 2) {
          this.grandson = "员工管理";
        }
      }
    }
  }
};
</script>

<style scoped>
.layout {
  height: 100vh;
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: scoll;
  z-index: 2;
}
.layout-logo {
  width: 100px;
  height: 30px;
  background: #5b6270;
  border-radius: 3px;
  float: left;
  position: relative;
  top: 15px;
  left: 20px;
}
.layout-nav {
  width: 420px;
  margin: 0 auto;
  margin-right: 20px;
}
.menuItem {
  padding: 0;
}
.menuItem .menuItemLink {
  display: block;
  width: 100%;
  padding: 14px 0;
}
</style>