<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Company-Rating Details</title>
</head>
<script type="text/javascript">



function report(reviewId){
	$.post("reportReviews",{reviewId : reviewId},function(data) 
	{
		if(data){
			toastr.error("Reported to Career Go Professionals");
			//window.location.reload(true);
		}
		else{
			toastr.warning("Failed To Report");
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
							<li><a href="companyJobs?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Job Posting</a></li>
							<li><a href="companyApplication?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Applications Received</a></li>
							<li class="active"><a href="companyReview?id=${register.id}&roleId=${register.roleId}"><i class="fa fa-circle-o"></i> Reviews</a></li>
						</ul>
					</li>
				</ul>
				</section>
			<!-- /.sidebar -->
			</aside>

			<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header"><h1>Review Details</h1></section>
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
                <div class="box-body" id="JobUDetails" style="display: block;">
                    <c:if test="${overallRate == 0}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/zero.PNG' />" class="user-image" alt="0/5"></h3></td>
					</c:if>
                    <c:if test="${overallRate == 1}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/one.PNG' />" class="user-image" alt="1/5"></h3></td>
					</c:if>
					<c:if test="${overallRate == 2}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/two.PNG' />" class="user-image" alt="2/5"></h3></td>
					</c:if>
					<c:if test="${overallRate == 3}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/three.PNG' />" class="user-image" alt="3/5"></h3></td>
					</c:if>
					<c:if test="${overallRate == 4}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/four.PNG' />" class="user-image" alt="4/5"></h3></td>
					</c:if>
					<c:if test="${overallRate == 5}">
						<td style="width:10%;"><h3>Overall Ratings  : <img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/five.PNG' />" class="user-image" alt="5/5"></h3></td>
					</c:if>
                  <table id="review" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;width:1%;">reviewId</th>
                        <th style="width:10%;">Applicant</th>
                        <th style="width:10%;">Comments</th>
                        <th style="width:10%;">Rate</th>
                        <th style="width:10%;">Is it abusive?</th>
                      </tr>
                    </thead>
                    <tbody id="reviewDetails">
                      <c:forEach items="${reviewList}" var="reviewList">
                      	<tr>
                      		<td style="display:none;width:1%;">${reviewList.rateId}</td>
							<td style="width:10%;">${reviewList.title}</td>
							<td style="width:10%;">${reviewList.comments}</td>
							<c:if test="${reviewList.stars == 1}">
								<td style="width:10%;"><img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/one.PNG' />" class="user-image" alt="1/5"></td>
							</c:if>
							<c:if test="${reviewList.stars == 2}">
								<td style="width:10%;"><img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/two.PNG' />" class="user-image" alt="2/5"></td>
							</c:if>
							<c:if test="${reviewList.stars == 3}">
								<td style="width:10%;"><img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/three.PNG' />" class="user-image" alt="3/5"></td>
							</c:if>
							<c:if test="${reviewList.stars == 4}">
								<td style="width:10%;"><img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/four.PNG' />" class="user-image" alt="4/5"></td>
							</c:if>
							<c:if test="${reviewList.stars == 5}">
								<td style="width:10%;"><img style="height: 20px;" src="<c:url value='/resources/bootstrap/images/five.PNG' />" class="user-image" alt="5/5"></td>
							</c:if>
							<td style="width:10%;">
								<span style="cursor: pointer;" onclick="report(${reviewList.rateId});" class="label label-warning">Report</span>
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
    $('#review').dataTable({
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
