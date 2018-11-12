<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Career Go | Applicant Profile</title>
</head>
<script type="text/javascript">

function viewFile(docId){
	window.open("viewDocFile?docId="+docId);
}

</script>
<body class="hold-transition skin-blue"><!-- sidebar-collapse -->

    <div class="wrapper">
     <header class="main-header">
					<!-- Logo -->
				<a href="#" class="logo pull-left">
					<span class="logo-lg"><img src="<c:url value='/resources/bootstrap/images/CareerGoLogo.png' />" ></span>
				</a>
				<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
		         <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
		           <span class="sr-only">Toggle navigation</span>
		         </a>
          
					<!-- Navbar Right Menu -->
					<%-- <div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="<c:url value='/resources/bootstrap/images/male.png' />" class="user-image" alt="User Image">
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
						</li>
					</ul>
					</div> --%>
				</nav>
	</header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <div style="height:500px;">
              <!-- Profile Image -->
              <div class="box box-danger">
                <div class="box-body box-profile">
                	<%-- <img src="<c:url value='/resources/bootstrap/images/male.png' />" class="profile-user-img img-responsive img-circle" alt="User Image"> --%>
                	<c:if test="${docs.id > 0}">
							<img src="getProfilePhoto?id=${register.id}" class="profile-user-img img-responsive img-circle"
								alt="User Image">
						</c:if> <c:if test="${docs.id == null}">
							<img
								src="<c:url value='/resources/bootstrap/images/dummy.png' />"
								class="profile-user-img img-responsive img-circle" alt="User Image">
						</c:if>
                  <h3 class="profile-username text-center">${register.fullname}</h3>
                  <p class="text-muted text-center"><i class="fa fa-circle text-success"></i> ${register.vStatus}</p>
				  <div class="box-header with-border">
                  	<h3 class="box-title">About Me</h3>
                  </div><!-- /.box-header -->	
				  <div class="box-body">
						<strong><i class="fa fa-fw fa-venus-mars"></i> Gender</strong><!-- fa fa-fw fa-user -->
						<p class="text-muted">${register.gender}</p>
						<hr>
						<strong><i class="fa fa-fw fa-envelope-square"></i> Email</strong>
						<p class="text-muted">${register.email}</p>
						<hr>
						<strong><i class="fa fa-fw fa-phone"></i> Phone</strong>
						<p class="text-muted">${register.phone}</p>
						<hr>
						<strong><i class="fa fa-map-marker margin-r-5"></i>Address</strong>
						<p class="text-muted">${register.location}</p>
						<hr>
						<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>	
				</div><!-- /.box-body -->
              </div><!-- /.box -->
              </div>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
         <!-- Main content -->
        <section class="content">

          <div class="row">
            <div class="col-md-12">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#Education" data-toggle="tab">Education</a></li>
                  <li><a href="#Skills" data-toggle="tab" aria-expanded="true">Skills</a></li>
                  <li><a href="#Certification" data-toggle="tab" aria-expanded="true">Certification</a></li>
                  <li><a href="#Projects" data-toggle="tab" aria-expanded="true">Projects</a></li>
                  <li><a href="#WorkExperience" data-toggle="tab" aria-expanded="true">WorkExperience</a></li>
                  <li><a href="#Documents" data-toggle="tab" aria-expanded="true">Documents</a></li>
                  <li><a href="#Exercise" data-toggle="tab" aria-expanded="true">Exercise</a></li>
                </ul>
                <div class="tab-content">
                  <div class="active tab-pane" id="Education">
                  	<ul class="timeline timeline-inverse">
                      <!-- timeline time label -->
                      <li class="time-label">
                        <span class="bg-blue">Education</span>
                      </li>
                      <!-- timeline item -->
                      <li>
                        <i class="fa fa-fw fa-mortar-board bg-blue"></i>
                        <div class="timeline-item">
                          <h3 class="timeline-header"><a href="#">Education Details</h3>
                          <table id="education" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">educationId</th>
                      	<th style="display:none;">RegistrationId</th>
                      	<th style="display:none;">DegreeId</th>
                      	<th style="display:none;">MajorId</th>
                        <th>Degree</th>
                        <th>Major</th>
                        <th>University/School</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                      </tr>
                    </thead>
                    <tbody id="educationDetails">
                      <c:forEach items="${educationList}" var="educationList">
                      	<tr>
                      		<td style="display:none;">${educationList.educationId}</td>
                      		<td style="display:none;">${educationList.registerId}</td>
                      		<td style="display:none;">${educationList.degreeId}</td>
                      		<td style="display:none;">${educationList.majorId}</td>
							<td>${educationList.degreeName}</td>
							<td>${educationList.majorName}</td>
							<td>${educationList.school}</td>
							<td>${educationList.startdate}</td>
							<td>${educationList.enddate}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>	
                          <div class="timeline-footer">
                            <a class="btn btn-primary btn-xs"></a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <i class="fa fa-clock-o bg-blue"></i>
                      </li>
                     </ul>
                  </div>
                  <div class="tab-pane" id="Skills">
                  	<ul class="timeline timeline-inverse">
                      <!-- timeline time label -->
                      <li class="time-label">
                        <span class="bg-green">Skills</span>
                      </li>
                      <!-- timeline item -->
                      <li>
                        <i class="fa fa-pencil margin-r-5 bg-green"></i>
                        <div class="timeline-item">
                          <h3 class="timeline-header"><a href="#">Skills Acquired</h3>
                          <div>
	                          <p style="color: black;"> 
	                          ${skills.skills}
	                         </p>
						  </div>	
                          <div class="timeline-footer">
                            <a class="btn btn-success btn-xs"></a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <i class="fa fa-clock-o bg-green"></i>
                      </li>
                     </ul>
                  </div>
                  <div class="tab-pane" id="Certification">
                    <!-- The timeline -->
                    <ul class="timeline timeline-inverse">
                      <!-- timeline time label -->
                      <li class="time-label">
                        <span class="bg-red">
                          Certification
                        </span>
                      </li>
                      <!-- /.timeline-label -->
                      <!-- timeline item -->
                      <li>
                        <i class="glyphicon glyphicon-duplicate bg-red"></i>
                        <div class="timeline-item">
