<template>
  <div id="editStockBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>编辑库存信息</h2>
        </div>
        <div class="box-content">
          <label for="storeIdInput">
            库存ID：
            <Input
              disabled
              id="storeIdInput"
              v-model="store_id"
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
  name: "EditStockBox",
  data() {
    return {
      store_id: "",
      store: ""
    };
  },
  props: {
    stockinfo: Object
  },
  watch: {
    stockinfo: function() {
      this.store_id = this.stockinfo.store_id;
      this.store = this.stockinfo.store;
    }
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (this.store != "") {
        this.axios
          .put(
            "/MobileShop/store/" + this.store_id,
            this.qs.stringify({
              store: this.store
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("editstock", {
                store_id: this.store_id,
                store: this.store
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