import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios"
import qs from "qs"
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';

Vue.use(ViewUI);

Vue.prototype.axios = axios
Vue.prototype.qs = qs
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
