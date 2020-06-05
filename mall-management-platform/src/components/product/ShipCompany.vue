<template>
  <div id="shipcompany">
    <add-ship-box v-show="isShowAddBox" @change="changeAddBoxStatus" @addship="addshiptolist" />
    <edit-ship-box
      :shipinfo="shipinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editship="editshiptolist"
    />
    <Button type="info" id="addShipBtn" @click="isShowAddBox = true;">添加货运公司</Button>
    <Table border :columns="shipColumns" :data="shipList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
import AddShipBox from "./AddShipBox";
import EditShipBox from "./EditShipBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      shipinfoobj: {},
      pageId: 1,
      totalPage: 0,
      shipColumns: [
        {
          title: "货运公司ID",
          key: "ship_id"
        },
        {
          title: "货运公司名称",
          key: "name"
        },
        {
          title: "货运公司代号",
          key: "code"
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
      shipList: []
    };
  },
  components: {
    AddShipBox,
    EditShipBox
  },
  created: function() {
    this.loadShipList();
  },
  methods: {
    loadShipList() {
      this.axios
        .get("/MobileShop/ship")
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.shipList.push(response.data.data[i]);
              this.totalPage = response.data.data.length;
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
      this.shipinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.axios
        .delete("/MobileShop/ship/" + params.row.ship_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            this.shipList.splice(params.index, 1);
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
    addshiptolist(data) {
      this.shipList.push(data);
    },
    editshiptolist(data) {
      this.shipList.some((ship, index) => {
        if (ship.ship_id == data.ship_id) {
          this.shipList.splice(index, 1, data);
        }
      });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.shipList = [];
      this.loadShipList();
    }
  }
};
</script>

<style scoped>
#addShipBtn {
  margin-bottom: 10px;
}
#pagination {
  text-align: center;
  margin-top: 10px;
}
</style>
