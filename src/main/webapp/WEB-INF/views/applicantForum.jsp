<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Applicant-Forum</title>
</head>
<script type="text/javascript">

function saveMessages(){
	//alert("Incoming");
	  $.ajax({
        type: "POST", 
        url: "saveMessages",
        data: $("#messagesForum").serialize(), 
        dataType: "json",
        success: function(data) 
        {
        	if(data.flag){
        		toastr.success(data.message);
        		location.reload();
        	}else{
        		toastr.warning(data.message);
        	}        }          
   });
}

function viewMessage(forumId){
	//alert(registerId+" ->"+forumId);
	$.post("viewAllResponses",{forumId : forumId},function(data) 
	{
		$("#responses").empty();
		var row = null;
		$.each(data,function(id, datalist) 
		{
			row = '<tr><td>'+datalist.firstname +'</td><td>'+datalist.sDate +'</td><td>'+datalist.message+'</td></tr>';
			$("#responses").append(row);
		 });
	});
	$("#viewResponseModal").modal();
}

function deleteMessage(forumId){
	$.post("deleteMessage",{forumId : forumId},function(data) 
	{
		if(data.flag){
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
					<li><a href="applicantProjects?id=${register.id}&roleId=${register.roleId}"><span>Projects</span></a></li>
					<li><a href="applicantWork?id=${register.id}&roleId=${register.roleId}"><span>Experience</span></a></li>
					<li><a href="applicantDocument?id=${register.id}&roleId=${register.roleId}"><span>Documents</span></a></li>
					<li class="active"><a href="applicantForum?id=${register.id}&roleId=${register.roleId}"><span>Chat Forum</span></a></li>
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
        <section class="content-header"><h1>Forum Details</h1></section>
        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-success">
                <div class="box-header with-border">
                  <i class="fa fa-comments-o"></i>
                  <h3 class="box-title">Details</h3>
                  <div class="box-tools pull-right" data-toggle="tooltip" title="Online">
                    <div class="btn-group" data-toggle="btn-toggle" >
                      <button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-green"></i></button>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body chat">
                 <form:form action="saveTextMessage" method="post" commandName="messagesForum" >
                  <div>
                    <form:input type="hidden" class="form-control" path="registerId" value="${register.id}"/>
                    <form:input type="hidden" class="form-control" path="roleId" value="${register.roleId}"/>
                    <label>Subject</label>
                    <form:input type="text" class="form-control" path="subject" placeholder="Subject" />
                    <label>Message</label>
                    <form:textarea class="form-control" path="message" placeholder="Type message..."/>
                    <div class="input-group-btn">
                      <button style="float:right;" class="btn btn-success" type="button" onclick="saveMessages()">Send</button>
                    </div>
                  </div>
                </form:form>
                <div>
                	<table id="messages" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">messageId</th>
                      	<th style="display:none;">registerId</th>
                        <th>Subject</th>
                        <th>Message</th>
                        <th>Status</th>
                        <th>Date</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody id="messageDetails">
                      <c:forEach items="${messageList}" var="messageList">
                      	<tr>
                      		<td style="display:none;">${messageList.forumId}</td>
                      		<td style="display:none;">${messageList.registerId}</td>
							<td>${messageList.subject}</td>
							<td>${messageList.message}</td>
							<td>${messageList.vStatus}</td>
							<td>${messageList.sDate}</td>
							<c:if test="${messageList.responseStatus == true}">
								<td style="cursor: pointer;">
								<span title="click to View" onclick="viewMessage(${messageList.forumId});" class="label label-info">View Responses</span>
						    	<span title="click to Delete" onclick="deleteMessage(${messageList.forumId});" class="label label-danger">Delete</span>
								</td>
							</c:if>
							<c:if test="${messageList.responseStatus == false}">
						    <td style="cursor: pointer;">
						    	<span title="click to Delete" onclick="deleteMessage(${messageList.forumId});" class="label label-danger">Delete</span>
						    </td>
						    </c:if>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
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
    $('#messages').dataTable({
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
    
    <div id="viewResponseModal" class="modal modal-info">
       <div class="modal-dialog">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
             <h4 class="modal-title"><i class="fa fa-comments-o"></i> Reply</h4>
           </div>
           <div class="modal-body">
			<div class="form-group">
				<div>
                    <table class="table table dataTable">
                    <thead>
                    	<tr><th>From</th><th>Date</th><th>Message</th></tr>
                    </thead>
                    <tbody id="responses"></tbody>
                    </table>
                 </div>
			</div>
			</div>
           <div class="modal-footer">
             <button type="button" class="btn btn-danger " data-dismiss="modal">Close</button>
           </div>
         </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
    </div>

  </body>
</html>