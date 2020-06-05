<template>
  <div id="brandcategory">
    <add-brand-box v-show="isShowAddBox" @change="changeAddBoxStatus" @addbrand="addbrandtolist" />
    <edit-brand-box
      :brandinfo="brandinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editbrand="editbrandtolist"
    />
    <Button type="info" id="addBrandBtn" @click="isShowAddBox = true;">添加品牌</Button>
    <Table border :columns="brandColumns" :data="brandList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
import AddBrandBox from "./AddBrandBox";
import EditBrandBox from "./EditBrandBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      brandinfoobj: {},
      pageId: 1,
      totalPage: 0,
      brandColumns: [
        {
          title: "品牌ID",
          key: "brand_id"
        },
        {
          title: "品牌名称",
          key: "name"
        },
        {
          title: "关键词",
          key: "keywords"
        },
        {
          title: "品牌描述",
          key: "description",
          width: 450
        },
        {
          title: "品牌官网",
          key: "url",
          width: 250
        },
        {
          title: "操作",
          key: "action",
          width: 160,
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
      brandList: []
    };
  },
  components: {
    AddBrandBox,
    EditBrandBox
  },
  created: function() {
    this.loadBrandList();
    this.loadTotalPage();
  },
  methods: {
    loadTotalPage() {
      this.axios
        .get("/MobileShop/brand/disabled")
        .then(response => {
          if (response.data.status == 0) {
            this.totalPage = response.data.data.length;
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadBrandList() {
      this.axios
        .get("/MobileShop/brand/page/" + this.pageId)
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.brandList.push(response.data.data[i]);
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
      this.brandinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.brandList.splice(params.index, 1);
      this.axios
        .delete("/MobileShop/brand/" + params.row.brand_id)
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
    addbrandtolist(data) {
      this.brandList.push(data);
    },
    editbrandtolist(data) {
      this.brandList.some((brand, index) => {
        if (brand.brand_id == data.brand_id) {
          this.brandList.splice(index, 1, data);
        }
      });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.brandList = [];
      this.loadBrandList();
    }
  }
};
</script>

<style scoped>
#addBrandBtn {
  margin-bottom: 10px;
}
#pagination {
  text-align: center;
  margin-top: 10px;
}
</style>
