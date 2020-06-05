<template>
  <div>
    <add-employee-box
      v-show="isShowAddBox"
      @change="changeAddBoxStatus"
      @addemployee="addemployeetolist"
    />
    <edit-employee-box
      :employeeinfo="employeeinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editemployee="editemployeetolist"
    />
    <Button type="info" id="addEmployeeBtn" @click="isShowAddBox = true;">添加员工</Button>
    <Table border :columns="employeeColumns" :data="employeeList"></Table>
  </div>
</template>
<script>
import AddEmployeeBox from "./AddEmployeeBox";
import EditEmployeeBox from "./EditEmployeeBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      employinfoobj: {},
      employeeColumns: [
        {
          title: "ID",
          key: "admin_id"
        },
        {
          title: "用户名",
          key: "username"
        },
        {
          title: "邮箱",
          key: "email"
        },
        {
          title: "真实名字",
          key: "real_name"
        },
        {
          title: "性别",
          key: "sex"
        },
        {
          title: "手机号码",
          key: "mobile"
        },
        {
          title: "角色名称",
          key: "role_id"
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
      employeeList: []
    };
  },
  components: {
    AddEmployeeBox,
    EditEmployeeBox
  },
  created: function() {
    this.loadEmployeeList();
  },
  watch: {
    employeeList: function() {
      for (let i = 0; i < this.employeeList.length; i++) {
        if (this.employeeList[i].sex == "0") this.employeeList[i].sex = "男";
        else this.employeeList[i].sex = "女";
      }
    }
  },
  methods: {
    loadEmployeeList() {
      this.axios
        .get("/MobileShop/admin_manager")
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.employeeList.push(response.data.data[i]);
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
      this.employeeinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.employeeList.splice(params.index, 1);
      this.axios
        .delete("/MobileShop/admin_manager/" + params.row.admin_id)
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
    addemployeetolist(data) {
      console.log(data);
      this.employeeList.push(data);
    },
    editemployeetolist(data) {
      this.employeeList.some((employee, index) => {
        if (employee.admin_id == data.admin_id) {
          this.employeeList.splice(index, 1, data);
        }
      });
    }
  }
};
</script>

<style scoped>
#addEmployeeBtn {
  margin-bottom: 10px;
}
</style>}