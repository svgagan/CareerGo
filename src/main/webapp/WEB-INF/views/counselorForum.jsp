<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Career Go | Counselor-Forum</title>
</head>
<script type="text/javascript">

function response(forumId){
	$("#chatId").val(forumId);
	$("#saveResponseModal").modal();
}

function saveReplyMessages(){
	//alert("Incoming");
	  $.ajax({
        type: "POST", 
        url: "saveReply",
        data: $("#replyForum").serialize(), 
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
}

function viewResponse(forumId,registerId){
	//alert(registerId+" ->"+forumId);
	$.post("viewResponses",{forumId : forumId,registerId : registerId},function(data) 
	{
		$("#responses").empty();
		var row = null;
		$.each(data,function(id, datalist) 
		{
			row = '<tr><td>'+datalist.sDate +'</td><td>'+datalist.message+'</td></tr>';
			$("#responses").append(row);
		 });
	});
	$("#viewResponseModal").modal();
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
					<li class="treeview"><a href="counselorBasic?id=${register.id}&roleId=${register.roleId}"><span>Personal</span></a></li>
					<li class="treeview"><a href="counselorProfile?id=${register.id}&roleId=${register.roleId}"><span>Description</span></a></li>
					<li class="treeview active"><a href="counselorForum?id=${register.id}&roleId=${register.roleId}"><span>Chat Forum</span></a></li>
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
                <div class="box-body chat" id="chat-box">
                 <%-- <form:form action="saveTextMessage" method="post" commandName="messagesForum" >
                  <div class="input-group">
                    <form:input type="hidden" class="form-control" path="registerId" value="${register.id}"/>
                    <form:input type="hidden" class="form-control" path="roleId" value="${register.roleId}"/>
                    <form:input type="text" class="form-control" path="subject" placeholder="Subject" />
                    <form:textarea class="form-control" path="message" placeholder="Type message..."/>
                    <div class="input-group-btn">
                      <button style="margin-left: 10%;" class="btn btn-success" type="button" onclick="saveMessages()">Send</button>
                    </div>
                  </div>
                </form:form> --%>
                <div>
                	<table id="cMessages" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">messageId</th>
                      	<th style="display:none;">applicantId</th>
                        <th>From</th>
                        <th>Subject</th>
                        <th>Message</th>
                        <th>Status</th>
                        <th>Received</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody id="messageDetails">
                      <c:forEach items="${messageList}" var="messageList">
                      	<tr>
                      		<td style="display:none;">${messageList.forumId}</td>
                      		<td style="display:none;">${messageList.registerId}</td>
							<td>${messageList.name}</td>
							<td>${messageList.subject}</td>
							<td>${messageList.message}</td>
							<td>${messageList.vStatus}</td>
							<td>${messageList.sDate}</td>
							<c:if test="${messageList.responseStatus == true}">
								<td style="cursor: pointer;">
								<span title="click to Reply" onclick="response(${messageList.forumId});" class="label label-success">Reply</span>
						    	<span title="click to View" onclick="viewResponse(${messageList.forumId},${register.id});" class="label label-info">View</span>
								</td>
							</c:if>
							<c:if test="${messageList.responseStatus == false}">
						    <td style="cursor: pointer;">
						    	<span title="click to Reply" onclick="response(${messageList.forumId});" class="label label-success">Reply</span>
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
    $('#cMessages').dataTable({
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
    
    <div id="saveResponseModal" class="modal modal-success">
       <div class="modal-dialog">
         <div class="modal-content">
         	<form:form action="saveReply" method="post" commandName="replyForum" >
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
             <h4 class="modal-title"><i class="fa fa-comments-o"></i> Reply</h4>
           </div>
           <div class="modal-body">
			<div class="form-group">
				<div>
                    <form:input type="hidden" class="form-control" path="registerId" value="${register.id}"/>
                    <form:input type="hidden" class="form-control" path="roleId" value="${register.roleId}"/>
                    <form:input type="hidden" class="form-control" id="chatId" path="forumId" value=""/>
                    <label>Message</label>
                    <form:textarea class="form-control" path="message" placeholder="Type message..."/>
                 </div>
			</div>
			</div>
           <div class="modal-footer">
           	<button style="margin-left: 10%;" class="btn btn-default" type="button" onclick="saveReplyMessages()">Send</button>
             <button type="button" class="btn btn-danger " data-dismiss="modal">Cancel</button>
           </div>
           </form:form>
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
                    	<tr><th>Date</th><th>Message</th></tr>
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