<!--                           <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>-->
                          <h3 class="timeline-header"><a href="#">User certifications</h3>
                          <table id="certificate" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">certificateId</th>
                      	<th style="display:none;">RegistrationId</th>
                        <th>Certification</th>
                        <th>Authority</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                      </tr>
                    </thead>
                    <tbody id="certificateDetails">
                      <c:forEach items="${certificateList}" var="certificateList">
                      	<tr>
                      		<td style="display:none;">${certificateList.id}</td>
                      		<td style="display:none;">${certificateList.registerId}</td>
							<td>${certificateList.certificate}</td>
							<td>${certificateList.authority}</td>
							<td>${certificateList.startdate}</td>
							<td>${certificateList.enddate}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                          <div class="timeline-footer">
                            <a class="btn btn-danger btn-xs"></a>
                          
                          </div>
                        </div>
                      </li>
                      <!-- END timeline item -->
                      <li>
                        <i class="fa fa-clock-o bg-red"></i>
                      </li>
                    </ul>
                  </div>
                  <div class="tab-pane" id="Projects">
                  	<ul class="timeline timeline-inverse">
                  	<li class="time-label">
                        <span class="bg-yellow">Projects</span>
                      </li>
                      <!-- timeline item -->
                      <li>
                      <i class="glyphicon glyphicon-blackboard bg-yellow"></i>
                        <div class="timeline-item">
                          <!-- <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span> -->
                          <h3 class="timeline-header"><a href="#">Projects Details</h3>
                          <div class="timeline-body">
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
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                          <div class="timeline-footer">
                            <a class="btn btn-warning btn-xs"></a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <i class="fa fa-clock-o bg-yellow"></i>
                      </li>
                      </ul>
                      <!-- END timeline item -->
                  </div>
                  <div class="tab-pane" id="WorkExperience">
                  	<ul class="timeline timeline-inverse">
                  	<li class="time-label">
                        <span class="bg-red">Work Experience</span>
                      </li>
                      <!-- timeline item -->
                      <li>
                        <i class="glyphicon glyphicon-briefcase bg-red"></i>
                        <div class="timeline-item">
                          <!-- <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span> -->
                          <h3 class="timeline-header"><a href="#">Work Experience Details</h3>
                          <div class="timeline-body">
                        <table id="work" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;width:1%;">workId</th>
                      	<th style="display:none;width:1%;">RegistrationId</th>
                        <th style="width:10%;">Job Position</th>
                        <th style="width:10%;">Company</th>
                        <th style="width:10%;">Location</th>
                        <th style="width:20%;">Description</th>
                        <th style="width:8%;">Start Date</th>
                        <th style="width:8%;">End Date</th>
                      </tr>
                    </thead>
                    <tbody id="workDetails">
                      <c:forEach items="${workList}" var="workList">
                      	<tr>
                      		<td style="display:none;width:1%;">${workList.id}</td>
                      		<td style="display:none;width:1%;">${workList.registerId}</td>
							<td style="width:10%;">${workList.position}</td>
							<td style="width:10%;">${workList.company}</td>
							<td style="width:10%;">${workList.address}</td>
							<td style="width:20%;">${workList.description}</td>
							<td style="width:8%;">${workList.startdate}</td>
							<td style="width:8%;">${workList.enddate}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                          <div class="timeline-footer">
                            <a class="btn btn-danger btn-xs"></a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <i class="fa fa-clock-o bg-red"></i>
                      </li>
                      </ul>
                      <!-- END timeline item -->
                  </div>
                  <div class="tab-pane" id="Documents">
                  	<ul class="timeline timeline-inverse">
                  	<li class="time-label">
                        <span class="bg-blue">Documents</span>
                      </li>
                      <!-- /.timeline-label -->
                      <!-- timeline item -->
                      <li>
                        <i class="glyphicon glyphicon-folder-open bg-blue"></i>
                        <div class="timeline-item">
                          <!-- <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span> -->
                          <h3 class="timeline-header"><a href="#">Documents Available</h3>
                          <div class="timeline-body">
                         <table id="documents" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">documentId</th>
                      	<th style="display:none;">documentTypeId</th>
                        <th>Document Type</th>
                        <th>Document Name</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody id="docDetails">
                      <c:forEach items="${docsList}" var="docsList">
                      	<tr>
                      		<td style="display:none;">${docsList.docId}</td>
                      		<td style="display:none;">${docsList.docTypeId}</td>
							<td>${docsList.position}</td>
							<td>${docsList.docName}</td>
						    <td style="cursor: pointer;">
						    	<span title="click to View" onclick="viewFile(${docsList.docId});" class="label label-info">View</span>
						    </td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                          <div class="timeline-footer">
                            <a class="btn btn-primary btn-xs"></a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <i class="fa fa-clock-o bg-blue"></i>
                      </li>
                      </ul>
                      <!-- END timeline item -->
                  </div>
                  <div class="tab-pane" id="Exercise">
                  	<ul class="timeline timeline-inverse">
                      <!-- timeline time label -->
                      <li class="time-label">
                        <span class="bg-green">
                          Exercise
                        </span>
                      </li>
                      <!-- /.timeline-label -->
                      <!-- timeline item -->
                      <li>
                        <i class="fa fa-book margin-r-5 bg-green"></i>
                        <div class="timeline-item">
