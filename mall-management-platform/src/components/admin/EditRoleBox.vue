<template>
  <div id="editRoleBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>编辑角色信息</h2>
        </div>
        <div class="box-content">
          <label for="nameInput">名称：</label>
          <Input
            id="nameInput"
            v-model="name"
            placeholder="Enter something..."
            style="width: 100%"
          />
          <br />
          <label for="descriptionInput">描述：</label>
          <Input
            id="descriptionInput"
            v-model="description"
            type="textarea"
            style="width: 100%"
            :autosize="{minRows: 2,maxRows: 3}"
            placeholder="Enter something..."
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
  name: "EditRoleBox",
  data() {
    return {
      name: "",
      description: ""
    };
  },
  props: {
    roleinfo: Object
  },
  watch: {
    roleinfo: function() {
      this.name = this.roleinfo.name;
      this.description = this.roleinfo.description;
    }
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.name != "" && this.description != "") {
        this.axios
          .put(
            "/MobileShop/role/" + this.roleinfo.role_id,
            this.qs.stringify({
              name: this.name,
              description: this.description
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("editrole", {
                role_id: this.roleinfo.role_id,
                name: this.name,
                description: this.description
              });
              this.$emit("change", false);
              alert(response.data.msg);
              this.name = "";
              this.description = "";
            } else {
              alert(response.data.msg);
            }
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        alert("请输入角色信息！");
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
  height: 260px;
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