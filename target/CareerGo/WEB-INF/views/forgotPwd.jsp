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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="<c:url value='/resources/bootstrap/js/Jquery.js'/>"></script>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/toastr.css'/>" type="text/css"/>
<script src="<c:url value='/resources/bootstrap/js/toastr.js'/>"></script>
<script src="<c:url value='/resources/bootstrap/js/toastr.min.js'/>"></script>
</head>
<script type="text/javascript">

//Update Password
function updatePassword() {
	var email=$("#email").val();var password=$("#password").val();var confirmpassword=$("#confirmpassword").val();
	var urls = "forgotPassword?email="+email+"&password="+password+"&confirmpassword="+confirmpassword;
	$.ajax({
        type: "POST", 
        url: urls, 
        success: function(data) 
        {
        	if(data.flag == true){
        		toastr.success(data.message);//alert("Updated Successfull");
        		window.location.replace("login");//window.open("login");
        	}else{
        		toastr.warning(data.message);//alert(data.message);
        		//window.location.reload(true);
        	}
        }          
   });	
}

function cancel(){
	window.location.replace("login");
}

</script>
<body style="background-image:url(/CareerGo/resources/bootstrap/images/background.jpg);background-repeat: no-repeat;">
<nav class="navbar navbar-default navbar-static-top" style="line-height:0px; height:0px;width:0px;">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="login"><img src="<c:url value='/resources/bootstrap/images/CareerGoLogo.png' />" style="max-width:180px; margin-top: 0px;"><span style="display: inline-block;"></span></a>
        </div>
      </div>
</nav>
<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                          <h3><i class="fa fa-lock fa-4x"></i></h3>
                          <h2 class="text-center">Forgot Password?</h2>
                          <p>You can reset your password here.</p>
                            <div class="panel-body">
                              
                              <form class="form">
                                <fieldset>
                                  <div class="form-group">
                                    <div class="input-group">
                                      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                      <input type="email" path="email" id="email" name="email" placeholder="Email" class="form-control" /><br>
                                      <input type="password" placeholder="New Password" id="password" name="password" class="form-control" min="8" path="password"/><br>
                                      <input type="password" placeholder="Confirm Password" id="confirmpassword" name="confirmpassword" class="form-control" min="8" path="confirmpassword"/><br>
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <button onclick="updatePassword()" class="btn btn-lg btn-primary btn-block" type="button">Update Password</button>
                                    <button onclick="cancel()" class="btn btn-lg btn-danger btn-block" type="button">Cancel</button>
                                  </div>
                                </fieldset>
                              </form>
                              
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>