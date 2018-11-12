<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Applicant-Profile Details</title>
</head>
<script type="text/javascript">


/* $( document ).ready(function() {
	long registerId = (long) request.getAttribute("applicant");
	alert(registerId);
	$.get("getProfilePhoto?id="+registerId, function(data){
		//console.log(data);
	    if(data == 0 || data == null || data == '' || data.length == 1){
	    	$('#pPhoto').attr('src', './resources/bootstrap/images/dummy.png');
	    }else{
	    	$('#pPhoto').attr('src', "getProfilePhoto?id="+register.id);
	    }
	});
}); */

function hidingDetails(value){
	if(value == 1){
		document.getElementById('applicantEditableDetails').style.display = "none";
		document.getElementById('applicantUneditableDetails').style.display = "block";
	}else{
		document.getElementById('applicantEditableDetails').style.display = "block";
		document.getElementById('applicantUneditableDetails').style.display = "none";
		var fname = $("#applicantFname").val();var lname = $("#applicantLname").val();var address = $("#applicantAddress").val();var phone = $("#applicantPhone").val();
		var gender = $("#applicantGender").val();var email = $("#applicantEmail").val();var id = $("#applicantId").val();
		
		$("#EapplicantId").val(id);$("#EapplicantFname").val(fname);$("#EapplicantLname").val(lname);$("#EapplicantAddress").val(address);$("#EapplicantPhone").val(phone);
		$("#EapplicantGender").val(gender);$("#EapplicantEmail").val(email);
	}
}

