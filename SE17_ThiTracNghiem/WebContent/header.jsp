<%@page import="model.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no, minimal-ui" />
    <!-- CSS -->
    <title>Trắc nghiệm trực tuyến</title>
    <!-- Bx-Slider StyleSheet CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- <link href="css/flat-ui.min.css" rel="stylesheet"> -->
    <link href="css/bootflat.min.css" rel="stylesheet">
    <link href="css/customize.css" rel="stylesheet">
    <!-- <link href="css/NameNguoiCode.css" rel="stylesheet"> -->
    <!-- Ví dụ: <link href="css/DucTT.css" rel="stylesheet">-->
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/icheck.min.js"></script>
    <script src="js/jquery.fs.selecter.min.js"></script>
    <script src="js/jquery.fs.stepper.min.js"></script>
    
</head>
<body>
<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".menu-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="./"><img src="img/Logo-4.png"></a>
            </div>
    
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse menu-collapse">
                <ul class="nav navbar-nav menu-list">
                    <li><a href="Home.do">Trang chủ</a></li>
                    <li class=""><a href="BaiThi.do">Bài Thi</a></li>
                    <logic:notEmpty name="user" scope="session">
	                    <logic:equal name="user" property="role" value="2" scope="session">
		                    <li><a href="QuanLyBaiThi.do">Quản lý bài thi</a></li>
		            		<li><a href="QuanLyCauHoi.do">Quản lý câu hỏi</a></li>
	            		</logic:equal>
	            		<logic:equal name="user" property="role" value="1" scope="session">
	                   		<li><a href="QuanLyThanhVien.do">Quản lý thành viên</a></li>
	            		</logic:equal>
            		</logic:notEmpty>
            		<li><a href="ThongKe.do">Bảng xếp hạng</a></li>
                    <li class=""><a href="#">Giúp đỡ</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <logic:empty name="user" scope="session">
                    <li class="login account">
                    	<a href="javascript:void(0)" id="account">Đăng nhập</a>
				        <div class="form-account">
							<div class="toggle-account glyphicon glyphicon-pencil">
							</div>
							<form method="post" action="DangNhap.do" class="login">
								<span>Đăng nhập tài khoản</span>
								<input type="hidden" name="url" value="">
								<input type="text" placeholder="Username" class="form-control" name="username" required maxLength="50"/>
								<input type="password" placeholder="Password" class="form-control" name="password" required/>
								<button type="submit" name='log-click'>Login</button>
							</form>
							<form method="post" action="DangKy.do" class="register">
								<span>Tạo tài khoản mới</span>
								<input type="text" placeholder="Username" class="form-control" name="user"  required/>
								<input type="password" placeholder="Password" class="form-control" name="pass"  required/>
								<input type="email" placeholder="Email Address" class="form-control" name="mail" required/>
								<p class="error"></p>
								<button type="submit" name="reg-click">Register</button>
							</form>
							<a href="#">Forgot your password?</a>
						</div>
                    </li>
                    </logic:empty>
                   	<logic:notEmpty name="user" scope="session">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><bean:write name="user" property="hoTen" scope="session"/> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="CaNhan.do">Cá nhân</a></li>
                            <logic:equal name="user" property="role" value="2" scope="session">
                            <li><a href="TKBaiThi.do">Thống kê bài thi</a></li>
                            </logic:equal>
                            <li>
                            	<a href="javascript:void()" onclick="document.forms.dangXuat.submit()">Đăng xuất</a>
                            </li>
                            
                        </ul>
                        
                    </li>
                    </logic:notEmpty>
                </ul>
            </div>
        </div>
    </nav>
   <form method="post" action="DangXuat.do" id="dangXuat"><input type="hidden" name="url" value=""></form>
   
</header>