<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Career Go</title>

<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/home.css'/>" type="text/css"/>
 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="<c:url value='/resources/bootstrap/js/Jquery.js'/>"></script>
<!-- Toastr Mesaages  -->
<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/toastr.css'/>" type="text/css"/>
<script src="<c:url value='/resources/bootstrap/js/toastr.js'/>"></script>
<script src="<c:url value='/resources/bootstrap/js/toastr.min.js'/>"></script>
</head>
<style>

</style>

<script>

//Roles Selector
function roleCheck(){
	var roleType = document.getElementById("roles").value;
    if(roleType == "1"){
       document.getElementById('applicant').style.display = "block";
       document.getElementById('company').style.display = "none";
       document.getElementById('counsellor').style.display = "none";
    }else if(roleType == "2"){
    	document.getElementById('applicant').style.display = "none";
        document.getElementById('company').style.display = "block";
        document.getElementById('counsellor').style.display = "none";
    }else{
    	document.getElementById('applicant').style.display = "none";
        document.getElementById('company').style.display = "none";
        document.getElementById('counsellor').style.display = "block";
    }
}

//Registration of Applicants, Companies and Counselors
function saveProfileDetails(){
	var roleId = document.getElementById("roles").value;
	var urls;
	if(roleId == 1){
		var fName=$("#afirstName").val();var lName=$("#alastName").val();var email=$("#aemail").val();var password=$("#apassword").val();
		var confirmpassword=$("#aconfirmpassword").val();var phone=$("#aphone").val();var location = $("#alocation").val();
		var gender=$('input[name=gender]:checked').val();
		urls = "saveProfile?roleId="+roleId+"&fName="+fName+"&lName="+lName+"&email="+email+"&password="+password+"&confirmpassword="+confirmpassword+"&phone="+phone+"&gender="+gender+"&location="+location;
	}else if(roleId == 2){
		var fName=null;var lName=$("#companyName").val();var email=$("#comemail").val();var password=$("#compassword").val();
		var confirmpassword=$("#comconfirmpassword").val();var phone=$("#comphone").val();var location=$("#comlocation").val();var gender = null;
		urls = "saveProfile?roleId="+roleId+"&fName="+fName+"&lName="+lName+"&email="+email+"&password="+password+"&confirmpassword="+confirmpassword+"&phone="+phone+"&gender="+gender+"&location="+location;
	}else{
		var fName=$("#cfirstName").val();var lName=$("#clastName").val();var email=$("#cemail").val();var password=$("#cpassword").val();
		var confirmpassword=$("#cconfirmpassword").val();var phone=$("#cphone").val();var gender=$("#cgender").val();var location = $("#clocation").val();
		var gender=$('input[name=gender]:checked').val();
		urls = "saveProfile?roleId="+roleId+"&fName="+fName+"&lName="+lName+"&email="+email+"&password="+password+"&confirmpassword="+confirmpassword+"&phone="+phone+"&gender="+gender+"&location="+location;
	}
	$.ajax({
        type: "POST", 
        url : urls, 
        success: function(data) 
        {
        	if(data.flag == true){
        		toastr.warning(data.message);//alert("Registration Successfull");
        		window.location.reload(true);
        	}else{
        		toastr.warning(data.message);//alert(data.message);
        	}
        }          
   });
	//data: $("#keyValueDto").serialize(), 
    //dataType: "json",
}

//Login 
function loginCheck(){
	var userId=$("#username").val();var password=$("#password").val();
	var urls = "validateUser?username="+userId+"&password="+password;
	$.ajax({
        type: "POST", 
        url: urls, 
        success: function(data){
        	if(data.flag == true){
        		toastr.success(data.message);//alert("Login Successfull");
        		if(data.roleId == 1){
        			window.location.replace("applicantProfile?id="+data.id+"&roleId="+data.roleId);//window.open("login");//location.reload(true);
        		}else if(data.roleId == 2){
        			window.location.replace("companyProfile?id="+data.id+"&roleId="+data.roleId);//window.open("login");//location.reload(true);
        		}else if(data.roleId == 3){
        			window.location.replace("counselorBasic?id="+data.id+"&roleId="+data.roleId);//window.open("login");//location.reload(true);
        		}else if(data.roleId == 4){
        			window.location.replace("adminProfile?id="+data.id+"&roleId="+data.roleId);//window.location="sendRequestedOrder?bulkOrderId="+bulkOrderId+"&storeQueueId="+storeQueueId;
        		}else{
        			toastr.warning("Email Not Exists");
        		}
        	}else{
        		toastr.warning(data.message);//alert(data.message);
        	}
        }          
   });
}



