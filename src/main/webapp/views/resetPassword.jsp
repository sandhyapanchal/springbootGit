<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="loginregister.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  </head>
  <body>
    <div class="center">
      <h2>Reset Password</h2>
      <form method="post">
        <div class="txt_field"  id="email">
          <input type="text" required>
          <span></span>
          <label>Enter Your Email</label>
        </div>
        <div class="txt_field token d-none" id="token">
          <input type="token"  required>
          <span></span>
          <label>Verify Token</label>
        </div>
        <div class="txt_field password1 d-none" id="password1">
            <input type="password1" required>
            <span></span>
            <label>Password</label>
          </div>
          <div class="txt_field password2 d-none" id="password2">
            <input type="password2"  required>
            <span></span>
            <label>Confirm Password</label>
          </div>
        <input type="submit" id="sendotp" value="Send Otp">
        <input type="submit" class="d-none" id="login" value="Login">
        <div class="signup_link">
          Not a member? <a href="/register">Signup</a>
        </div>
      </form>
    </div>


    <script>
        document.getElementById('sendotp').addEventListener('click',function(){
            console.log("Button Clicked");
            // document.getElementById('main-loader').classList.add('d-none');
            document.getElementById('email').classList.remove('d-none');
            document.getElementById('password1').classList.remove('d-none');
        })
    </script>
 
  </body>
</html>
