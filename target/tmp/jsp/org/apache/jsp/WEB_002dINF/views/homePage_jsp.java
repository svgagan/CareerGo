package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Career Go</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\"/>\r\n");
      out.write(" \r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<!-- Toastr Mesaages  -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("//Roles Selector\r\n");
      out.write("function roleCheck(){\r\n");
      out.write("\tvar roleType = document.getElementById(\"roles\").value;\r\n");
      out.write("    if(roleType == \"1\"){\r\n");
      out.write("       document.getElementById('applicant').style.display = \"block\";\r\n");
      out.write("       document.getElementById('company').style.display = \"none\";\r\n");
      out.write("       document.getElementById('counsellor').style.display = \"none\";\r\n");
      out.write("    }else if(roleType == \"2\"){\r\n");
      out.write("    \tdocument.getElementById('applicant').style.display = \"none\";\r\n");
      out.write("        document.getElementById('company').style.display = \"block\";\r\n");
      out.write("        document.getElementById('counsellor').style.display = \"none\";\r\n");
      out.write("    }else{\r\n");
      out.write("    \tdocument.getElementById('applicant').style.display = \"none\";\r\n");
      out.write("        document.getElementById('company').style.display = \"none\";\r\n");
      out.write("        document.getElementById('counsellor').style.display = \"block\";\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//Registration of Applicants, Companies and Counselors\r\n");
      out.write("function saveProfileDetails(){\r\n");
      out.write("\tvar roleId = document.getElementById(\"roles\").value;\r\n");
      out.write("\tvar urls;\r\n");
      out.write("\tif(roleId == 1){\r\n");
      out.write("\t\tvar fName=$(\"#afirstName\").val();var lName=$(\"#alastName\").val();var email=$(\"#aemail\").val();var password=$(\"#apassword\").val();\r\n");
      out.write("\t\tvar confirmpassword=$(\"#aconfirmpassword\").val();var phone=$(\"#aphone\").val();var location = $(\"#alocation\").val();\r\n");
      out.write("\t\tvar gender=$('input[name=gender]:checked').val();\r\n");
      out.write("\t\turls = \"saveProfile?roleId=\"+roleId+\"&fName=\"+fName+\"&lName=\"+lName+\"&email=\"+email+\"&password=\"+password+\"&confirmpassword=\"+confirmpassword+\"&phone=\"+phone+\"&gender=\"+gender+\"&location=\"+location;\r\n");
      out.write("\t}else if(roleId == 2){\r\n");
      out.write("\t\tvar fName=null;var lName=$(\"#companyName\").val();var email=$(\"#comemail\").val();var password=$(\"#compassword\").val();\r\n");
      out.write("\t\tvar confirmpassword=$(\"#comconfirmpassword\").val();var phone=$(\"#comphone\").val();var location=$(\"#comlocation\").val();var gender = null;\r\n");
      out.write("\t\turls = \"saveProfile?roleId=\"+roleId+\"&fName=\"+fName+\"&lName=\"+lName+\"&email=\"+email+\"&password=\"+password+\"&confirmpassword=\"+confirmpassword+\"&phone=\"+phone+\"&gender=\"+gender+\"&location=\"+location;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tvar fName=$(\"#cfirstName\").val();var lName=$(\"#clastName\").val();var email=$(\"#cemail\").val();var password=$(\"#cpassword\").val();\r\n");
      out.write("\t\tvar confirmpassword=$(\"#cconfirmpassword\").val();var phone=$(\"#cphone\").val();var gender=$(\"#cgender\").val();var location = $(\"#clocation\").val();\r\n");
      out.write("\t\tvar gender=$('input[name=gender]:checked').val();\r\n");
      out.write("\t\turls = \"saveProfile?roleId=\"+roleId+\"&fName=\"+fName+\"&lName=\"+lName+\"&email=\"+email+\"&password=\"+password+\"&confirmpassword=\"+confirmpassword+\"&phone=\"+phone+\"&gender=\"+gender+\"&location=\"+location;\r\n");
      out.write("\t}\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"POST\", \r\n");
      out.write("        url : urls, \r\n");
      out.write("        success: function(data) \r\n");
      out.write("        {\r\n");
      out.write("        \tif(data.flag == true){\r\n");
      out.write("        \t\ttoastr.warning(data.message);//alert(\"Registration Successfull\");\r\n");
      out.write("        \t\twindow.location.reload(true);\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\ttoastr.warning(data.message);//alert(data.message);\r\n");
      out.write("        \t}\r\n");
      out.write("        }          \r\n");
      out.write("   });\r\n");
      out.write("\t//data: $(\"#keyValueDto\").serialize(), \r\n");
      out.write("    //dataType: \"json\",\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//Login \r\n");
      out.write("function loginCheck(){\r\n");
      out.write("\tvar userId=$(\"#username\").val();var password=$(\"#password\").val();\r\n");
      out.write("\tvar urls = \"validateUser?username=\"+userId+\"&password=\"+password;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"POST\", \r\n");
      out.write("        url: urls, \r\n");
      out.write("        success: function(data){\r\n");
      out.write("        \tif(data.flag == true){\r\n");
      out.write("        \t\ttoastr.success(data.message);//alert(\"Login Successfull\");\r\n");
      out.write("        \t\tif(data.roleId == 1){\r\n");
      out.write("        \t\t\twindow.location.replace(\"applicantProfile?id=\"+data.id+\"&roleId=\"+data.roleId);//window.open(\"login\");//location.reload(true);\r\n");
      out.write("        \t\t}else if(data.roleId == 2){\r\n");
      out.write("        \t\t\twindow.location.replace(\"companyProfile?id=\"+data.id+\"&roleId=\"+data.roleId);//window.open(\"login\");//location.reload(true);\r\n");
      out.write("        \t\t}else if(data.roleId == 3){\r\n");
      out.write("        \t\t\twindow.location.replace(\"counselorBasic?id=\"+data.id+\"&roleId=\"+data.roleId);//window.open(\"login\");//location.reload(true);\r\n");
      out.write("        \t\t}else if(data.roleId == 4){\r\n");
      out.write("        \t\t\twindow.location.replace(\"adminProfile?id=\"+data.id+\"&roleId=\"+data.roleId);//window.location=\"sendRequestedOrder?bulkOrderId=\"+bulkOrderId+\"&storeQueueId=\"+storeQueueId;\r\n");
      out.write("        \t\t}else{\r\n");
      out.write("        \t\t\ttoastr.warning(\"Email Not Exists\");\r\n");
      out.write("        \t\t}\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\ttoastr.warning(data.message);//alert(data.message);\r\n");
      out.write("        \t}\r\n");
      out.write("        }          \r\n");
      out.write("   });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//Forgot Password\r\n");
      out.write("function forgotPassword() {\r\n");
      out.write("\twindow.location.replace(\"forgotPasswordFile\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write(" \r\n");
      out.write("<!-- method=\"post\" action=\"validateUser\" --> \r\n");
      out.write("<body  style=\"background-image:url(/CareerGo/resources/bootstrap/images/background.jpg);background-repeat: no-repeat;\">\r\n");
      out.write("\r\n");
      out.write("<!-- Static navbar -->\r\n");
      out.write("    <nav class=\"navbar navbar-default navbar-static-top\" style=\"line-height:0px; height:0px;width:0px;\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <a class=\"navbar-brand\" href=\"login\"><img src=\"");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("\" style=\"max-width:180px; margin-top: 0px;\"><span style=\"display: inline-block;\"></span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse navbar-right\" style=\"float:right;\">         \r\n");
      out.write("            <form class=\"navbar-form navbar-right\" >\r\n");
      out.write("              <div class='form-group'>\r\n");
      out.write("                  <input type='text' class='form-control' id='username' name='username' path='username' placeholder='Email' /> \r\n");
      out.write("                  <input type='password' class='form-control' id='password' name='password' path='password' placeholder='Password' />\r\n");
      out.write("              \t  <button type='button' class='btn btn-primary' onclick=\"loginCheck()\">Login</button>\r\n");
      out.write("              \t  <a href=\"forgotPasswordFile\" tabindex=\"5\" class=\"forgot-password\" onclick=\"forgotPassword()\" style=\"color: black;\">Forgot Password?</a>\r\n");
      out.write("              </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write(" <!-- method=\"post\" action=\"saveProfile\" modelAttribute=\"keyValueDto\" -->\r\n");
      out.write("\t<div class=\"container\" style=\"width: 500px; height: 520px; display:block;\" >\r\n");
      out.write("\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t<!-- <div id=\"loginSuccess\" role=\"alert\" class=\"alert alert-warning alert-dismissible fade show\"><p>Login Successfull</p></div> -->\r\n");
      out.write("\t\t\t<h2 style=\"color:black;\">Discover what's Possible</h2>\r\n");
      out.write("\t\t\t<label class=\"roles\" >Role*</label>\r\n");
      out.write("\t\t\t<select class=\"form-control\" id=\"roles\" onchange=\"roleCheck()\" >\r\n");
      out.write("\t\t\t    <option value=\"1\">Applicant</option>\r\n");
      out.write("\t\t\t    <option value=\"2\">Company</option>\r\n");
      out.write("\t\t\t    <option value=\"3\">Counselor</option>\r\n");
      out.write("\t\t\t</select><br>\r\n");
      out.write("\t\t\t<div id=\"applicant\" style=\"display:block;\">\r\n");
      out.write("\t            <form  class=\"form-horizontal\" role=\"form\" style=\"width:710px;height: 680px;\" >\r\n");
      out.write("\t            \t<div class=\"form-group\">\r\n");
      out.write("\t            \t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t            \t\t<input type=\"hidden\" id=\"aroletype\" value=\"1\" name=\"roleId\" path=\"roleId\" />\r\n");
      out.write("\t            \t\t<label for=\"firstname\" class=\"firstname\" >First Name*</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"afirstName\" placeholder=\"First Name\" name=\"fName\" class=\"form-control\" path=\"fName\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"lastname\" class=\"lastname\" >Last Name*</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"alastName\" placeholder=\"Last Name\" name=\"lName\" class=\"form-control\" path=\"lName\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"email\" class=\"email\">Email*</label>\r\n");
      out.write("\t            \t\t<input type=\"email\" id=\"aemail\" placeholder=\"Email\" class=\"form-control\" name=\"email\" path=\"email\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"address\" class=\"address\">Address</label>\r\n");
      out.write("\t            \t\t<input type=\"address\" id=\"alocation\" placeholder=\"Address\" class=\"form-control\" name=\"location\" path=\"location\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"password\" class=\"password\">Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"apassword\" placeholder=\"Password\" class=\"form-control\" name=\"password\" min=\"8\" path=\"password\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"cpassword\" class=\"cpassword\">Confirm Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"aconfirmpassword\" placeholder=\"Confirm Password\" class=\"form-control\" name=\"confirmpassword\" min=\"8\" path=\"confirmpassword\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"phone\" class=\"phone\">Phone No.</label>\r\n");
      out.write("\t            \t\t<input type=\"number\" id=\"aphone\" placeholder=\"Phone Number\" class=\"form-control\" name=\"phone\" maxlength=\"13\" path=\"phone\" /><br>\r\n");
      out.write("\t            \t\t<label class=\"gender\">Gender</label><br>\r\n");
      out.write("\t            \t\t<label class=\"radio-inline\"><input type=\"radio\" path=\"gender\" name=\"gender\" value=\"Male\"/>Male</label>\r\n");
      out.write("\t            \t\t<label class=\"radio-inline\"><input type=\"radio\" path=\"gender\" name=\"gender\" value=\"Female\"/>Female</label><br><br>\r\n");
      out.write("\t                    <label for=\"register\" class=\"forgot-password\" style=\"color:red;\">* Mandatory Fields</label> <br/> \r\n");
      out.write("\t                \t<label for=\"register\" class=\"register\">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href=\"#\">User Agreement</a>,<a href=\"#\"> Privacy Policy</a>, and <a href=\"#\">Cookie Policy</a> -->\r\n");
      out.write("\t            \t\t<button type=\"button\" class=\"btn btn-primary btn-block\" onclick=\"saveProfileDetails()\">Register</button>\r\n");
      out.write("\t            \t\t</div>\r\n");
      out.write("\t            \t</div>\r\n");
      out.write("\t            </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"counsellor\" style=\"display:none;\">\r\n");
      out.write("\t            <form class=\"form-horizontal\" role=\"form\" style=\"width:710px;height: 680px;\" >\r\n");
      out.write("\t            \t<div class=\"form-group\">\r\n");
      out.write("\t            \t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t            \t\t<input type=\"hidden\" id=\"croletype\" value=\"3\" name=\"roleId\" path=\"roleId\"/>\r\n");
      out.write("\t            \t\t<label for=\"firstname\" class=\"firstname\" >First Name*</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"cfirstName\" placeholder=\"First Name\" name=\"fName\" class=\"form-control\" path=\"fName\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"lastname\" class=\"lastname\" >Last Name*</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"clastName\" placeholder=\"Last Name\" name=\"lName\" class=\"form-control\" path=\"lName\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"email\" class=\"email\">Email*</label>\r\n");
      out.write("\t            \t\t<input type=\"email\" id=\"cemail\" placeholder=\"Email\" class=\"form-control\" name=\"email\" path=\"email\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"address\" class=\"address\">Address</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"clocation\" placeholder=\"Address\" class=\"form-control\" name=\"location\" path=\"location\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"password\" class=\"password\">Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"cpassword\" placeholder=\"Password\" class=\"form-control\" name=\"password\" path=\"password\" min=\"8\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"cpassword\" class=\"cpassword\">Confirm Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"cconfirmpassword\" placeholder=\"Confirm Password\" class=\"form-control\" name=\"confirmpassword\" path=\"confirmpassword\" min=\"8\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"phone\" class=\"phone\">Phone No.</label>\r\n");
      out.write("\t            \t\t<input type=\"number\" id=\"cphone\" placeholder=\"Phone Number\" class=\"form-control\" maxlength=\"13\" name=\"phone\" path=\"phone\" /><br>\r\n");
      out.write("\t            \t\t<label class=\"gender\">Gender</label><br>\r\n");
      out.write("\t            \t\t<label class=\"radio-inline\"><input type=\"radio\" path=\"gender\" name=\"gender\" value=\"Male\"/>Male</label>\r\n");
      out.write("\t            \t\t<label class=\"radio-inline\"><input type=\"radio\" path=\"gender\" name=\"gender\" value=\"Female\"/>Female</label><br><br>\r\n");
      out.write("\t                    <label for=\"register\" class=\"forgot-password\" style=\"color:red;\">* Mandatory Fields</label> <br/> \r\n");
      out.write("\t                \t<label for=\"register\" class=\"register\">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href=\"#\">User Agreement</a>,<a href=\"#\"> Privacy Policy</a>, and <a href=\"#\">Cookie Policy</a> -->\r\n");
      out.write("\t            \t\t<button type=\"button\" class=\"btn btn-primary btn-block\" onclick=\"saveProfileDetails()\">Register</button>\r\n");
      out.write("\t            \t\t</div>\r\n");
      out.write("\t            \t</div>\r\n");
      out.write("\t            </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"company\" style=\"display:none;\">\r\n");
      out.write("\t            <form class=\"form-horizontal\" role=\"form\" style=\"width:710px;height: 620px;\" >\r\n");
      out.write("\t            \t<div class=\"form-group\">\r\n");
      out.write("\t            \t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t            \t\t<input type=\"hidden\" id=\"comroletype\" value=\"2\" name=\"roleId\" path=\"roleId\"/>\r\n");
      out.write("\t            \t\t<label for=\"companyname\" class=\"lastname\" >Company Name*</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"companyName\" placeholder=\"company Name\" name=\"lName\" class=\"form-control\" path=\"companyName\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"email\" class=\"email\">Email*</label>\r\n");
      out.write("\t            \t\t<input type=\"email\" id=\"comemail\" placeholder=\"Email\" class=\"form-control\" name=\"email\" path=\"email\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"password\" class=\"password\">Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"compassword\" placeholder=\"Password\" class=\"form-control\" name=\"password\" path=\"password\" min=\"8\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"cpassword\" class=\"cpassword\">Confirm Password*</label>\r\n");
      out.write("\t            \t\t<input type=\"password\" id=\"comconfirmpassword\" placeholder=\"Confirm Password\" class=\"form-control\" name=\"confirmpassword\" path=\"confirmpassword\" min=\"8\"/><br>\r\n");
      out.write("\t            \t\t<label for=\"phone\" class=\"phone\">Phone No.</label>\r\n");
      out.write("\t            \t\t<input type=\"number\" id=\"comphone\" placeholder=\"Phone Number\" class=\"form-control\" maxlength=\"13\" name=\"phone\" path=\"phone\" /><br>\r\n");
      out.write("\t            \t\t<label for=\"location\" class=\"location\">Location</label>\r\n");
      out.write("\t            \t\t<input type=\"text\" id=\"comlocation\" placeholder=\"Location\" class=\"form-control\" name=\"location\" path=\"location\" /><br>\r\n");
      out.write("\t                    <label for=\"register\" class=\"forgot-password\" style=\"color:red;\">* Mandatory Fields</label> <br/> \r\n");
      out.write("\t                \t<label for=\"register\" class=\"register\">By clicking Register, you agree to the CareerGo</label> <!-- <br/> <a href=\"#\">User Agreement</a>,<a href=\"#\"> Privacy Policy</a>, and <a href=\"#\">Cookie Policy</a> -->\r\n");
      out.write("\t            \t\t<button type=\"button\" class=\"btn btn-primary btn-block\" onclick=\"saveProfileDetails()\">Register</button>\r\n");
      out.write("\t            \t\t</div>\r\n");
      out.write("\t            \t</div>\r\n");
      out.write("\t            </form>\r\n");
      out.write("            </div>\r\n");
      out.write("       </div> \r\n");
      out.write("\t</div>\r\n");
      out.write("      \r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/resources/bootstrap/css/home.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/resources/bootstrap/js/Jquery.js");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setValue("/resources/bootstrap/css/toastr.css");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setValue("/resources/bootstrap/js/toastr.js");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/resources/bootstrap/js/toastr.min.js");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/resources/bootstrap/images/CareerGoLogo.png");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }
}
