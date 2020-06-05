<template>
  <div id="readyready">
    <Table bready :columns="readyColumns" :data="readyList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
export default {
  data() {
    return {
      pageId: 1,
      totalPage: 0,
      readyColumns: [
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
                    size: "smready"
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
      readyList: []
    };
  },
  components: {},
  created: function() {
    this.loadReadyList();
  },
  methods: {
    loadReadyList() {
      this.axios
        .get("/MobileShop/order/status/3/" + this.pageId)
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.readyList.push(response.data.data[i]);
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
        .delete("/MobileShop/ready/" + params.row.order_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            this.readyList.splice(params.index, 1);
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
      this.readyList = [];
      this.loadReadyList();
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
