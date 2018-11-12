<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Company-Jobs Details</title>
</head>
<script type="text/javascript">

function hidingJobDetails(value){
	if(value == 1){
		document.getElementById('JobUDetails').style.display = "none";
		document.getElementById('jobEDetails').style.display = "block";
	}else{
		document.getElementById('JobUDetails').style.display = "block";
		document.getElementById('jobEDetails').style.display = "none";
	}
}

function updatingjobDetails(){
	var jobType = $("#jobType").val();
	if(jobType > 0){
	  $.ajax({
        type: "POST", 
        url: "updateJobPostsDetails",
        data: $("#job").serialize(), 
        dataType: "json",
        success: function(data) 
        {
        	toastr.success("Jobs Details Updated Successfully");
        	location.reload();
        }          
   });
	}else{
		toastr.warning("Select Job Type");
	}
}

function deleteJob(jobId){
	$.post("deleteJobPost",{jobId : jobId},function(data) 
	{
		if(data){
			toastr.success(data.message);
			window.location.reload(true);
		}
		else{
			toastr.warning(data.message);
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
		            <div class="pull-left image" style="height: 45px;">
		            <%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="img-circle" alt="User Image"> --%>
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
					<li><a href="companyProfile?id=${register.id}&roleId=${register.roleId}"><span>Profile</span></a></li>
					<li><a href="companyDetails?id=${register.id}&roleId=${register.roleId}"><span>Description</span></a></li>
					<li class="treeview active"><a href="#"><span>Jobs</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li class="active"><a href="companyJobs?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Job Posting</a></li>
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
        <section class="content-header"><h1>Job Posting Details</h1></section>
        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-warning">
                <div class="box-header with-border">
                  <h3 class="box-title">Details</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
               	<div class="box-body" id="jobEDetails" style="display: none;">
	                <!-- form start -->
	                <form:form action="#" method="post" modelAttribute="job">
	                  <div class="box-body">
	                    <div class="form-group">
	                      <form:input type="hidden" class="form-control" path="registerId" id="EcompanyId"  value="${register.id}" />
	                      <form:input type="hidden" class="form-control" path="roleId" id="EcompanyRoleId" value="2" />
	                      <form:input type="hidden" class="form-control" path="jobId" id="EcompanyJobId" value="0" />
	                      <label>Job Title</label>
	                      <form:input type="text" class="form-control" path="title" id="EjobTitle" placeholder="Job Title" value=""/>
	                      <label>Job Description</label>
	                      <form:textarea type="text" class="form-control" id="EjobDesc" path="description" placeholder="Description" value=""  />
	                      <label>Job Location</label>
	                      <form:input type="text" class="form-control" path="address" id="EjobLocation" placeholder="Location" value=""/>
	                      <label>Salary</label>
	                      <form:input type="text" class="form-control" path="salary" id="EjobSalary" placeholder="Salary" value=""/>
	                      <label>Contact Phone</label>
	                      <form:input type="text" class="form-control" path="phone" id="EjobPhone" placeholder="Phone" value=""/>
	                      <label>Contact Email</label>
	                      <form:input type="email" class="form-control" path="email" id="EjobEmail" placeholder="Email" value=""/>
	                      <label>Job Type</label>
	                      <form:select class="form-control" onchange="" name="jobType" path="jobTypeId" id="jobType">
							<option value="-1" selected>Select Job Type</option>
							<form:options items="${jobType}" itemValue="id" itemLabel="jobType" />
						  </form:select>
	                    </div>
	                  </div><!-- /.box-body -->
	                  <div class="box-footer">
	                    <button style="float: right;margin-left: 2%" type="button" class="btn btn-success" onclick="updatingjobDetails()">Update</button>
	                    <button style="float: right;" type="button" class="btn btn-danger" onclick="hidingJobDetails(2)">Cancel</button>
	                  </div>
	                </form:form>
                </div>
                <div class="box-body" id="JobUDetails" style="display: block;">
                	<button style="float: right;" type="button" class="btn btn-info" onclick="hidingJobDetails(1)">Add</button>
                  <table id="jobs" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;width:1%;">jobId</th>
                      	<th style="display:none;width:1%;">companyId</th>
                      	<th style="display:none;width:1%;">jobTypeId</th>
                        <th style="width:10%;">Title</th>
                        <th style="width:20%;">Description</th>
                        <th style="width:10%;">Location</th>
                        <th style="width:10%;">Salary</th>
                        <th style="width:10%;">Phone</th>
                        <th style="width:10%;">Email</th>
                        <th style="width:10%;">Job Type</th>
                        <th style="width:10%;">Date</th>
                        <th style="width:10%;"></th>
                      </tr>
                    </thead>
                    <tbody id="jobsDetails">
                      <c:forEach items="${jobsList}" var="jobsList">
                      	<tr>
                      		<td style="display:none;width:1%;">${jobsList.jobId}</td>
                      		<td style="display:none;width:1%;">${jobsList.registerId}</td>
                      		<td style="display:none;width:1%;">${jobsList.jobTypeId}</td>
							<td style="width:10%;">${jobsList.title}</td>
							<td style="width:20%;">${jobsList.description}</td>
							<td style="width:10%;">${jobsList.address}</td>
							<td style="width:10%;">${jobsList.salary}</td>
							<td style="width:10%;">${jobsList.phone}</td>
							<td style="width:10%;">${jobsList.email}</td>
							<td style="width:10%;">${jobsList.jobType}</td>
							<td style="width:10%;">${jobsList.sDate}</td>
							<td style="width:10%;">
								<%-- <span style="cursor: pointer;" onclick="editJobs(this,${jobsList.jobId});" class="label label-warning">Edit</span> --%>
								<span style="cursor: pointer;" onclick="deleteJob(${jobsList.jobId});" class="label label-danger">Delete</span>
							</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
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

 </div><!-- ./wrapper -->
 
 <script type="text/javascript">

$(function () {
    $('#jobs').dataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });

</script>
 
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
