<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">  
    <title>Home</title>

    <style>
       #imgs{        
        position: relative;  
        height:100%;
        width:100%;
        opacity:0.5;
      }
      .head{
        position: absolute;
        top:20%;
        width:100%;
        text-align: center;
        font-size: 100px;
  
        color: rgb(0, 0, 0);
        font-weight: bolder;
        font-style:italic;
      }
      .desc{
        position:absolute;
        top:60%;
        width:100%;
        left:13%;
        text-align: center;
        font-size: 40px;
        color: rgb(255, 255, 255);
      }
      .play{
        position:absolute;
        top:40%;
        left:43%;
        color:black;
        font-weight: bolder;
        font-style: italic;
        font-size: 20px;
      }
      .admin{
        width:200px;
        height:25px;
      }

     .btn {  
  box-sizing: border-box;  
  -webkit-appearance: none;  
     -moz-appearance: none;  
          appearance: none;  
  background-color: transparent;  
  border: 2px solid white;  
  border-radius: 0.6em;  
  color: white;  
  cursor: pointer;  
  display: flex;  
  align-self: center;  
  font-size: 1rem;  
  font-weight: 400;  
  line-height: 1;  
  margin: 20px;  
  padding: 1.2em 2.8em;  
  text-decoration: none;  
  text-align: center;  
  text-transform: uppercase;  
  font-family: "Montserrat", sans-serif;  
  font-weight: 700;  
}  
.btn:hover, .btn:focus {  
  color: #fff;  
  outline: 0;  
}  
      
       

.btn {  
  box-sizing: border-box;  
  -webkit-appearance: none;  
     -moz-appearance: none;  
          appearance: none;  
  background-color: rgb(255, 255, 255);  
  border: 2px solid white;  
  border-radius: 0.6em;  
  color: rgb(0, 0, 0);  
  cursor: pointer;  
  display: flex;  
  align-self: center;  
  font-size: 1rem;  
  font-weight: 400;  
  line-height: 1;  
  margin: 20px;  
  padding: 1.2em 2.8em;  
  text-decoration: none;  
  text-align: center;  
  text-transform: uppercase;  
  font-family: "Montserrat", sans-serif;  
  font-weight: 700;  
}  
.btn:hover, .btn:focus {  
  color: rgb(14, 13, 13);  
  outline: 0;  
}  
.third {  
  border-color: 2px white;  
  color: rgb(7, 7, 7);  
  transition: all 150ms ease-in-out;  
}  
.third:hover {  
  box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;  
}  
      
background-repeat: no-repeat;
        background-attachment: fixed;
           background-position: center center;
           background-size: cover;
      height: 100%;
    

 padding: 5px;
  width: 100%;}
  

    </style>
</head>
<body>
  
    <center><h2 class="head">Smart Vehicle</h2></center>

    <center><form class="play" action="/admin" method="get">
      <table>
      <tr>
          <td><input class="btn third"  type="submit" name="submit" value="RTO OFFICER"/><br>
            
      </div> 
    </form></td>
      <td><form class="desc" action="/userlogin" method="get">
     <input class="btn third" type="submit" name="submit" value="USER"/><br>
     </form></td> 
      </tr>
    </table>
       </center>

</div>  
</body>
</html>