<template>
  <div id="orderorder">
    <Table border :columns="orderColumns" :data="orderList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
export default {
  data() {
    return {
      pageId: 1,
      totalPage: 0,
      orderColumns: [
        {
          title: "订单ID",
          key: "order_id"
        },
        {
          title: "订单号",
          key: "sn",
          width: 300
        },
        {
          title: "订单状态",
          key: "status"
        },
        {
          title: "总共金额",
          key: "total_amount"
        },
        {
          title: "操作",
          key: "action",
          width: 200,
          align: "center",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props: {
                    type: "error",
                    size: "smorder"
                  },
                  on: {
                    click: () => {
                      this.cancel(params);
                    }
                  }
                },
                "Cancel"
              )
            ]);
          }
        }
      ],
      orderList: []
    };
  },
  components: {},
  created: function() {
    this.loadOrderList();
  },
  methods: {
    loadOrderList() {
      this.axios
        .get("/MobileShop/order/status/4/" + this.pageId)
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.orderList.push(response.data.data[i]);
            }
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    cancel(params) {
      this.axios
        .delete("/MobileShop/order/" + params.row.order_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            this.orderList.splice(params.index, 1);
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.orderList = [];
      this.loadOrderList();
    }
  }
};
</script>

<style scoped>
#pagination {
  text-align: center;
  margin-top: 10px;
}
</style>