<!--                           <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>-->
                          <h3 class="timeline-header"><a href="#">Exercise Details</h3>
                          <table id="tests" class="table table dataTable"><!--  table table-bordered table-hover dataTable -->
                    <thead class="no-sort">
                      <tr>
                      	<th style="display:none;">id</th>
                        <th>Exercise</th>
                        <th>Taken On</th>
                        <th>Marks</th>
                      </tr>
                    </thead>
                    <tbody id="testDetails">
                      <c:forEach items="${testList}" var="testList">
                      	<tr>
                      		<td style="display:none;">${testList.id}</td>
							<td>${testList.testname}</td>
							<td>${testList.sDate}</td>
							<td>${testList.marks}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>	
                          <div class="timeline-footer">
                            <a class="btn btn-success btn-xs"></a>
                          
                          </div>
                        </div>
                      </li>
                      <!-- END timeline item -->
                      <li>
                        <i class="fa fa-clock-o bg-green"></i>
                      </li>
                    </ul>
                  </div>
                </div><!-- /.tab-content -->
              </div><!-- /.nav-tabs-custom -->
            </div><!-- /.col -->
          </div><!-- /.row -->
    </div><!-- ./wrapper -->
	 <footer class="main-footer">
   	<strong>Copyright &copy; 2017-2018 <a href="#">Career Go</a>.&nbsp;</strong>
     <div class="pull-right hidden-xs">
     	 All rights reserved.
     </div>
   </footer>    
</div>
 

</body>
</html>