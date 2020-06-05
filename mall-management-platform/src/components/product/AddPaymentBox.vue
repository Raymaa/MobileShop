<template>
  <div id="addPaymentBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>添加支付类型</h2>
        </div>
        <div class="box-content">
          <label for="nameInput">
            类型名称：
            <Input
              id="nameInput"
              v-model="name"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="configInput">
            类型定义：
            <Input
              id="configInput"
              v-model="config"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="descriptionInput">
            类型描述：
            <Input
              id="descriptionInput"
              v-model="description"
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
  name: "AddPaymentBox",
  data() {
    return {
      paytype_id: "",
      name: "",
      config: "",
      description: ""
    };
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.name != "" && this.config != "" && this.description != "") {
        this.axios
          .post(
            "/MobileShop/pay_type",
            this.qs.stringify({
              name: this.name,
              config: this.config,
              description: this.description
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("addpayment", response.data.data);
              this.$emit("change", false);
              alert(response.data.msg);
              this.name = "";
              this.config = "";
              this.description = "";
              this.url = "";
            } else {
              alert(response.data.msg);
            }
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        alert("请输入支付类型信息！");
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
  height: 265px;
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