function updatingApplicantDetails(){
	var address = $("#EapplicantAddress").val();var phone = $("#EapplicantPhone").val();var gender = $("#EapplicantGender").val();var id = $("#EapplicantId").val();
	var urls = "updateApplicantProfile?id="+id+"&address="+address+"&phone="+phone+"&gender="+gender;
	$.ajax({
        type: "POST", 
        url: urls, 
        success: function(data) 
        {
        	if(data.flag == true){
        		toastr.success(data.message);window.location.reload(true);
        	}else{
        		toastr.warning(data.message);
        	}
        }          
   });
}
</script>
<body class="skin-blue sidebar-mini wysihtml5-supported">
		<div class="wrapper">
			<header class="main-header">
					<!-- Logo -->
				<a href="#" class="logo">
					<span class="logo-lg"><img src="<c:url value='/resources/bootstrap/images/CareerGoLogo.png' />" ></span>
				</a>
				<!-- Header Navbar: style can be found in header.less -->
				<nav class="navbar navbar-static-top" role="navigation">
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<%-- <img id="pPhoto" src="<c:url value='/resources/bootstrap/images/male.png' />" class="user-image" alt="User Image"> --%>
							<c:if test="${docs.id > 0}">
							<img src="getProfilePhoto?id=${register.id}" class="user-image"
								alt="User Image">
						</c:if> <c:if test="${docs.id == null}">
							<img
								src="<c:url value='/resources/bootstrap/images/dummy.png' />"
								class="user-image" alt="User Image">
						</c:if>
							<span class="hidden-xs">Settings <i class="fa fa-gears"></i></span>
						</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header">
								<%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="img-circle" alt="User Image"> --%>
								<c:if test="${docs.id > 0}">
							<img src="getProfilePhoto?id=${register.id}" class="img-circle"
								alt="User Image">
						</c:if> <c:if test="${docs.id == null}">
							<img
								src="<c:url value='/resources/bootstrap/images/dummy.png' />"
								class="img-circle" alt="User Image">
						</c:if>
								<p>${register.fullname}<small>Member since ${register.sDate}</small>
								<small><b>${register.hits}</b> companies viewed your profile</small></p>
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
							<div class="pull-left">
								<button title="Reset Password" onclick="resetPassword()" class="btn btn-warning btn-flat">Reset Password</button>
							</div>
							<div class="pull-right">
								<a href="login" title="Logout" class="btn btn-danger btn-flat">Logout</a>
							</div>
							</li>
						</ul>
						</li>
					</ul>
					</div>
				</nav>
			</header>
			
			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
				<section class="sidebar">
		          <!-- Sidebar user panel -->
		          <div class="user-panel">
		            <div class="pull-left image" style="height: 45px;">
		            <%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="img-circle" alt="User Image"> --%>
		            <c:if test="${docs.id > 0}">
							<img src="getProfilePhoto?id=${register.id}" class="img-circle"
								alt="User Image">
						</c:if> <c:if test="${docs.id == null}">
							<img
								src="<c:url value='/resources/bootstrap/images/dummy.png' />"
								class="img-circle" alt="User Image">
						</c:if>
		            </div>
		            <div class="pull-left info"><p>${register.fullname}</p><a href="#"><i class="fa fa-circle text-success"></i> ${register.vStatus}</a></div>
		          </div>
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="active"><a href="applicantProfile?id=${register.id}&roleId=${register.roleId}"><span>Personal</span></a></li>
					<li><a href="applicantEducation?id=${register.id}&roleId=${register.roleId}"><span>Education</span></a></li>
					<li><a href="applicantSkills?id=${register.id}&roleId=${register.roleId}"><span>Skills</span></a></li>
					<li><a href="applicantCertification?id=${register.id}&roleId=${register.roleId}"><span>Certifications</span></a></li>
					<li><a href="applicantProjects?id=${register.id}&roleId=${register.roleId}"><span>Projects</span></a></li>
					<li><a href="applicantWork?id=${register.id}&roleId=${register.roleId}"><span>Experience</span></a></li>
					<li><a href="applicantDocument?id=${register.id}&roleId=${register.roleId}"><span>Documents</span></a></li>
					<li><a href="applicantForum?id=${register.id}&roleId=${register.roleId}"><span>Chat Forum</span></a></li>
					<li class="treeview"><a href="#"><span>Jobs</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="applicantJobLists?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Jobs Available</a></li>
							<li><a href="applicantJobApplied?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Jobs Applied</a></li>
							<li><a href="applicantReview?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Company Review</a></li>
						</ul>
					</li>
					<li class="treeview"><a href="#"><span>Test</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="applicantTest?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Tests Available</a></li>
							<li><a href="applicantTestGrade?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Tests Completed</a></li>
						</ul>
					</li>
				</ul>
				</section>
			<!-- /.sidebar -->
			</aside>


      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header"><h1>Personal Details</h1></section>
        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title">Details</h3>
                </div><!-- /.box-header -->
                <div id="applicantEditableDetails" style="display: none;">
	                <!-- form start -->
	                <form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="EapplicantId" placeholder="id" disabled value="">
	                      <input type="hidden" class="form-control" id="EapplicantRoleId" placeholder="id" disabled value="1">
	                      <label>First Name</label>
	                      <input type="text" class="form-control" id="EapplicantFname" placeholder="Firstname" disabled value="">
	                      <label>Last Name</label>
	                      <input type="text" class="form-control" id="EapplicantLname" placeholder="Lastname" disabled value="">
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="EapplicantEmail" placeholder="Email" disabled value="">
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="EapplicantAddress" placeholder="Address" value="">
	                      <label>Gender</label>
	                      <input type="text" class="form-control" id="EapplicantGender" placeholder="Gender" value="">
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="EapplicantPhone" placeholder="Phone" value="">
	                    </div>
	                  </div><!-- /.box-body -->
	                  <div class="box-footer">
	                    <button style="float: right;margin-left: 2%" type="button" class="btn btn-success" onclick="updatingApplicantDetails()">Update</button>
	                    <button style="float: right;" type="button" class="btn btn-danger" onclick="hidingDetails(1)">Cancel</button>
	                  </div>
	                </form>
                </div>
                <div id="applicantUneditableDetails" style="display: block;">
                	<form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="applicantId" placeholder="id" disabled value="${register.id}">
	                      <input type="hidden" class="form-control" id="applicantRoleId" placeholder="id" disabled value="1">
	                      <label>First Name</label>
	                      <input type="text" class="form-control" id="applicantFname" placeholder="Firstname" value="${register.fName}" disabled>
	                      <label>Last Name</label>
	                      <input type="text" class="form-control" id="applicantLname" placeholder="Lastname" value="${register.lName}" disabled>
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="applicantEmail" placeholder="Email" value="${register.email}" disabled>
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="applicantAddress" placeholder="Address" value="${register.location}" disabled>
	                      <label>Gender</label>
	                      <input type="text" class="form-control" id="applicantGender" placeholder="Gender" value="${register.gender}" disabled >
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="applicantPhone" placeholder="Phone" value="${register.phone}" disabled>
	                    </div>
	                  </div><!-- /.box-body -->
	                  <div class="box-footer">
	                    <button style="float: right;" type="button" class="btn btn-info" onclick="hidingDetails(2)">Edit</button>
	                  </div>
	                </form>
                </div>
              </div><!-- /.box -->
		      <div > 
		      </div>
			</div>
		</div>
	</section>
      <!-- Control Sidebar -->
   </div><!-- ./wrapper -->
   <footer class="main-footer">
   	<strong>Copyright &copy; 2017-2018 <a href="#">Career Go</a>.&nbsp;</strong>
     <div class="pull-right hidden-xs">
     	 All rights reserved.
     </div>
   </footer>
</div>
	
	<!-- Modals  -->
	<div id="ResetPasswordModal" class="modal">
       <div class="modal-dialog">
         <div class="modal-content">
         	<form class="form">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
             <h4 class="modal-title">Reset Password</h4>
           </div>
           <div class="modal-body">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
					 <input type="email" path="email" id="email" name="email" placeholder="Confirm Email" class="form-control" /><br> 
					 <input	type="password" placeholder="New Password" id="password" name="password" class="form-control" min="8" path="password" /><br>
					 <input type="password" placeholder="Confirm Password" id="confirmpassword" name="confirmpassword" class="form-control" min="8" path="confirmpassword" /><br>
				</div>
			</div>
			</div>
           <div class="modal-footer">
           	<button type="button" class="btn btn-primary" onclick="updatePassword()">Update</button>
             <button type="button" class="btn btn-danger " data-dismiss="modal">Cancel</button>
           </div>
           </form>
         </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
    </div>
	
		
  </body>
</html>
