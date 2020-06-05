<template>
  <div id="editShipBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>编辑货运公司信息</h2>
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
  name: "EditShipBox",
  data() {
    return {
      ship_id: "",
      name: "",
      code: ""
    };
  },
  props: {
    shipinfo: Object
  },
  watch: {
    shipinfo: function() {
      this.ship_id = this.shipinfo.ship_id;
      this.name = this.shipinfo.name;
      this.code = this.shipinfo.code;
    }
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.ship_id != "" && this.name != "" && this.code != "") {
        this.axios
          .put(
            "/MobileShop/ship/" + this.ship_id,
            this.qs.stringify({
              name: this.name,
              code: this.code
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("editship", {
                ship_id: this.ship_id,
                name: this.name,
                code: this.code
              });
              alert(response.data.msg);
              this.$emit("change", false);
            } else {
              alert(response.data.msg);
            }
          })
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