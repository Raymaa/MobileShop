<template>
  <div id="editProductBox">
    <div id="background-mask">
      <div id="box">
        <div class="box-header">
          <h2>编辑商品信息</h2>
        </div>
        <div class="box-content">
          <label for="goodsIdInput">
            商品ID：
            <Input
              disabled
              id="goodsIdInput"
              v-model="goods_id"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="nameInput">
            商品名称：
            <Input
              id="nameInput"
              v-model="name"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="snInput">
            商品货号：
            <Input id="snInput" v-model="sn" placeholder="Enter something..." style="width: 100%" />
          </label>
          <br />
          <label for="briefInput">
            商品简介：
            <Input
              id="briefInput"
              v-model="brief"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="descriptionInput">
            商品描述：
            <Input
              id="descriptionInput"
              v-model="description"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="priceInput">
            销售价：
            <Input
              id="priceInput"
              v-model="price"
              placeholder="Enter something..."
              style="width: 100%"
            />
            <br />
          </label>
          <label for="costInput">
            成本价：
            <Input
              id="costInput"
              v-model="cost"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="mktpriceInput">
            市场价：
            <Input
              id="mktpriceInput"
              v-model="mktprice"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="mktEnableInput">
            是否上架：
            <Input
              id="mktEnableInput"
              v-model="mkt_enable"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="catIdInput">
            分类编号：
            <Input
              id="catIdInput"
              v-model="cat_id"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="brandIdInput">
            品牌编号：
            <Input
              id="brandIdInput"
              v-model="brand_id"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="weightInput">
            重量：
            <Input
              id="weightInput"
              v-model="weight"
              placeholder="Enter something..."
              style="width: 100%"
            />
          </label>
          <br />
          <label for="introInput">
            详情描述：
            <Input
              id="introInput"
              v-model="intro"
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
  name: "EditProductBox",
  data() {
    return {
      goods_id: "",
      name: "",
      sn: "",
      brief: "",
      description: "",
      price: "",
      cost: "",
      mktprice: "",
      mkt_enable: "",
      cat_id: "",
      brand_id: "",
      weight: "",
      intro: ""
    };
  },
  props: {
    productinfo: Object
  },
  watch: {
    productinfo: function() {
      this.goods_id = this.productinfo.goods_id;
      this.name = this.productinfo.name;
      this.sn = this.productinfo.sn;
      this.brief = this.productinfo.brief;
      this.description = this.productinfo.description;
      this.price = this.productinfo.price;
      this.cost = this.productinfo.cost;
      this.mktprice = this.productinfo.mktprice;
      this.mkt_enable = this.productinfo.mkt_enable;
      this.cat_id = this.productinfo.cat_id;
      this.brand_id = this.productinfo.brand_id;
      this.weight = this.productinfo.weight;
      this.intro = this.productinfo.intro;
    }
  },
  methods: {
    cancel() {
      this.$emit("change", false);
    },
    submit() {
      if (
        this.goods_id != "" &&
        this.name != "" &&
        this.sn != "" &&
        this.brief != "" &&
        this.description != "" &&
        this.price != "" &&
        this.cost != "" &&
        this.mktprice != "" &&
        this.mkt_enable != "" &&
        this.cat_id != "" &&
        this.brand_id != "" &&
        this.weight != "" &&
        this.intro != ""
      ) {
        this.axios
          .put(
            "/MobileShop/goods/" + this.goods_id,
            this.qs.stringify({
              name: this.name,
              sn: this.sn,
              brief: this.brief,
              description: this.description,
              price: this.price,
              cost: this.cost,
              mktprice: this.mktprice,
              mktEnable: this.mkt_enable,
              catId: this.cat_id,
              brandId: this.brand_id,
              weight: this.weight,
              intro: this.intro
            })
          )
          .then(response => {
            if (response.data.status == 0) {
              this.$emit("editproduct", {
                goods_id: this.goods_id,
                name: this.name,
                sn: this.sn,
                brief: this.brief,
                description: this.description,
                price: this.price,
                cost: this.cost,
                mktprice: this.mktprice,
                mktEnable: this.mkt_enable,
                catId: this.cat_id,
                brandId: this.brand_id,
                weight: this.weight,
                intro: this.intro
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
  height: 790px;
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