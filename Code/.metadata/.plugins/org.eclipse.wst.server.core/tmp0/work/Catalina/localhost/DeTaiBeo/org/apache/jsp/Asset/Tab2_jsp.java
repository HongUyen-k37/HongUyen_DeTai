/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2017-03-29 14:49:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Asset;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Tab2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/struts-logic.tld", Long.valueOf(1488280238644L));
    _jspx_dependants.put("/WEB-INF/struts-html.tld", Long.valueOf(1488280238644L));
    _jspx_dependants.put("/WEB-INF/struts-bean.tld", Long.valueOf(1488280238634L));
    _jspx_dependants.put("/WEB-INF/struts-tiles.tld", Long.valueOf(1488280238644L));
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"main-nav row\">\r\n");
      out.write("\t<div class=\"title-content\">\r\n");
      out.write("\t\t<div class=\"title-left col-md-6\">\r\n");
      out.write("\t\t\t<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>\r\n");
      out.write("\t\t\t<h6>HỘI ĐỒNG TUYỂN SINH NĂM 2017</h6>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"title-right col-md-6\">\r\n");
      out.write("\t\t\t<h5>BIÊN BẢN THU BÀI THI</h5>\r\n");
      out.write("\t\t\t<h6>Môn:................</h6>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"col-md-10\" style=\"text-align: center\">\t\r\n");
      out.write("\t\t\t\t<p>Ngành: <span>Báo chí</span></p>\r\n");
      out.write("\t\t\t\t<p>Điểm thi: Trường Trung cấp Đam San - Đắk Lắk</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"numberroom col-md-2\">\r\n");
      out.write("\t\t<p>Phòng thi: <span>01</span></p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"room-info\">\r\n");
      out.write("\t\t<table class=\"table table-bordered table-hover table-striped\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>STT</th>\r\n");
      out.write("\t\t\t\t<th>Họ và tên</th>\r\n");
      out.write("\t\t\t\t<th>Ngày sinh</th>\r\n");
      out.write("\t\t\t\t<th>SBD</th>\r\n");
      out.write("\t\t\t\t<th>Số tờ</th>\r\n");
      out.write("\t\t\t\t<th>Ký tên</th>\r\n");
      out.write("\t\t\t\t<th>Ghi chú</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>Trần Nữ Như Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td>26/05/1995</td>\r\n");
      out.write("\t\t\t\t<td>123</td>\r\n");
      out.write("\t\t\t\t<td>02</td>\r\n");
      out.write("\t\t\t\t<td>Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>Trần Nữ Như Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td>26/05/1995</td>\r\n");
      out.write("\t\t\t\t<td>123</td>\r\n");
      out.write("\t\t\t\t<td>02</td>\r\n");
      out.write("\t\t\t\t<td>Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>Trần Nữ Như Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td>26/05/1995</td>\r\n");
      out.write("\t\t\t\t<td>123</td>\r\n");
      out.write("\t\t\t\t<td>02</td>\r\n");
      out.write("\t\t\t\t<td>Quỳnh</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t<div class=\"row totalCandidates\">\r\n");
      out.write("\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t<p>Tổng cộng danh sách có ... bài thi và ... tờ giấy thi.</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" style=\"text-align: center\">\r\n");
      out.write("\t\t\t<p>Cán bộ coi thi 1</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" style=\"text-align: center\">\r\n");
      out.write("\t\t\t<p>Cán bộ coi thi 2</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-6 btn-group\" style=\"text-align: center\">\r\n");
      out.write("\t\t\t<p>Thừa Thiên Huế, ngày 10 tháng 12 năm 2016</p>\r\n");
      out.write("\t\t\t<p>Trưởng ban coi thi</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
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
