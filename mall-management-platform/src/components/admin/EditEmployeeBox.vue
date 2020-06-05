<template>
  <div id="editEmployeeBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>编辑员工信息</h2>
        </div>
        <div class="box-content">
          <label for="nameInput">用户名：</label>
          <Input
            id="usernameInput"
            v-model="username"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="nameInput">邮箱：</label>
          <Input
            id="emailInput"
            v-model="email"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="nameInput">真实名字：</label>
          <Input
            id="realNameInput"
            v-model="real_name"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="nameInput">性别：</label>
          <Input id="sexInput" v-model="sex" placeholder="Enter something..." style="width: 100%" />
          <br />
          <label for="nameInput">手机号码：</label>
          <Input
            id="mobileInput"
            v-model="mobile"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="descriptionInput">角色ID：</label>
          <Input
            id="roleIdInput"
            v-model="role_id"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="descriptionInput">密码：</label>
          <Input
            id="passwordInput"
            v-model="password"
            placeholder="Enter something..."
            style="width: 100%"
          />
        </div>
        <div class="box-footer">
          <Button @click="cancel">取消</Button>
          <Button type="primary" @click="submit">提交</Button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "EditEmployeeBox",
  data() {
    return {
      admin_id: "",
      email: "",
      mobile: "",
      password: "",
      real_name: "",
      role_id: "",
      sex: "",
      username: ""
    };
  },
  props: {
    employeeinfo: Object
  },
  watch: {
    employeeinfo: function() {
      this.admin_id = this.employeeinfo.admin_id;
      this.email = this.employeeinfo.email;
      this.mobile = this.employeeinfo.mobile;
      this.password = this.employeeinfo.password;
      this.real_name = this.employeeinfo.real_name;
      this.role_id = this.employeeinfo.role_id;
      this.sex = this.employeeinfo.sex == "男" ? "0" : "1";
      this.username = this.employeeinfo.username;
    }
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (
        this.admin_id != "" &&
        this.email != "" &&
        this.mobile != "" &&
        this.password != "" &&
        this.real_name != "" &&
        this.role_id != "" &&
        this.sex != "" &&
        this.username != ""
      ) {
        this.axios
          .all([
            this.axios.put(
              "/MobileShop/admin_manager/info/" + this.admin_id,
              this.qs.stringify({
                mobile: this.mobile,
                realName: this.real_name,
                roleId: this.role_id
              })
            ),
            this.axios.put(
              "/MobileShop/admin_manager/" + this.admin_id,
              this.qs.stringify({
                username: this.username,
                password: this.password,
                email: this.email,
                sex: this.sex
              })
            )
          ])
          .then(
            this.axios.spread((response1, response2) => {
              if (response1.data.status == 0 && response2.data.status == 0) {
                this.$emit("editemployee", {
                  admin_id: this.admin_id,
                  email: this.email,
                  mobile: this.mobile,
                  password: this.password,
                  real_name: this.real_name,
                  role_id: this.role_id,
                  sex: this.sex == "男" ? "0" : "1",
                  username: this.username
                });
                alert("更新数据成功");
                this.$emit("change", false);
              } else {
                if (response1.data.status != 0) {
                  alert(response1.data.msg);
                }
                if (response2.data.status != 0) {
                  alert(response2.data.msg);
                }
              }
            })
          )
          .catch(error => {
            console.log(error);
          });
      } else {
        alert("请完善信息");
      }
    }
  }
};
</script>

<style scoped>
#background-mask {
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.3);
  position: absolute;
  left: 0;
  top: 0;
  bottom: 0;
  right: 0;
  z-index: 1000;
}
#box {
  padding: 15px;
  width: 600px;
  height: 460px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.4);
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  overflow: hidden;
}
.box-header h2 {
  color: #555;
  font-family: "microsoft yahei";
  font-size: 18px;
  font-weight: 700;
  line-height: 20px;
  margin-bottom: 20px;
  text-align: left;
}
.box-footer {
  text-align: right;
  margin-top: 10px;
}
.box-footer button {
  margin-left: 10px;
}
</style>