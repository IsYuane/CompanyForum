/**
 * 登录界面
 * 表单验证
 * 登录成功用户信息存储-cookie,记住密码，及页面的跳转
 */
$.ajaxSetup({ xhrFields: { withCredentials: true }, crossDomain: true });
$(function(){
    var gb ={
        baseUrl:'http://localhost:8080/mhj/',
        Replace: function(str){
                var mean = /\[([\u4E00-\u9FA5]{1,5})\]/g;
                str = str.replace(/[<>]/g,function(c){return {'<':'&lt','>':'&gt'}[c];});
                str=str.replace(/[\s\r\n]/g,"");
                return str;
            }
    };
    var cookie = {
        passKey:"43f3k54dn52d61669jd7tc0a843sa7f8",
        Set: function (cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays*24*60*60*1000));
                var expires = "expires="+d.toUTCString();
                document.cookie = md5(cname) + "=" + encrypt(escape(cvalue),this.passKey) + "; " + expires;
            },
        Get: function(cname){
            var name = md5(cname) + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1);
                    if (c.indexOf(name) != -1){
                        var cnameValue = unescape(c.substring(name.length, c.length));
                        return decrypt(cnameValue, this.passKey);
                    } 
            }
            return "";
        },
        Delet:  function(cname){  
            cookie.Set(md5(cname), "", -1);  
        }  
    };
   
    var tip = {
       contain: ".wrap",
       Show:function(str){
            var innerHtml = '<div class="tip" ><span class="tip_text">'+str+'</span><span class="dotting"></span></div>',
               self = this;
            $(".tip").remove();
            $(self.contain).append(innerHtml);
            $(".tip").fadeIn();
            $("#login_btn").attr("disabled",true);
       },
       Hide:function(str){
           var self = this;
            $(".tip_text").text(str).next().hide();
            $(".tip").animate({'margin-top': '140px'},200).fadeOut(200);
            $("#login_btn").attr("disabled",false);  
                    
        }
    };

    var form = {
        name:$("#inputName"),
        password: $("#inputPassword"),
        Validate:function(){
            var self = this;
            $("#login_btn").on('click',function(){
                var  input_name =$.trim(self.name.val()),
                     input_password =$.trim(self.password.val());

                if(input_name==""){
                    self.name.next().html("请输入用户名！");
                    self.name.addClass("error_tip").focus();
                    return false;
                }else if(input_password==""){
                    self.password.next().html("请输入密码!");
                    self.password.addClass("error_tip").focus();
                    return false;
                }
                else{
                    self.Login(input_name,input_password);
                }
            })
        },
        Login:function(acc,psd){
            var self = this;
            tip.Show("正在登录");
            //登录请求
            $.ajax({
            type:"post",
            url:  gb.baseUrl+"login",
            data: $("#form_login").serialize(),
            success:function(result){
                if(result.code==100){
                   // console.log("登录成功");
                    self.Remenber(acc,psd);
                    //显示登录成功
                    setTimeout(function(){
                       tip.Hide("登录成功");
                       //跳转到首页 
                       setTimeout(function(){
                        window.location.href= gb.baseUrl+"isAdmin";
                       },400);
                    },1500);   
                } 
                else if(result.code==200){
                    setTimeout(tip.Hide("登录失败"),1500);
                    self.password.next().html("密码错误，请重新输入!");
                    self.password.addClass("error_tip").focus();
                }
                else{ setTimeout(tip.Hide("登录失败"),1500); }
            },
            error:function(){
                console.log("服务器错误");
                setTimeout(tip.Hide("登录失败"),1500);
            },
        })          
        },
        Reinput: function(){
            var input = $(".form-control");
            input.blur(function(){
                input.removeClass("error_tip").next().html("");
            });
            input.keydown(function(){
                input.removeClass("error_tip").next().html("");  
            })   
        },
        Remenber:function(acc,psd){
            if($("#check").is(':checked')){
                console.log("记住");
                cookie.Set("username", acc, 7 );
                cookie.Set("userpsd", psd, 7);    
            }
            else{ 
                console.log("不记住");
                cookie.Delet("username");
                cookie.Delet("userpsd");          
            }        
        },
        init: function(){
            this.Validate();
            this.Reinput();
            //初始化自动填充 
            var prename = cookie.Get("username"),
                prepsd =  cookie.Get("username"),
                self =  this;
            if(prename!=""&&prepsd!=""){ 
                self.name.val(prename);
                self.password.val(prepsd);
            }
            localStorage.removeItem('friendlist');
            
         }
    };

    form.init();
   
})

