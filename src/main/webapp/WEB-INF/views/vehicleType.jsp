
<! DOCTYPE html>  
<html>  
<head>  
<meta charset = "utf-8">  
        <meta name = "viewport" content = "width=device-width, initial-scale = 1.0">  
        <title>Vehicle Type </title>  
        <link rel = "stylesheet" href = "https://codepen.io/gymratpacks/pen/VKzBEp#0">  
        <link href = 'https://fonts.googleapis.com/css?family=Nunito:400,300' rel = 'stylesheet' type = 'text/css'>  
<link rel = "stylesheet"  
        href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">  
<style>  
/* @import url(https://fonts.googleapis.com/css?family=Lato:400,700,900,300);  
@import url(http://weloveiconfonts.com/api/?family=fontawesome);  
* { box-sizing: border-box; }   */



.loginbox{
    width: 500px;
    height: 6a00px;
   background: rgba(0, 0, 0, 0.5);
    color: white;
    margin: 100px auto;
    border-radius: 10px;
    
}
    
body{
    /*   background-image: url(https://s.wsj.net/public/resources/images/BN-JD551_tankre_GR_20150629115603.jpg); */
       /* background-image: url(https://golookup-live.s3.amazonaws.com/images/R4yXLjG3JeW5WoaOG6m8so0fC1do3MdaKycRgqSV.jpeg);  */
       background-image: url(https://live.staticflickr.com/4738/25126612978_8deceae368_b.jpg);  
   
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
          background-size: cover;
       
      }

input[type="text"] {  
  width: 50%;  
  border: 2px solid #aaa;  
  border-radius: 4px;  
  margin: 8px 0px ;  
  outline: none;  
  padding: 8px;  
  box-sizing:border-box;  
  transition: 0.3s;  
}  
h3 {  
  text-align: center;  
  font-weight: normal;  
  color: rgb(255, 255, 255);  
  text-transform: uppercase;  
  font-size: 1em;  
  white-space: nowrap;  
  font-size: 2vw;  
  z-index: 1000;  
  font-family: 'Bangers', cursive;  
  /* text-shadow: 5px 5px 0 rgba(0, 0, 0, 0.7);   */
  @include skew(0, -6.7deg, false);  
  @include transition-property(font-size);  
  @include transition-duration(0.5s);   
}  
input[type="text"]:focus {  
  border-color: dodgerBlue;  
  box-shadow: 0 0 8px 0 dodgerBlue;  
}  
  
.inputWithIcon input[type="text"] {  
  padding-left: 40px;  
}  
  
.inputWithIcon {  
  position:relative;  
}  
  
.inputWithIcon i {  
  position: absolute;  
  left: 90;  
  top: 8px;  
  padding: 9px 8px;  
  color: rgb(255, 251, 251);  
  transition: 0.3s;  
}  
  
.inputWithIcon input[type="text"]:focus + i {  
  color: dodgerBlue;  
}  
  
.inputWithIcon.inputIconBg i {  
  background-color: #aaa;  
  color: #fff;  
  padding: 9px 4px;  
  border-radius: 6px 0 0 6px;  
}  
  
.inputWithIcon.inputIconBg input[type="text"]:focus + i {  
  color: #fff;  
  background-color: dodgerBlue;  
}  
  
 form {  
        position:relative;  
        width: 780px;  
        margin: 2% auto;  
        border: .5em solid lighten(deepskyblue, 30%);  
        border: .5em solid lighten(deepskyblue, 30%);  
        border: .5em solid lighten(deepskyblue, 30%);  
        border: .5em solid lighten(deepskyblue, 30%);  
        
} 
 form:before {  
        box-sizing: border-box;  
        display: block;  
        position: absolute;  
        width: 100%;  
        height: 100%;  
        border: .5em solid lighten(deepskyblue, 30%);  
        font-family: 'Permanent Marker', cursive;  
        font-size: 2.2em;  
        color: rgb(238, 238, 238);  
        text-align: center;  
         margin-bottom: 80px;  
        padding: 20px;  
}   
label {  
  text-align: center;  
  font-weight: normal;  
  color: #fff;  
  text-transform: uppercase;  
  font-size: 1em;  
  white-space: nowrap;  
  font-size: 1vw;  
  z-index: 1000;  
  font-family: 'Bangers', cursive;  
  text-shadow: 5px 5px 0 rgba(199, 190, 190, 0.7);  
  @include skew(0, -6.7deg, false);  
  @include transition-property(font-size);  
  @include transition-duration(0.5s);  
  margin-bottom: 80px;   
}  
.third {  
  border-color: 1px white;  
  color: rgb(159, 144, 144);  
  transition: all 150ms ease-in-out; 
 
  
}  
.third:hover {  
  box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;  
}  

  .btn {  
  box-sizing: border-box;  
  -webkit-appearance: none;  
     -moz-appearance: none;  
          appearance: none;  
  background-color: rgb(255, 253, 253);  
  border: 2px solid white;  
  border-radius: 0.6em;  
  color: rgb(8, 8, 8);  
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
.head{
    font-weight: bolder;
        font-style:oblique;
		color: rgb(255, 255, 255);;
}
    </style>  
</head>  
    
<body>  
    <br>
    <br>
    <br>
  
    <center>  
        <form action="/vehicleType/${id}" method="post">
            <br>
            <div class="loginbox">
           <center><h2 class="head">Vehicle Type </h2></center><br>  
           
           <br>
           <br>

     <div class = "inputWithIcon">  
            <select id = "vehicleList" name = "vehicleType" value="${vehicleType}" style="color: rgb(129, 8, 89) ; background-color: rgb(219, 233, 231); width: 105px; height: 30px; font-size: 20px;" >
					
                <option value = "NONE">Select</option>
                <option value = "2Wheeler">2Wheeler</option>
                <option value = "3Wheeler">3Wheeler</option>
                <option value = "4Wheeler">4Wheeler</option>
             
           </select>
     </div>
            
<br>
<br>

<table>
    <tr>
        <!-- <td><input class="btn third" type="submit" name="submit"
            value="Submit"></td> -->
            <td><input class="btn third" type="submit" name="submit" value="submit"></td>
    </tr>
</table>
<br>
        </form>  
    </center>  
  </div>
</body>  
  </html>  