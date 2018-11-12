<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Counselor-Personal</title>
</head>
<script type="text/javascript">

function hidingDetails(value){
	if(value == 1){
		document.getElementById('counselorEditableDetails').style.display = "none";
		document.getElementById('counselorUneditableDetails').style.display = "block";
	}else{
		document.getElementById('counselorEditableDetails').style.display = "block";
		document.getElementById('counselorUneditableDetails').style.display = "none";
		var fname = $("#counselorFname").val();var lname = $("#counselorLname").val();var address = $("#counselorAddress").val();var phone = $("#counselorPhone").val();
		var gender = $("#counselorGender").val();var email = $("#counselorEmail").val();var id = $("#counselorId").val();
		
		$("#EcounselorId").val(id);$("#EcounselorFname").val(fname);$("#EcounselorLname").val(lname);$("#EcounselorAddress").val(address);$("#EcounselorPhone").val(phone);
		$("#EcounselorGender").val(gender);$("#EcounselorEmail").val(email);
	}
}

function updatingCounselorDetails(){
	var address = $("#EcounselorAddress").val();var phone = $("#EcounselorPhone").val();var gender = $("#EcounselorGender").val();var id = $("#EcounselorId").val();
	var urls = "updateCounselorProfile?id="+id+"&address="+address+"&phone="+phone+"&gender="+gender;
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
							<%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="user-image" alt="User Image"> --%>
							<c:if test="${counsellor.id > 0}">
							<img src="getImage?id=${counsellor.id}" class="user-image"
								alt="User Image">
						</c:if> <c:if test="${counsellor.id == null}">
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
								<c:if test="${counsellor.id > 0}">
								<img src="getImage?id=${counsellor.id}" class="img-circle"
									alt="User Image">
							</c:if> <c:if test="${counsellor.id == null}">
								<img
									src="<c:url value='/resources/bootstrap/images/dummy.png' />"
									class="img-circle" alt="User Image">
							</c:if>
								<p>${register.fullname}<small>Member since ${register.sDate}</small></p>
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
		            <c:if test="${counsellor.id > 0}">
		           	 	<img src="getImage?id=${counsellor.id}" class="img-circle" alt="User Image">
		           	 </c:if>
		           	 <c:if test="${counsellor.id == null}">
		           	 	<img src="<c:url value='/resources/bootstrap/images/dummy.png' />" class="img-circle" alt="User Image">
		           	 </c:if>
		            </div>
		            <div class="pull-left info"><p>${register.fullname}</p><a href="#"><i class="fa fa-circle text-success"></i> ${register.vStatus}</a></div>
		          </div>
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="treeview active"><a href="counselorBasic?id=${register.id}&roleId=${register.roleId}"><span>Personal</span></a></li>
					<li class="treeview"><a href="counselorProfile?id=${register.id}&roleId=${register.roleId}"><span>Description</span></a></li>
					<li class="treeview"><a href="counselorForum?id=${register.id}&roleId=${register.roleId}"><span>Chat Forum</span></a></li>
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
                <div id="counselorEditableDetails" style="display: none;">
	                <!-- form start -->
	                <form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="EcounselorId"  disabled value="">
	                      <input type="hidden" class="form-control" id="EcounselorRoleId" disabled value="3">
	                      <label>First Name</label>
	                      <input type="text" class="form-control" id="EcounselorFname" placeholder="Firstname" disabled value="">
	                      <label>Last Name</label>
	                      <input type="text" class="form-control" id="EcounselorLname" placeholder="Lastname" disabled value="">
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="EcounselorEmail" placeholder="Email" disabled value="">
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="EcounselorAddress" placeholder="Address" value="">
	                      <label>Gender</label>
	                      <input type="text" class="form-control" id="EcounselorGender" placeholder="Gender" value="">
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="EcounselorPhone" placeholder="Phone" value="">
	                    </div>
	                  </div><!-- /.box-body -->
	                  <div class="box-footer">
	                    <button style="float: right;margin-left: 2%" type="button" class="btn btn-success" onclick="updatingCounselorDetails()">Update</button>
	                    <button style="float: right;" type="button" class="btn btn-danger" onclick="hidingDetails(1)">Cancel</button>
	                  </div>
	                </form>
                </div>
                <div id="counselorUneditableDetails" style="display: block;">
                	<form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="counselorId" placeholder="id" disabled value="${register.id}">
	                      <input type="hidden" class="form-control" id="counselorRoleId" placeholder="id" disabled value="1">
	                      <label>First Name</label>
	                      <input type="text" class="form-control" id="counselorFname" placeholder="Firstname" value="${register.fName}" disabled>
	                      <label>Last Name</label>
	                      <input type="text" class="form-control" id="counselorLname" placeholder="Lastname" value="${register.lName}" disabled>
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="counselorEmail" placeholder="Email" value="${register.email}" disabled>
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="counselorAddress" placeholder="Address" value="${register.location}" disabled>
	                      <label>Gender</label>
	                      <input type="text" class="form-control" id="counselorGender" placeholder="Gender" value="${register.gender}" disabled >
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="counselorPhone" placeholder="Phone" value="${register.phone}" disabled>
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