<template>
  <div id="addShipBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>添加货运公司</h2>
        </div>
        <div class="box-content">
          <label for="nameInput">
            货运公司名称：
            <Input
              id="nameInput"
              v-model="name"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="codeInput">
            货运公司代码：
            <Input
              id="codeInput"
              v-model="code"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
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
  name: "AddShipBox",
  data() {
    return {
      ship_id: "",
      name: "",
      code: ""
    };
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.name != "" && this.code != "") {
        this.axios
          .post(
            "/MobileShop/ship",
            this.qs.stringify({
              name: this.name,
              code: this.code
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("addship", response.data.data);
              this.$emit("change", false);
              alert(response.data.msg);
              this.name = "";
              this.code = "";
            } else {
              alert(response.data.msg);
            }
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        alert("请输入货运公司信息！");
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
  height: 210px;
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