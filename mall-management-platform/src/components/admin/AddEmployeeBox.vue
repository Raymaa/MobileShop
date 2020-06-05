<template>
  <div id="addEmployeeBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>添加员工</h2>
        </div>
        <div class="box-content">
          <label for="nameInput">手机号码：</label>
          <Input
            id="mobileInput"
            v-model="mobile"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="descriptionInput">真实名字：</label>
          <Input
            id="realNameInput"
            v-model="real_name"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <label for="descriptionInput">角色ID：</label>
          <Input
            id="roleIdInput"
            v-model="role_id"
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
  name: "AddEmployeeBox",
  data() {
    return {
      mobile: "",
      real_name: "",
      role_id: ""
    };
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.mobile != "" && this.real_name != "" && this.role_id != "") {
        this.axios
          .post(
            "/MobileShop/admin_manager",
            this.qs.stringify({
              mobile: this.mobile,
              realName: this.real_name,
              roleId: this.role_id
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("addemployee", response.data.data);
              alert(response.data.msg);
            } else {
              alert(response.data.msg);
            }
            this.mobile = "";
            this.real_name = "";
            this.role_id = "";
          })
          .catch(error => {
            console.log(error);
          });
        this.$emit("change", false);
      } else {
        alert("请输入员工信息");
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
  height: 270px;
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