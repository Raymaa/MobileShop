<template>
  <div id="rloemanagement">
    <add-role-box v-show="isShowAddBox" @change="changeAddBoxStatus" @addrole="addroletolist" />
    <edit-role-box
      :roleinfo="roleinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editrole="editroletolist"
    />
    <Button type="info" id="addRoleBtn" @click="isShowAddBox = true;">添加角色</Button>
    <Table border :columns="roleColumns" :data="roleList"></Table>
  </div>
</template>
<script>
import AddRoleBox from "./AddRoleBox";
import EditRoleBox from "./EditRoleBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      roleinfoobj: {},
      roleColumns: [
        {
          title: "ID",
          key: "role_id"
        },
        {
          title: "名称",
          key: "name"
        },
        {
          title: "描述",
          key: "description",
          width: 450
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
      roleList: []
    };
  },
  components: {
    AddRoleBox,
    EditRoleBox
  },
  created: function() {
    this.loadRoleList();
  },
  methods: {
    loadRoleList() {
      this.axios
        .get("/MobileShop/role")
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.roleList.push(response.data.data[i]);
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
      this.roleinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.roleList.splice(params.index, 1);
      this.axios
        .delete("/MobileShop/role/" + params.row.role_id)
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
    addroletolist(data) {
      this.roleList.push(data);
    },
    editroletolist(data) {
      this.roleList.some((role, index) => {
        if (role.role_id == data.role_id) {
          this.roleList.splice(index, 1, data);
        }
      });
    }
  }
};
</script>

<style scoped>
#addRoleBtn {
  margin-bottom: 10px;
}
</style>
