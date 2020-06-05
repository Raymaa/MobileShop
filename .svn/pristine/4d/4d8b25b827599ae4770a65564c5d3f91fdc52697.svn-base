        $(document).ready(function () {
           
        	//案例1 
        	
        	// 定义模型类
          var Test = Backbone.Model.extend({
                defaults: {
                    content: ''
                }
            });
            // 创建集合模型类  
           var TestList = Backbone.Collection.extend({
                model: Test
            });
            // 向模型添加数据
            var data = new TestList({
                content: 'hello,backbone!'
            });
            // 创建View对象
            var TestView = Backbone.View.extend({
                el: $("body"),
                initialize: function () {
                /*	 console.log(data.models[0]);*/
                    $("#showHere").html(data.models[0].get("content"));
                }
            });
            //实例化View对象
            var App = new TestView;
            
            
            
            
        	//案例2  Underscore template() 模板的使用
            var ele = $("#element");
            var tpl = $("#tpl").html();
            
            var data = {
            		list:[
            		      {StuId:'s0101',Name:'刘一',Score:'98'},
            		      {StuId:'s0101',Name:'刘三',Score:'99'},
            		      {StuId:'s0101',Name:'刘五',Score:'78'},
            		      {StuId:'s0101',Name:'刘七',Score:'58'}
            		      ]
            }
            var  html = _.template(tpl,data);
            ele.append(html);
          
            
            
          //案例3  Underscore template() 模板的使用
            
            
            //查询goodsId为2的商品信息
            var goodsId = 2;
            var GoodsItem = Backbone.Model.extend({
				 url:"http://localhost:8080/MobileShop"+"/goods/"+goodsId,
				  parse : function(response){
			           return response.data;
			         }
            }); 
           
            var goodsItem = new GoodsItem ();
            goodsItem.fetch();

            var GoodsView = Backbone.View.extend({
            	el : '#goodsList',
             	goodsItemTemplate : _.template($("#goodsListTpl").html()),//模板
    	       	initialize: function() {
    	       		   this.listenTo(this.model,'all',this.render);
    	       		 
    	       		},
    	       		render: function(){
    	       		  
    	       		   this.$el.html(this.goodsItemTemplate(this.model.toJSON()));
    	       		   console.log(this.model.get("name"));    
    	       		}
            });
           
            var  viewTest = new GoodsView({
            	model:goodsItem
            });
           
           
            
           
        });