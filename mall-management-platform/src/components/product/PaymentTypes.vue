<template>
  <div id="paymenttypes">
    <add-payment-box
      v-show="isShowAddBox"
      @change="changeAddBoxStatus"
      @addpayment="addpaymenttolist"
    />
    <edit-payment-box
      :paymentinfo="paymentinfoobj"
      v-show="isShowEditBox"
      @change="changeEditBoxStatus"
      @editpayment="editpaymenttolist"
    />
    <Button type="info" id="addPaymentBtn" @click="isShowAddBox = true;">添加支付类型</Button>
    <Table border :columns="paymentColumns" :data="paymentList"></Table>
    <Page id="pagination" :total="totalPage" @on-change="pageChange" />
  </div>
</template>
<script>
import AddPaymentBox from "./AddPaymentBox";
import EditPaymentBox from "./EditPaymentBox";

export default {
  data() {
    return {
      isShowAddBox: false,
      isShowEditBox: false,
      paymentinfoobj: {},
      pageId: 1,
      totalPage: 0,
      paymentColumns: [
        {
          title: "类型ID",
          key: "paytype_id"
        },
        {
          title: "类型名称",
          key: "name"
        },
        {
          title: "类型定义",
          key: "config"
        },
        {
          title: "类型描述",
          key: "description",
          width: 450
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
      paymentList: []
    };
  },
  components: {
    AddPaymentBox,
    EditPaymentBox
  },
  created: function() {
    this.loadPaymentList();
  },
  methods: {
    loadPaymentList() {
      this.axios
        .get("/MobileShop/pay_type")
        .then(response => {
          if (response.data.status == 0) {
            for (let i = 0; i < response.data.data.length; i++) {
              this.paymentList.push(response.data.data[i]);
              this.totalPage = response.data.data.length;
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
      this.paymentinfoobj = params.row;
      this.isShowEditBox = true;
    },
    remove(params) {
      this.axios
        .delete("/MobileShop/pay_type/" + params.row.paytype_id)
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            this.paymentList.splice(params.index, 1);
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
    addpaymenttolist(data) {
      this.paymentList.push(data);
    },
    editpaymenttolist(data) {
      this.paymentList.some((payment, index) => {
        if (payment.paytype_id == data.paytype_id) {
          this.paymentList.splice(index, 1, data);
        }
      });
    },
    pageChange(pageId) {
      this.pageId = pageId;
      this.paymentList = [];
      this.loadPaymentList();
    }
  }
};
</script>

<style scoped>
#addPaymentBtn {
  margin-bottom: 10px;
}
#pagination {
  text-align: center;
  margin-top: 10px;
}
</style>
