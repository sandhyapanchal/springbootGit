<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
      <!-- Design by foolishdeveloper.com -->
        <title> Login Page</title>
     
        
        <!--Stylesheet-->
        <style media="screen">
          *,
    *:before,
    *:after{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    body{
        background-color: #5c5396;
    }
    .background{
        width: 430px;
        height: 520px;
        position: absolute;
        transform: translate(-50%,-50%);
        left: 50%;
        top: 50%;
    }
    .background .shape{
        height: 200px;
        width: 200px;
        position: absolute;
        border-radius: 50%;
    }
    .shape:first-child{
        background: linear-gradient(
            #1845ad,
            #23a2f6
        );
        left: -80px;
        top: -80px;
    }
    .shape:last-child{
        background: linear-gradient(
            to right,
            #ff512f,
            #f09819
        );
        right: -30px;
        bottom: -80px;
    }
    form{
        height: 350px;
        width: 300px;
        background-color: rgba(255,255,255,0.13);
        position: absolute;
        transform: translate(-50%,-50%);
        top: 50%;
        left: 50%;
        border-radius: 10px;
        backdrop-filter: blur(10px);
        border: 2px solid rgba(255,255,255,0.1);
        box-shadow: 0 0 40px rgba(8,7,16,0.6);
        padding: 50px 35px;
    }
    form *{
        font-family: 'Poppins',Monotype Corsiva;
        color: #ffffff;
        letter-spacing: 0.5px;
        outline: none;
        border: none;
    }
    form h3{
        font-size: 32px;
        font-weight: 500;
        line-height: 42px;
        text-align: center;
    }
    
    label{
        display: block;
        margin-top: 30px;
        font-size: 16px;
        font-weight: 500;
    }
    input{
        display: block;
        height: 50px;
        width: 100%;
        background-color: rgba(255,255,255,0.07);
        border-radius: 10px;
        padding: 0 10px;
        margin-top: 8px;
        font-size: 14px;
        font-weight: 300;
    }
    ::placeholder{
        color: #e5e5e5;
    }
    button{
        margin-top: 50px;
        width: 100%;
        background-color: #ada1a1;
        color: #5151b6;
        padding: 15px 0;
        font-size: 18px;
        font-weight: 600;
        border-radius: 5px;
        cursor: pointer;
    }
    .social{
      margin-top: 30px;
      display: flex;
    }
    .social div{
      background: rgb(85, 28, 28);
      width: 250px;
      border-radius: 3px;
      padding: 5px 10px 10px 5px;
      background-color: rgba(255,255,255,0.27);
      color: #eaf0fb;
      text-align: center;
    }
    .social div:hover{
      background-color: rgba(196, 16, 16, 0.47);
    }
    .social .fb{
      margin-left: 25px;
    }
    .social i{
      margin-right: 4px;
    }
    
        </style>
    </head>
<body>
    

    
    <form action="/home" method="post">
        <h2>Login Page</h2>

<label for="email">email:</label>
<input type="text" id="email" name="email">
<br><br>
<label for="password">Password:</label>
<input type="password" id="password"name="password">
<br><br>
<div class="signup _link">
    New User ?<a href="/register">Sign Up</a><br>
<br>
<input type="submit" value="Submit" id="submit">


</form>

<script>
     document.querySelector('#submit').addEventListener('click',function(e){
        console.log("Clicked Login");
        let email = document.querySelector('#email').value;

        
        let password = document.querySelector('#password').value;

        // if(password.length<4)
        // {
        //     alert("Password should be more than 4 Characters...");
        //     return;
        // }
        let obj ={
            email : email,
          password : password
        }
        console.log("obj:::::::::::::::::>",obj)
  console.log("objstrignfyy:::::::::::::::::>",JSON.stringify(obj))
        e.preventDefault();
        
        console.log("register>>>",obj)
          
        $.ajax({
                    url: '/verify_login',
                    type: 'POST',
                    data: JSON.stringify(obj) ,
                    contentType: false,                                        
                    success: function (response) {                                           
                        
                      console.log("response"+ response) ;              
                            console.log("hiiiiiiiiiiii")
                            alert("Login Successfully");
                            location.href = '/home';
                      
                        
                    },
                    error: function (error) {
						        console.log("Error>>>>>>>>");
                    alert("Incorrect email or password");
                    }
                  })
      })
  </script>
</body>
</html>
