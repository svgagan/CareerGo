<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Company-Profile Details</title>
</head>

<script type="text/javascript">
function hidingDetails(value){
	if(value == 1){
		document.getElementById('companyEditableDetails').style.display = "none";
		document.getElementById('companyUneditableDetails').style.display = "block";
	}else{
		document.getElementById('companyEditableDetails').style.display = "block";
		document.getElementById('companyUneditableDetails').style.display = "none";
		/* var id = $("#counselorId").val();var exp = $("#dExperience").val();var des = $("#dDescription").val();
		$("#coId").val(id);$("#cExperience").val(exp);$("#cDescription").val(des); */
		
	}
}

function updatingcompanyDetails(){
	var address = $("#EcompanyAddress").val();var phone = $("#EcompanyPhone").val();var id = $("#EcompanyId").val();
	var urls = "updateCompanyProfile?id="+id+"&address="+address+"&phone="+phone;
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
							<c:if test="${company.id > 0}">
							<img src="getCompanyImage?id=${company.id}" class="user-image"
								alt="User Image">
						</c:if> <c:if test="${company.id == null}">
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
								<c:if test="${company.id > 0}">
								<img src="getCompanyImage?id=${company.id}" class="img-circle"
									alt="User Image">
							</c:if> <c:if test="${company.id == null}">
								<img
									src="<c:url value='/resources/bootstrap/images/dummy.png' />"
									class="img-circle" alt="User Image">
							</c:if>
								<p>${register.lName}<small>Member since ${register.sDate}</small></p>
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
		            <div class="pull-left image" style="height: 45px;"><%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="img-circle" alt="User Image"> --%>
		            	<c:if test="${company.id > 0}">
		           	 	<img src="getCompanyImage?id=${company.id}" class="img-circle" alt="User Image">
		           	 </c:if>
		           	 <c:if test="${company.id == null}">
		           	 	<img src="<c:url value='/resources/bootstrap/images/dummy.png' />" class="img-circle" alt="User Image">
		           	 </c:if>
		            </div>
		            <div class="pull-left info"><p>${register.lName}</p><a href="applicantProfile"><i class="fa fa-circle text-success"></i> ${register.vStatus}</a></div>
		          </div>
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="active"><a href="companyProfile?id=${register.id}&roleId=${register.roleId}"><span>Profile</span></a></li>
					<li><a href="companyDetails?id=${register.id}&roleId=${register.roleId}"><span>Description</span></a></li>
					<li class="treeview"><a href="#"><span>Jobs</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="companyJobs?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Job Posting</a></li>
							<li><a href="companyApplication?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Applications Received</a></li>
							<li><a href="companyReview?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Reviews</a></li>
						</ul>
					</li>
				</ul>
				</section>
			<!-- /.sidebar -->
			</aside>

			<!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header"><h1>Company Details</h1></section>
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
                <div id="companyEditableDetails" style="display: none;">
	                <!-- form start -->
	                <form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="EcompanyId"  disabled value="${register.id}">
	                      <input type="hidden" class="form-control" id="EcompanyRoleId" disabled value="2">
	                      <label>Company Name</label>
	                      <input type="text" class="form-control" id="Ecompanyname" placeholder="CompanyName" disabled value="${register.lName}">
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="EcompanyEmail" placeholder="Email" disabled value="${register.email}">
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="EcompanyAddress" placeholder="Address" value="${register.location}">
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="EcompanyPhone" placeholder="Phone" value="${register.phone}">
	                    </div>
	                  </div><!-- /.box-body -->
	                  <div class="box-footer">
	                    <button style="float: right;margin-left: 2%" type="button" class="btn btn-success" onclick="updatingcompanyDetails()">Update</button>
	                    <button style="float: right;" type="button" class="btn btn-danger" onclick="hidingDetails(1)">Cancel</button>
	                  </div>
	                </form>
                </div>
                <div id="companyUneditableDetails" style="display: block;">
                	<form role="form">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <input type="hidden" class="form-control" id="companyId" placeholder="id" disabled value="${register.id}">
	                      <input type="hidden" class="form-control" id="companyRoleId" placeholder="id" disabled value="2">
	                      <label>Company Name</label>
	                      <input type="text" class="form-control" id="companyname" placeholder="CompanyName" value="${register.lName}" disabled>
	                      <label>Email</label>
	                      <input type="email" class="form-control" id="companyEmail" placeholder="Email" value="${register.email}" disabled>
	                      <label>Address</label>
	                      <input type="text" class="form-control" id="companyAddress" placeholder="Address" value="${register.location}" disabled>
	                      <label>Phone Number</label>
	                      <input type="text" class="form-control" id="companyPhone" placeholder="Phone" value="${register.phone}" disabled>
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
