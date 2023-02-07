<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<style>
  body{
    background: url("/images/m-school-1.jpg");
        background-repeat: no-repeat;
        background-size: cover;
  }
  button{
    margin-right:30px;
  }
</style>
<body>
  
    <h1>Welcome To Nmims World</h1>
    <h2>Total Number of Registered Users are: <b id = "usercount"></b></h2>

    <button type="submit" id="details"><h3>View Users</h3></button>

    <button type="submit"  onclick='window.location.href="userdetails"'><h3>View All Users</h3></button>

    <div id="personal"></div>
<script>
    document.getElementById('details').addEventListener('click',function(){

        let data = ajaxGet('/details');
        console.log("data>>>",data);
        //data = JSON.parse(data);
        let div = `
        
  
        <b>FirstName : \${data[0].fname}</b><br>

        <b>LastName : \${data[0].lname}</b><br>

        <b>Email : \${data[0].email}</b><br>

        <b>Mobile : \${data[0].mobile}</b><br>
        
        <b>Status : \${data[0].enable}</b><br>
        
        `
        document.querySelector("#personal").innerHTML = div;
    })
   
 let count1=ajax("/getCount")
 document.querySelector("#usercount").innerHTML=count1;

//  $(".activeuser").click(function() {
//         var email = $(this).data('email') // $(this) refers to button that was clicked
//         console.log(email);
//         let action = ajaxPost("\setActive",email);

//     });


    function ajaxGet(URL){
        let resp = null;
        $.ajax({
        url: URL,
        type: 'GET',
        async: false,
        contentType:false,
        success: function (response) {
          resp = response;
        },
        error: function (error) {
          resp = error;           
        },
      });
      return resp;
    }
    function ajax(URL, TYPE, DATA){
        let resp = null;
        $.ajax({
        url: URL,
        type: TYPE,
        async: false,
        contentType:false,
        data: JSON.stringify(DATA),
        success: function (response) {
          resp = response;
        },
        error: function (error) {
          resp = error;           
        },
      });
      return resp;
    }
</script>
</body>
</html>