/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.42
 * Generated at: 2017-04-03 15:00:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DonTui_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Tuyển sinh</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Asset/Head.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Asset/Header.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Asset/Menu2.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("\t<div class=\"col-md-4 no-pad\">\r\n");
      out.write("\t\t<div class=\"thongtinkithi group-content\">\r\n");
      out.write("\t\t\t<div class=\"main-nav\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Asset/ThongTinKyThi.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t<div class=\"group-content\">\r\n");
      out.write("\t\t\t<div class=\"row main-nav\">\r\n");
      out.write("\t\t<p class=\"title\">DỒN TÚI</p>\r\n");
      out.write("<form>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-5 form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"col-md-5\">Cơ số phòng:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-7\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" name=\"cosophong\" min=\"1\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-5 form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"col-md-5\">Cơ số túi:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-7 no-pad\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" name=\"cosotui\" min=\"1\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"btn-gr col-md-2\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-success btn-all\" name=\"execute\">Tính số lượt</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-3 form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label>Lượt:</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-9\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"number\" name=\"luot\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 no-pad form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label>/Số lượt thực hiện:</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 no-pad\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"soluot\">\r\n");
      out.write("\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-success btn-all\" name=\"execute\">Thực hiện</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div class=\"details_info\">\r\n");
      out.write("\t\t\t<table class=\"table table-bordered table-hover table-striped\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">Phòng 1</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">Phòng 2</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">Phòng 3</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">Phòng 4</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">Phòng 5</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t\t<th>Số phách</th>\r\n");
      out.write("\t\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t\t<th>Số phách</th>\r\n");
      out.write("\t\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t\t<th>Số phách</th>\r\n");
      out.write("\t\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t\t<th>Số phách</th>\r\n");
      out.write("\t\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t\t<th>Số phách</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Túi 1</th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td>002</td>\r\n");
      out.write("\t\t\t\t\t\t<td>168</td>\r\n");
      out.write("\t\t\t\t\t\t<td>003</td>\r\n");
      out.write("\t\t\t\t\t\t<td>169</td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td>005</td>\r\n");
      out.write("\t\t\t\t\t\t<td>171</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td>002</td>\r\n");
      out.write("\t\t\t\t\t\t<td>168</td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td>005</td>\r\n");
      out.write("\t\t\t\t\t\t<td>171</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Túi 2</th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td>002</td>\r\n");
      out.write("\t\t\t\t\t\t<td>168</td>\r\n");
      out.write("\t\t\t\t\t\t<td>003</td>\r\n");
      out.write("\t\t\t\t\t\t<td>169</td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td>005</td>\r\n");
      out.write("\t\t\t\t\t\t<td>171</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Túi 3</th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td>002</td>\r\n");
      out.write("\t\t\t\t\t\t<td>168</td>\r\n");
      out.write("\t\t\t\t\t\t<td>003</td>\r\n");
      out.write("\t\t\t\t\t\t<td>169</td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td>005</td>\r\n");
      out.write("\t\t\t\t\t\t<td>171</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Túi 4</th>\r\n");
      out.write("\t\t\t\t\t\t<td>001</td>\r\n");
      out.write("\t\t\t\t\t\t<td>167</td>\r\n");
      out.write("\t\t\t\t\t\t<td>002</td>\r\n");
      out.write("\t\t\t\t\t\t<td>168</td>\r\n");
      out.write("\t\t\t\t\t\t<td>003</td>\r\n");
      out.write("\t\t\t\t\t\t<td>169</td>\r\n");
      out.write("\t\t\t\t\t\t<td>004</td>\r\n");
      out.write("\t\t\t\t\t\t<td>170</td>\r\n");
      out.write("\t\t\t\t\t\t<td>005</td>\r\n");
      out.write("\t\t\t\t\t\t<td>171</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<p class=\"col-md-10\">Danh sách gồm có: <span> 50/100 </span> sinh viên</p>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2\"><button type=\"submit\" class=\"btn btn-success btn-all\" name=\"execute\">In dồn túi</button></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Asset/Footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
