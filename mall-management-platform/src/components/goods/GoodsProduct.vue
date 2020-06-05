<template>
  <div id="goodsproduct">
    <add-product-box
      v-show="isShowAddBox"
      @change="changeAddBoxStatus"
      @addproduct="addproducttolist"
    />
    <edit-product-box
      :productinfo="productinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editproduct="editproducttolist"
    />
    <div class="some">
      <Button type="info" id="addProductBtn" @click="isShowAddBox = true;">发布商品</Button>
      <Input
        id="search"
        @on-search="searchInfo"
        @on-change="searchOnTimeInfo"
        search
        enter-button
        placeholder="Enter something..."
      />
    </div>
    <Table border :columns="productColumns" :data="productList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
import AddProductBox from "./AddProductBox";
import EditProductBox from "./EditProductBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      productinfoobj: {},
      pageId: 1,
      totalPage: 0,
      productColumns: [
        {
          title: "商品ID",
          key: "goods_id"
        },
        {
          title: "商品名称",
          key: "name",
          width: 450
        },
        {
          title: "销售价",
          key: "price"
        },
        {
          title: "是否上架",
          key: "mkt_enable"
        },
        {
          title: "操作",
          key: "action",
          width: 250,
          align: "center",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props: {
                    type: "success",
                    size: "small"
                  },
                  style: {
                    marginRight: "5px"
                  },
                  on: {
                    click: () => {
                      this.detail(params);
                    }
                  }
                },
                "Detial"
              ),
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
      productList: []
    };
  },
  components: {
    AddProductBox,
    EditProductBox
  },
  created: function() {
    this.loadProductList();
    this.loadTotalPage();
  },
  methods: {
    loadTotalPage() {
      this.axios
        .get("/MobileShop/goods/page/count")
        .then(response => {
          if (response.data.status == 0) {
            this.totalPage = response.data.data * 10;
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadProductList() {
      this.axios
        .get("/MobileShop/goods/page/" + this.pageId)
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.productList.push(response.data.data[i]);
            }
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    detail(params) {
      this.axios
        .get("/MobileShop/goods/" + params.row.goods_id)
        .then(response => {
          if (response.data.status == 0) {
            this.$Modal.info({
              title: "商品详细信息",
              content: `商品ID：${response.data.data.goods_id}<br>商品名称：${response.data.data.name}<br>商品货号：${response.data.data.sn}<br>商品简介：${response.data.data.brief}<br>商品描述：${response.data.data.description}<br>销售价：${response.data.data.price}<br>成本价：${response.data.data.cost}<br>市场价：${response.data.data.mktprice}<br>是否上架：${response.data.data.mkt_enable}<br>分类编号：${response.data.data.cat_id}<br>品牌编号：${response.data.data.brand_id}<br>重量：${response.data.data.weight}<br>详情描述：${response.data.data.intro}<br>`
            });
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    edit(params) {
      this.axios
        .get("/MobileShop/goods/" + params.row.goods_id)
        .then(response => {
          if (response.data.status == 0) {
            this.productinfoobj = response.data.data;
            this.isShowEditBox = true;
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    remove(params) {
      this.axios
        .delete("/MobileShop/goods/" + params.row.goods_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            this.productList.splice(params.index, 1);
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
    addproducttolist(data) {
      this.productList.push(data);
    },
    editproducttolist(data) {
      this.productList.some((product, index) => {
        if (product.goods_id == data.goods_id) {
          this.productList.splice(index, 1, data);
        }
      });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.productList = [];
      this.loadProductList();
    },
    searchInfo(data) {
      if (data != "") {
        this.axios
          .post(
            "/MobileShop/goods/findFromAll",
            this.qs.stringify({ input: data })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.productList = [];
              for (let i = 0; i < response.data.data.length; i++) {
                this.productList.push(response.data.data[i]);
              }
            }
          });
      } else if (data == "") {
        this.loadProductList();
      }
    },
    searchOnTimeInfo(data) {
      if (data.data != "") {
        this.axios
          .post(
            "/MobileShop/goods/findFromAll",
            this.qs.stringify({ input: data.data })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.productList = [];
              for (let i = 0; i < response.data.data.length; i++) {
                this.productList.push(response.data.data[i]);
              }
            }
          });
      } else if (data.data == "") {
        this.loadProductList();
      }
    }
  }
};
</script>

<style scoped>
#addProductBtn {
  margin-bottom: 10px;
}
#pagination {
  text-align: center;
  margin-top: 10px;
}
.some {
  display: flex;
}
.some #search {
  margin-left: 20px;
  width: 400px;
}
</style>