//Forgot Password
function forgotPassword() {
	window.location.replace("forgotPasswordFile");
}

</script>
 
<!-- method="post" action="validateUser" --> 
<body  style="background-image:url(/CareerGo/resources/bootstrap/images/background.jpg);background-repeat: no-repeat;">

<!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top" style="line-height:0px; height:0px;width:0px;">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="login"><img src="<c:url value='/resources/bootstrap/images/CareerGoLogo.png' />" style="max-width:180px; margin-top: 0px;"><span style="display: inline-block;"></span></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-right" style="float:right;">         
            <form class="navbar-form navbar-right" >
              <div class='form-group'>
                  <input type='text' class='form-control' id='username' name='username' path='username' placeholder='Email' /> 
                  <input type='password' class='form-control' id='password' name='password' path='password' placeholder='Password' />
              	  <button type='button' class='btn btn-primary' onclick="loginCheck()">Login</button>
              	  <a href="forgotPasswordFile" tabindex="5" class="forgot-password" onclick="forgotPassword()" style="color: black;">Forgot Password?</a>
              </div>
          </form>
        </div>
      </div>
    </nav>

 <!-- method="post" action="saveProfile" modelAttribute="keyValueDto" -->
	<div class="container" style="width: 500px; height: 520px; display:block;" >
		<div class="jumbotron">
			<!-- <div id="loginSuccess" role="alert" class="alert alert-warning alert-dismissible fade show"><p>Login Successfull</p></div> -->
			<h2 style="color:black;">Discover what's Possible</h2>
			<label class="roles" >Role*</label>
			<select class="form-control" id="roles" onchange="roleCheck()" >
			    <option value="1">Applicant</option>
			    <option value="2">Company</option>
			    <option value="3">Counselor</option>
			</select><br>
			<div id="applicant" style="display:block;">
	            <form  class="form-horizontal" role="form" style="width:710px;height: 680px;" >
	            	<div class="form-group">
	            		<div class="col-sm-6">
	            		<input type="hidden" id="aroletype" value="1" name="roleId" path="roleId" />
	            		<label for="firstname" class="firstname" >First Name*</label>
	            		<input type="text" id="afirstName" placeholder="First Name" name="fName" class="form-control" path="fName"/><br>
	            		<label for="lastname" class="lastname" >Last Name*</label>
	            		<input type="text" id="alastName" placeholder="Last Name" name="lName" class="form-control" path="lName" /><br>
	            		<label for="email" class="email">Email*</label>
	            		<input type="email" id="aemail" placeholder="Email" class="form-control" name="email" path="email" /><br>
	            		<label for="address" class="address">Address</label>
	            		<input type="address" id="alocation" placeholder="Address" class="form-control" name="location" path="location" /><br>
	            		<label for="password" class="password">Password*</label>
	            		<input type="password" id="apassword" placeholder="Password" class="form-control" name="password" min="8" path="password"/><br>
	            		<label for="cpassword" class="cpassword">Confirm Password*</label>
	            		<input type="password" id="aconfirmpassword" placeholder="Confirm Password" class="form-control" name="confirmpassword" min="8" path="confirmpassword"/><br>
	            		<label for="phone" class="phone">Phone No.</label>
	            		<input type="number" id="aphone" placeholder="Phone Number" class="form-control" name="phone" maxlength="13" path="phone" /><br>
	            		<label class="gender">Gender</label><br>
	            		<label class="radio-inline"><input type="radio" path="gender" name="gender" value="Male"/>Male</label>
	            		<label class="radio-inline"><input type="radio" path="gender" name="gender" value="Female"/>Female</label><br><br>
	                    <label for="register" class="forgot-password" style="color:red;">* Mandatory Fields</label> <br/> 
	                	<label for="register" class="register">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href="#">User Agreement</a>,<a href="#"> Privacy Policy</a>, and <a href="#">Cookie Policy</a> -->
	            		<button type="button" class="btn btn-primary btn-block" onclick="saveProfileDetails()">Register</button>
	            		</div>
	            	</div>
	            </form>
            </div>
            
            <div id="counsellor" style="display:none;">
	            <form class="form-horizontal" role="form" style="width:710px;height: 680px;" >
	            	<div class="form-group">
	            		<div class="col-sm-6">
	            		<input type="hidden" id="croletype" value="3" name="roleId" path="roleId"/>
	            		<label for="firstname" class="firstname" >First Name*</label>
	            		<input type="text" id="cfirstName" placeholder="First Name" name="fName" class="form-control" path="fName" /><br>
	            		<label for="lastname" class="lastname" >Last Name*</label>
	            		<input type="text" id="clastName" placeholder="Last Name" name="lName" class="form-control" path="lName" /><br>
	            		<label for="email" class="email">Email*</label>
	            		<input type="email" id="cemail" placeholder="Email" class="form-control" name="email" path="email" /><br>
	            		<label for="address" class="address">Address</label>
	            		<input type="text" id="clocation" placeholder="Address" class="form-control" name="location" path="location" /><br>
	            		<label for="password" class="password">Password*</label>
	            		<input type="password" id="cpassword" placeholder="Password" class="form-control" name="password" path="password" min="8"/><br>
	            		<label for="cpassword" class="cpassword">Confirm Password*</label>
	            		<input type="password" id="cconfirmpassword" placeholder="Confirm Password" class="form-control" name="confirmpassword" path="confirmpassword" min="8"/><br>
	            		<label for="phone" class="phone">Phone No.</label>
	            		<input type="number" id="cphone" placeholder="Phone Number" class="form-control" maxlength="13" name="phone" path="phone" /><br>
	            		<label class="gender">Gender</label><br>
	            		<label class="radio-inline"><input type="radio" path="gender" name="gender" value="Male"/>Male</label>
	            		<label class="radio-inline"><input type="radio" path="gender" name="gender" value="Female"/>Female</label><br><br>
	                    <label for="register" class="forgot-password" style="color:red;">* Mandatory Fields</label> <br/> 
	                	<label for="register" class="register">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href="#">User Agreement</a>,<a href="#"> Privacy Policy</a>, and <a href="#">Cookie Policy</a> -->
	            		<button type="button" class="btn btn-primary btn-block" onclick="saveProfileDetails()">Register</button>
	            		</div>
	            	</div>
	            </form>
            </div>
            
            <div id="company" style="display:none;">
	            <form class="form-horizontal" role="form" style="width:710px;height: 620px;" >
	            	<div class="form-group">
	            		<div class="col-sm-6">
	            		<input type="hidden" id="comroletype" value="2" name="roleId" path="roleId"/>
	            		<label for="companyname" class="lastname" >Company Name*</label>
	            		<input type="text" id="companyName" placeholder="company Name" name="lName" class="form-control" path="companyName" /><br>
	            		<label for="email" class="email">Email*</label>
	            		<input type="email" id="comemail" placeholder="Email" class="form-control" name="email" path="email" /><br>
	            		<label for="password" class="password">Password*</label>
	            		<input type="password" id="compassword" placeholder="Password" class="form-control" name="password" path="password" min="8"/><br>
	            		<label for="cpassword" class="cpassword">Confirm Password*</label>
	            		<input type="password" id="comconfirmpassword" placeholder="Confirm Password" class="form-control" name="confirmpassword" path="confirmpassword" min="8"/><br>
	            		<label for="phone" class="phone">Phone No.</label>
	            		<input type="number" id="comphone" placeholder="Phone Number" class="form-control" maxlength="13" name="phone" path="phone" /><br>
	            		<label for="location" class="location">Location</label>
	            		<input type="text" id="comlocation" placeholder="Location" class="form-control" name="location" path="location" /><br>
	                    <label for="register" class="forgot-password" style="color:red;">* Mandatory Fields</label> <br/> 
	                	<label for="register" class="register">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href="#">User Agreement</a>,<a href="#"> Privacy Policy</a>, and <a href="#">Cookie Policy</a> -->
	            		<button type="button" class="btn btn-primary btn-block" onclick="saveProfileDetails()">Register</button>
	            		</div>
	            	</div>
	            </form>
            </div>
       </div> 
	</div>
      
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>