<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Document</title>
</head>
<style>

  
body{

  background: url("/images/m-school-1.jpg");
      background-repeat: no-repeat;
      background-size: cover;
      
}
table, th, td {
    border:5px solid white;
  }
  button{
    margin-right:5px;
  }
</style>

<body>
    <h1>All Details Are Here:-</h1>
   <div>
    <table border="1" id="TableToExport" style="width:50%" >
        <thead>
            <tr>
            <th>First Name: </th>
            <th>Last Name: </th>
            <th>Email-Id: </th>
            <th>Mobile Number: </th>
            <th>Action </th>
            </tr>
        </thead>
        <tbody id= "info">

        </tbody>
    </table>
    <br><button id="sheetjsexport"><b>Export Userdetails</b></button>
    <button onclick="window.history.back()">Back</button>
   </div>
</body>
<script>
    

        let data = ajaxGet('/allDetails');
        console.log("DataFront>>",data)
        let div = ``;
        

        for(let info of data){
        
        div += `
        <tr>
            <td>\${info.fname}</td>
            <td>\${info.lname}</td>
            <td>\${info.email}</td>
            <td>\${info.mobile}</td>
            `
            if(info.enable == 'Y'){
         div+=   `<td> <button data-email = "\${info.email}" class="Deactiveuser btn btn-danger">Deactive</button></td>`
         
            }else{
                div+=`     <td> <button  class='activeuser btn btn-success' data-email = "\${info.email}" class="activeuser">Active</button></td>`

         }            
        div += `</tr>
        `   

        document.querySelector("#info").innerHTML = div;
        }

 
    $(".Deactiveuser").click(function() {
        var email = $(this).data('email') // $(this) refers to button that was clicked
        console.log(email);
        let action = ajaxPost("\setDeactive",email);       
        

    });

    $(".activeuser").click(function() {
        var email = $(this).data('email') // $(this) refers to button that was clicked
        console.log(email);
        let action = ajaxPost("\setActive",email);

  

    });
 

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
    
    function ajaxPost(URL, DATA){
        let resp = null;
        $.ajax({
        url: URL,
        type: 'POST',
        async: false,
        contentType:false,
        data: DATA,
        success: function (response) {
            location. reload() 
          resp = response;
        },
        error: function (error) {
          resp = error;           
        },
      });
      return resp;
    }
    
</script>

<script src="https://cdn.sheetjs.com/xlsx-latest/package/dist/xlsx.full.min.js"></script>



<script>
document.getElementById("sheetjsexport").addEventListener('click', function() {
 /* Create worksheet from HTML DOM TABLE */
 var wb = XLSX.utils.table_to_book(document.getElementById("TableToExport"));
 /* Export to file (start a download) */
 XLSX.writeFile(wb, "SheetJSTable.xlsx");
});
</script>

</html>