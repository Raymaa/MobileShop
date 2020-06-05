<template>
  <div id="stockgoods">
    <add-stock-box v-show="isShowAddBox" @change="changeAddBoxStatus" @addstock="addstocktolist" />
    <edit-stock-box
      :stockinfo="stockinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editstock="editstocktolist"
    />
    <Button type="info" id="addStockBtn" @click="isShowAddBox = true;">添加库存</Button>
    <Table border :columns="stockColumns" :data="stockList"></Table>
    <Page id="pagination" :total="20" @on-change="pageChange" />
  </div>
</template>
<script>
import AddStockBox from "./AddStockBox";
import EditStockBox from "./EditStockBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      stockinfoobj: {},
      pageId: 1,
      stockColumns: [
        {
          title: "库存ID",
          key: "store_id"
        },
        {
          title: "商品ID",
          key: "goods_id"
        },
        {
          title: "库存数量",
          key: "store"
        },
        {
          title: "商品名称",
          key: "goodsName",
          width: 450
        },
        {
          title: "商品价格",
          key: "goodsPrice"
        },
        {
          title: "操作",
          key: "action",
          width: 180,
          align: "center",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props: {
                    type: "primary",
                    size: "small"
                  },
                  style: {
                    marginRight: "5px"
                  },
                  on: {
                    click: () => {
                      this.edit(params);
                    }
                  }
                },
                "Edit"
              ),
              h(
                "Button",
                {
                  props: {
                    type: "error",
                    size: "small"
                  },
                  on: {
                    click: () => {
                      this.remove(params);
                    }
                  }
                },
                "Delete"
              )
            ]);
          }
        }
      ],
      stockList: []
    };
  },
  components: {
    AddStockBox,
    EditStockBox
  },
  created: function() {
    this.loadStockList();
  },
  methods: {
    loadStockList() {
      this.axios
        .get("/MobileShop/store/page/" + this.pageId)
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.stockList.push(response.data.data[i]);
              this.stockList[i].goodsName = this.stockList[i].briefGoods.name;
              this.stockList[i].goodsPrice = this.stockList[i].briefGoods.price;
            }
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    edit(params) {
      this.stockinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.stockList.splice(params.index, 1);
      this.axios
        .delete("/MobileShop/store/" + params.row.store_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    changeAddBoxStatus(data) {
      this.isShowAddBox = data;
    },
    changeEditBoxStatus(data) {
      this.isShowEditBox = data;
    },
    addstocktolist(data) {
      this.stockList.push(data);
    },
    editstocktolist(data) {
      this.stockList.some((stock, index) => {
        if (stock.store_id == data.store_id) {
          this.stockList.splice(index, 1, data);
        }
      });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.stockList = [];
      this.loadStockList();
    }
  }
};
</script>

<style scoped>
#addStockBtn {
  margin-bottom: 10px;
}
#pagination {
  text-align: center;
  margin-top: 10px;
}
</style>
