
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<link rel="stylesheet" type="text/css" href="css/style_index.css" />
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery.min.js"></script>
	<title>Tuyển sinh</title>
</head>
<body>
	<div id="container">
		<!--Header -->
		<div id="header">
			<p>CHƯƠNG TRÌNH QUẢN LÝ TUYỂN SINH ĐẠI HỌC HỆ KHÔNG CHÍNH QUY</p>
		</div>
		<!-- navBar -->
		<div id="navBar">
			<div id="menu">
				<ul>
					<li><a href="#">Trang chủ</a></li>
					<li> <a href="#">Hướng dẫn-Hỗ trợ </a></li>
					
				</ul>
			</div>
		</div>
		<!-- sidebar-->
		<div id="sidebar">
			<div class="login">
				<form method="post" action="home.php">
			    <div class="form-group">
			      <label for="user">Tên đăng nhập:</label>
			      <input type="text" class="form-control" name="user" placeholder="Nhập tên đăng nhập">
			      
			    </div>
			    <div class="form-group">
			      <label for="pwd">Mật khẩu:</label>
			      <input type="password" class="form-control" name="pwd" placeholder="Nhập mật khẩu">
			      
			    </div>
			    <button type="submit" class="btn btn-success" name='login'>Đăng nhập</button>
			 	</form>
			 	<span id="message"></span>
			</div>		
			
		</div>
		<!-- content -->
		<div id="content">Content
		</div>
		<div class="clear"></div>
		<!-- footer -->
		<div id="footer">
			<p> &copy; Bản quyền Trường Đại Học Khoa Học Huế </p>
		</div>
	</div>
	<script type="text/javascript">
	$('#menu li').hover(
  		function() {
   		 $('ul', this).stop().slideDown(200);
 		 },
  		function() {
   		 $('ul', this).stop().slideUp(200);
 		 }
	);
	</script>
</body>
</html>