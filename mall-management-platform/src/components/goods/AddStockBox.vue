<template>
  <div id="addStockBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>添加库存</h2>
        </div>
        <div class="box-content">
          <label for="goodsIdInput">
            商品ID：
            <Input
              id="goodsIdInput"
              v-model="goods_id"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <label for="storeInput">
            库存数量：
            <Input
              id="storeInput"
              v-model="store"
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
  name: "AddStockBox",
  data() {
    return {
      goods_id: "",
      store: ""
    };
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.goods_id != "" && this.store != "") {
        this.axios
          .post(
            "/MobileShop/store",
            this.qs.stringify({
              goodsId: this.goods_id,
              store: this.store
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.axios
                .post(
                  "/MobileShop/store",
                  this.qs.stringify({
                    goodsId: this.goods_id,
                    store: this.store
                  })
                )
                .then(response => {
                  if (response.data.status == 0) {
                    this.$emit("addstock", response.data.data);
                    this.$emit("change", false);
                    alert(response.data.msg);
                    this.goods_id = "";
                    this.store = "";
                  } else {
                    alert(response.data.msg);
                  }
                })
                .catch(error => {
                  console.log(error);
                });
              this.$emit("addstock", response.data.data);
              this.$emit("change", false);
              alert(response.data.msg);
              this.goods_id = "";
              this.store = "";
            } else {
              alert(response.data.msg);
            }
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        alert("请输入库存数量！");
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
  height: 220px;
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