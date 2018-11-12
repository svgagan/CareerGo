<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Applicant-Projects Details</title>
</head>

<script>

function hidingProjectDetails(value){
	if(value == 1){
		document.getElementById('projectTable').style.display = "none";
		document.getElementById('projectForm').style.display = "block";
	}else{
		document.getElementById('projectTable').style.display = "block";
		document.getElementById('projectForm').style.display = "none";
	}
}

/* function saveProjectDetails(){
	  $.ajax({
        type: "POST", 
        url: "updateProjectDetails",
        data: $("#projects").serialize(), 
        dataType: "json",
        success: function(data) 
        {
        	if(data.flag){
        		toastr.success(data.message);
        		location.reload();
        	}else{
        		toastr.warning(data.message);
        	}
        }          
   });
} */

function editProjects(event,pId){
	//alert(eId);
	var cells = $(event).closest("tr").children("td");
	var title = cells.eq(2).text();
	var descp = cells.eq(3).text();
	var team = cells.eq(4).text();
	var url = cells.eq(5).text();
	var sdate = cells.eq(6).text();//alert(sdate);
	var edate = cells.eq(7).text();//alert(edate);
	$("#projectId").val(pId);$("#title").val(title);$("#description").val(descp);$("#teams").val(team);$("#url").val(url);
	$("#startYear").val(sdate);$("#endYear").val(edate);
	hidingProjectDetails(1);
}

function deleteProjects(pId){
	$.post("deleteProjectDetail",{pId : pId},function(data) 
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

<body class="hold-transition skin-blue sidebar-mini">
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
		            <div class="pull-left info"><p>${register.fullname}</p><a href="applicantProfile"><i class="fa fa-circle text-success"></i> ${register.vStatus}</a></div>
		          </div>
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li><a href="applicantProfile?id=${register.id}&roleId=${register.roleId}"><span>Personal</span></a></li>
					<li><a href="applicantEducation?id=${register.id}&roleId=${register.roleId}"><span>Education</span></a></li>
					<li><a href="applicantSkills?id=${register.id}&roleId=${register.roleId}"><span>Skills</span></a></li>
					<li><a href="applicantCertification?id=${register.id}&roleId=${register.roleId}"><span>Certifications</span></a></li>
					<li class="active"><a href="applicantProjects?id=${register.id}&roleId=${register.roleId}"><span>Projects</span></a></li>
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
        <section class="content-header"><h1>Projects Details</h1></section>
        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Details</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <div class="box-body" id="projectTable" style="display:block;">
                  <button style="float: right;" type="button" class="btn btn-info" onclick="hidingProjectDetails(1)">Add</button>
                  <table id="projects" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;width:1%;">projectId</th>
                      	<th style="display:none;width:1%;">RegistrationId</th>
                        <th style="width:10%;">Project Title</th>
                        <th style="width:20%;">Description</th>
                        <th style="width:10%;">Team Members</th>
                        <th style="width:10%;">URL</th>
                        <th style="width:8%;">Start Date</th>
                        <th style="width:8%;">End Date</th>
                        <th style="width:10%;"></th>
                      </tr>
                    </thead>
                    <tbody id="projectDetails">
                      <c:forEach items="${projectsList}" var="projectList">
                      	<tr>
                      		<td style="display:none;width:1%;">${projectList.projectId}</td>
                      		<td style="display:none;width:1%;">${projectList.registerId}</td>
							<td style="width:10%;">${projectList.title}</td>
							<td style="width:20%;">${projectList.description}</td>
							<td style="width:10%;">${projectList.teams}</td>
							<td style="width:10%;">${projectList.url}</td>
							<td style="width:8%;">${projectList.startdate}</td>
							<td style="width:8%;">${projectList.enddate}</td>
							<td style="width:10%;">
								<span title="Click to Edit" style="cursor: pointer;" onclick="editProjects(this,${projectList.projectId});" class="label label-warning">Edit</span>
								<span title="Click to Delete" style="cursor: pointer;" onclick="deleteProjects(${projectList.projectId});" class="label label-danger">Delete</span>
							</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div><!-- /.box-body -->
                <div id="projectForm" style="display:none;">
                	<form:form action="updateProjectDetails" method="post" modelAttribute="projects">
		                  <div class="box-body">
		                    <div class="form-group">
		                      <form:input type="hidden" class="form-control" id="registrationId" path="registerId" value="${register.id}"/>
		                      <form:input type="hidden" class="form-control" id="status" path="status" value="true"/>
		                      <form:input type="hidden" class="form-control" id="projectId" path="projectId" value="0"/>
		                      <form:input type="hidden" class="form-control" id="roleId" path="roleId" value="${register.roleId}"/>	
		                      <label for="degree">Project Title</label>
		                      <form:input type="text" class="form-control" id="title" path="title" placeholder="Project Title" />
		                      <label for="major">Project Description</label>
		                      <form:textarea type="text" class="form-control" id="description" path="description" placeholder="Project Description" ></form:textarea>
		                      <label for="school" >Team Members</label>
		                      <form:input type="text" class="form-control" id="teams" path="teams" placeholder="Team Members" />
		                      <label for="school" >URL</label>
		                      <form:input type="text" class="form-control" id="url" path="url" placeholder="URL" />
		                      <label for="startYear">Start Date</label>
		                      <div class="input-group date" data-provide="datepicker">
    							<form:input type="text" path="startDate" id="startYear" class="form-control" placeholder="Start Date"/>
    							<div class="input-group-addon"><span class="fa fa-calendar"></span></div>
							  </div>
		                      <label for="endYear">End Date</label>
		                      <div class="input-group date" data-provide="datepicker">
    							<form:input type="text" path="endDate" id="endYear" class="form-control" placeholder="End Date"/>
    							<div class="input-group-addon"><span class="fa fa-calendar"></span></div>
							  </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                    <button style="float: right;margin-left: 2%;" type="submit" class="btn btn-success" >Submit</button>
		                    <button style="float: right;" type="button" class="btn btn-danger" onclick="hidingProjectDetails(2)">Cancel</button>
		                  </div>
                	</form:form>
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
   
<script type="text/javascript">

$(function () {
    $('#projects').dataTable({
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