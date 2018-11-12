<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Admin-Test Grade Details</title>
</head>

<script type="text/javascript">

function saveGradeTest(){
	var testId = $("#testId").val();
	var marks = $("#marks").val();
	$.post("GradeTest",{testId : testId,marks : marks},function(data) 
	{
		if(data){
			toastr.success("Grades Updated Successfully");
			window.location.reload(true);
		}
		else{
			toastr.warning("Failed To Updated Grades");
		}
	});
}

function GradeTest(testId){
	$("#testId").val(testId);
	$("#gradeModal").modal();
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
							<img src="<c:url value='/resources/bootstrap/images/dummy.png' />" class="user-image" alt="User Image">
							<span class="hidden-xs">Settings <i class="fa fa-gears"></i></span>
						</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header">
								<img src="<c:url value='/resources/bootstrap/images/dummy.png' />" class="img-circle" alt="User Image">
								<p>${register.fullname}<small>Member since ${register.sDate}</small></p>
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
							<div class="pull-left">
								<button href="#" onclick="resetPassword()" title="Reset Password" class="btn btn-warning btn-flat">Reset Password</button>
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
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<c:url value='/resources/bootstrap/images/dummy.png' />" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>${register.fullname}</p>
              <a href="#"><i class="fa fa-circle text-success"></i>Admin</a>
            </div>
          </div>
          <!-- search form -->
          <!-- <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form> -->
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
              <a href="adminProfile?id=${register.id}&roleId=${register.roleId}">
                <span>Profile</span>
                 <i class="fa pull-right"></i>
                 </a>
            </li>
            <li class="treeview">
              <a href="adminApplicant?id=${register.id}&roleId=${register.roleId}">
                <span>Applicant</span>
                <span class="label label-primary pull-right"></span>
              </a>
            </li>
            <li class="treeview">
              <a href="adminCompany?id=${register.id}&roleId=${register.roleId}">
                <span>Company</span>
              </a>
            </li>
            <li class="treeview">
              <a href="adminCounselor?id=${register.id}&roleId=${register.roleId}">
                <span>Counselor</span>
              </a>
            </li>
             <li class="treeview">
              <a href="adminReview?id=${register.id}&roleId=${register.roleId}">
                <span>Company Review</span>
              </a>
            </li>
            <li class="treeview active"><a href="#"><span>Test</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="adminTest?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Tests</a></li>
					<li class="active"><a href="adminTestGrade?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Grade</a></li>
				</ul>
			</li>
			</ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header"><h1>Test Grading Details</h1></section>
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
                <div class="box-body" id="showExam" style="display: block;">
                  <table id="tests" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">TestInfoId</th>
                      	<th style="display:none;">RegistrationId</th>
                      	<th style="display:none;">TestId</th>
                        <th>Applicant</th>
                        <th>TestName</th>
                        <th>Submitted Date</th>
                        <th>Marks</th>
                      </tr>
                    </thead>
                    <tbody id="testDetails">
                      <c:forEach items="${testList}" var="testList">
                      	<tr>
                      		<td style="display:none;">${testList.id}</td>
                      		<td style="display:none;">${testList.registerId}</td>
                      		<td style="display:none;">${testList.testId}</td>
							<td>${testList.fullname}</td>
							<td>${testList.testname}</td>
							<td>${testList.sDate}</td>
							<td>${testList.marks}</td>
						    <td style="cursor: pointer;">
						    	<a href="${testList.url}" target="_blank"><span title="click to View" class="label label-info">View</span></a>
						    	<span title="click to Grade" onclick="GradeTest(${testList.id});" class="label label-success">Grade</span>
						    </td>
						    <%-- <c:if test="${testList.verified == true}">
						    <td style="cursor: pointer;">
						    	<span title="click to View" onclick="viewTest(${testList.id});" class="label label-info">View</span>
						    </td>
						    </c:if> --%>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div><!-- /.box-body -->
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
    $('#tests').dataTable({
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
    
    <div id="gradeModal" class="modal modal-success">
       <div class="modal-dialog">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
             <h4 class="modal-title">Grade</h4>
           </div>
           <div class="modal-body">
			<div class="form-group">
				<div>
					<input type="hidden" id="testId" />
                    <label>Marks [out of 100]</label>
                    <textarea class="form-control" id="marks" placeholder="Marks"></textarea>
                 </div>
			</div>
			</div>
           <div class="modal-footer">
           	<button style="margin-left: 10%;" class="btn btn-default" type="button" onclick="saveGradeTest()">Send</button>
             <button type="button" class="btn btn-danger " data-dismiss="modal">Cancel</button>
           </div>
         </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
    </div>
 
</body>
</html>