<template>
  <div id="login">
    <div id="login-con">
      <h1>管理员登录</h1>
      <form id="login_form">
        <dl>
          <dt>账号：</dt>
          <dd>
            <input
              type="text"
              class="text"
              v-model="userName"
              placeholder="邮箱/手机/用户名"
              value="ls2016"
            />
          </dd>
        </dl>
        <dl>
          <dt>密码：</dt>
          <dd>
            <input
              type="password"
              class="text"
              v-model="password"
              placeholder="请输入您的密码"
              value="123456"
            />
          </dd>
        </dl>
        <dl>
          <dt>&nbsp;</dt>
          <dd>
            <input type="button" class="button" value="登录" @click="login()" id="loginBtn" />
          </dd>
        </dl>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      userName: "",
      password: ""
    };
  },
  methods: {
    login() {
      this.axios
        .post(
          "/MobileShop/admin_manager/login",
          this.qs.stringify({ input: this.userName, password: this.password })
        )
        .then(response => {
          if (response.data.status == 0) {
            alert(response.data.msg);
            sessionStorage.setItem("username", response.data.data.username);
            this.$router.push({ path: "/main" });
          } else {
            alert(response.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>

<style scope>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  border: none;
}
body {
  font-size: 12px;
  font-family: "宋体";
  color: #616161;
}
a {
  color: #999;
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
}
#login {
  height: 100vh;
  width: 100vw;
  background: url("../assets/img/bg.jpg") no-repeat;
  position: relative;
}
#login-con {
  width: 600px;
  height: 300px;
  border-radius: 5px;
  background: #f9f9f9;

  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  text-align: center;
}
#login-con h1 {
  color: #555;
  font-family: "microsoft yahei";
  font-size: 18px;
  font-weight: 700;
  line-height: 20px;
  padding: 25px 0 25px 0;
  text-align: center;
}
#login_form {
  overflow: hidden;
  width: 350px;
  margin: 0 auto;
}
#login_form dl {
  clear: both;
  float: left;
  width: 100%;
  margin: 10px;
}
#login_form dl dt {
  color: #777;
  float: left;
  font-size: 14px;
  line-height: 28px;
  text-align: right;
  width: 22%;
}
#login_form dl dd {
  float: right;
  text-align: left;
  width: 75%;
  position: relative;
}
#login_form dl dd .text {
  background-color: #fff;
  border: 1px solid #bbb;
  font-family: Tahoma;
  /* height: 20px; */
  line-height: 20px;
  padding: 3px !important;
  width: 210px;
}
#login_form dl dd .button {
  background: #f08300;
  border: 0 none;
  border-radius: 2px;
  color: #fff;
  cursor: pointer;
  font-size: 14px;
  font-weight: 700;
  height: 34px;
  margin: 0;
  padding: 0;
  vertical-align: middle;
  width: 210px;
  float: left;
  text-align: center;
}
</style>