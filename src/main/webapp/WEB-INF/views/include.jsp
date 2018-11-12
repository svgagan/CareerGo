<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">

$(document).ready(function () {
    
    $('.datepicker').datepicker({
        format: 'mm/dd/yyyy',
        startDate: '-3d',
        autoclose: true,
    });

});

//Open Reset Password modal
function resetPassword(){
	$("#ResetPasswordModal").modal();
}

//Updating Password after any user Logged in [Reset Password]
function updatePassword() {
	var email=$("#email").val();var password=$("#password").val();var confirmpassword=$("#confirmpassword").val();
	var urls = "forgotPassword?email="+email+"&password="+password+"&confirmpassword="+confirmpassword;
	$.ajax({
        type: "POST", 
        url: urls, 
        success: function(data) 
        {
        	if(data.flag == true){
        		toastr.success(data.message);window.location.reload(true);
        	}else{
        		toastr.warning(data.message);//alert(data.message);
        	}
        }          
   });	
}

</script>

<!-- ******************************************************** Style files*******************************************************  -->
	<!--<style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style>-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> <!-- Tell the browser to be responsive to screen width -->
	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" type="text/css"/><!-- Bootstrap 3.3.5 -->
	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/font-awesome.min.css'/>" type="text/css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"><!-- Font Awesome -->
	<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"><!-- Ionicons -->
	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/AdminLTE.min.css'/>" type="text/css"/> <!-- Theme style -->
	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/_all-skins.min.css'/>" type="text/css"/><!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/daterangepicker-bs3.css'/>" type="text/css"/><!-- daterange picker -->
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/toastr.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap3-wysihtml5.min.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/datepicker3.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/blue.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/jquery-jvectormap-1.2.2.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/morris.css'/>" type="text/css"/>
	
	
<!-- ******************************************************** Scripts files*******************************************************  -->
	<script src="<c:url value='/resources/bootstrap/js/jQuery-2.1.4.min.js'/>"></script>
	<script src="<c:url value='/resources/bootstrap/js/jquery-ui.min.js'/>"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script><!-- Bootstrap 3.3.5 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="<c:url value='/resources/bootstrap/js/daterangepicker.js'/>"></script><!-- daterangepicker -->
	<script src="<c:url value='/resources/bootstrap/js/bootstrap-datepicker.js'/>"></script> <!-- datepicker -->
	<script src="<c:url value='/resources/bootstrap/js/jquery.slimscroll.min.js'/>"></script> <!-- Slimscroll --> 
	<script src="<c:url value='/resources/bootstrap/js/app.min.js'/>"></script> <!-- AdminLTE App -->
    <script src="<c:url value='/resources/bootstrap/js/demo.js'/>"></script> <!-- AdminLTE for demo purposes -->
    <script src="<c:url value='/resources/bootstrap/js/dashboard.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/fastclick.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/select2.full.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.inputmask.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.inputmask.date.extensions.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.inputmask.extensions.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/toastr.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/toastr.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap3-wysihtml5.all.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.knob.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery-jvectormap-1.2.2.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery-jvectormap-world-mill-en.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.sparkline.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/dataTables.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/jquery.dataTables.min.js'/>"></script>
	  
